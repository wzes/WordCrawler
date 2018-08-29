# Word Frequency Crawler





## Distributed Service

### Dispatcher

调度器，每个 IP 地址在一段时间内获取的 URL 类型不同，并且可配置限流，存储外链

工具：Spring cloud + Spring boot + Redis

- URL 去重，使用 Bloomfilter 算法去重，可存储 1 << 31 条记录

- URL 过滤，使用 Bloomfilter 算法过滤，可存储 1 << 31 条记录

- URL 放行，使用 Bloomfilter 算法检测，可存储 1 << 31 条记录

- 限流策略：RateLimiter 限流，针对每一个 IP，某一类型 URL，时间间隔 > threshold

  存储每个 IP + Domain 为 Key，上次使用时间为 Value 的字段在 Redis，可以使用一个随机函数进行读取 URL，如果读到的 URL 符合条件，则返回给后端，如果不存在，则重新读取一条数据返回

- URL 队列，存放所有需要爬取的 URL




### Cleaner

清理器，清除不符合要求的 URL 类型，放入到过滤池中，如果某一类页面出现的次数大于 threshold_1，计算字数，如果字数少于 threshold_2，那么将此类型的 url 放入过滤池，之后此类 url 不在进行爬取

###### 关于 url 类型的判断，可在内存中做（单节点）；如果是多节点，那么就在 redis 里面做

`https://www.jianshu.com/p/9f6bab6bfdb5` 提取最后一个 `/` 之前的 URL 作为类型



#### 算法步骤

首先检测 URL 是否在去重队列，再次检测 URL 类型是否在放行队列，如果都不在，则放入 HashMap 进行累加，如果发现某一类型的数据条目 > threshold_3，则计算个数，符合条件就放它放入放行队列，不符合的话就放入过滤队列

实现： BloomFilter + MQ (负载均衡)



## Crawler Service

### Engine

爬虫中心，从服务中心获取 URL

```
GET / HTTP/1.1
HOST: ip:port
```



### Downloader

网页下载器，根据页面类型自动选择下载器下载

输入：url

返回：页面 html

**工具**：`HtmlUnit`


### Extractor

内容提取器，提取中文，外链等内容，去除图片等不相关数据

- **工具**：`Jsoup`



### Pipeline

负责保存内容，主要是中文文本

#### Result Pipeline

将 URL + 文本字数反馈给远程服务 Cleaner，一个页面

上传数据

```
{"url":"", "word_count":0}
```



#### Data Pipeline

在本地存储数据，文件目录以顶级域名命名全拼命名，例如百度网页的 `url` 以 `baidu.com` 命名

###### data format

文件名：`url.txt`

文件内容：该网页的中文文本



## Word Frequency Service

### Word Handler

文字处理器，使用中文分词器进行处理，将处理结果进行保存，可保存到文件，最后使用其他工具再进行处理

###### data format

```
url word frequency date
```





# Deploy

- RabbitMQ-server 一个节点

  ```
  spring.rabbitmq.host=localhost
  spring.rabbitmq.port=5672
  spring.rabbitmq.username=iflide
  spring.rabbitmq.password=iflide
  iflide.queue.crawler.page.info=iflide-crawler-page-info
  iflide.queue.crawler.url.upload=iflide-crawler-url-upload
  ```

  

- redis-server 一个节点

  ```
  spring.redis.port=6379
  ```

  

- crawler-0.0.1-service.jar 服务中心

  ```
  java -jar crawler-0.0.1-service.jar
  ```

  

- crawler-0.0.1-node.jar 爬虫中心

  ```
  java -jar crawler-0.0.1-node.jar --server.port=port
  ```



提供一个部署脚本

```
crawler [command] [option] [args]

	 command : start #start spider
 	         : stop  #stop spider
	 option  : -n    #the nums of node
	         : -h    #help
	 args    : 10    #number of node
```



```
#!/bin/bash

start() {
	echo "the nums of node is $1"
    num=$1
	# start service
	nohup java -jar crawler-0.0.1-service.jar &

	sleep 10s
	# start node
	for i in $(seq 1 $num)  
	do   
		nohup java -jar crawler-0.0.1-node.jar --server.port=808$i &
	done
}

stop() {
    # kill process
    ps -ef | grep crawler | grep -v grep |awk '{print $2}' | xargs sudo kill -9
}

help() {
    echo "crawler [command] [option] [args]"
    echo ""
    echo "	 command : start #start spider"
    echo " 	         : stop  #stop spider"
    echo "	 option  : -n    #the nums of node"
    echo "	         : -h    #help"
    echo "	 args    : 10    #number of node"
}

if [ "start" = "$1" ] ;then
    echo "crawler start....."
elif [ "stop" = "$1" ] ;then
	stop
	echo "crawler stop....."
fi

ARGS=`getopt -o hvn: --long help,version,nlong: -- "$@"`
if [ $? != 0 ] ; then echo "Terminating..." >&2 ; exit 1 ; fi
eval set -- "$ARGS"
while true;do
    case "$1" in
        -n|--nlong)
            start $2
            shift 2
            ;;
        -v|--version)
            echo "iflide.cralwer 0.0.1"
            shift
            ;;
        -h|--help)
            help
            shift
            ;;
        --)
            shift
            break
            ;;
        *) 
            echo "unknown args:{$1}"
            exit 1
            ;;
    esac
done
```

### TODO
#### Page Classifier
判断一个页面的类型，最好能自动识别是否是 AJAX 网页，然后分不同策略进行下载
