package com.iflide.crawler.crawler;

import com.iflide.crawler.model.Url;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Create by xuantang
 * @date on 9/3/18
 */
public class ExtractorTest {

    Extractor extractor = new Extractor();
    @Test
    public void getAllLinks() {
        List<Url> urlList =  extractor.getAllLinks("https://www.jianshu.com/u/subscriptions", "<!DOCTYPE html>\n" +
                "<!--[if IE 6]><html class=\"ie lt-ie8\"><![endif]-->\n" +
                "<!--[if IE 7]><html class=\"ie lt-ie8\"><![endif]-->\n" +
                "<!--[if IE 8]><html class=\"ie ie8\"><![endif]-->\n" +
                "<!--[if IE 9]><html class=\"ie ie9\"><![endif]-->\n" +
                "<!--[if !IE]><!--> <html> <!--<![endif]-->\n" +
                "\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0,user-scalable=no\">\n" +
                "\n" +
                "  <!-- Start of Baidu Transcode -->\n" +
                "  <meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\n" +
                "  <meta http-equiv=\"Cache-Control\" content=\"no-transform\" />\n" +
                "  <meta name=\"applicable-device\" content=\"pc,mobile\">\n" +
                "  <meta name=\"MobileOptimized\" content=\"width\"/>\n" +
                "  <meta name=\"HandheldFriendly\" content=\"true\"/>\n" +
                "  <meta name=\"mobile-agent\" content=\"format=html5;url=https://www.jianshu.com/u/c38a29bd2e6d\">\n" +
                "  <!-- End of Baidu Transcode -->\n" +
                "\n" +
                "    <meta name=\"description\"  content=\"一只想了解源码的渣渣\">\n" +
                "\n" +
                "  <meta name=\"360-site-verification\" content=\"604a14b53c6b871206001285921e81d8\" />\n" +
                "  <meta property=\"wb:webmaster\" content=\"294ec9de89e7fadb\" />\n" +
                "  <meta property=\"qc:admins\" content=\"104102651453316562112116375\" />\n" +
                "  <meta property=\"qc:admins\" content=\"11635613706305617\" />\n" +
                "  <meta property=\"qc:admins\" content=\"1163561616621163056375\" />\n" +
                "  <meta name=\"google-site-verification\" content=\"cV4-qkUJZR6gmFeajx_UyPe47GW9vY6cnCrYtCHYNh4\" />\n" +
                "  <meta name=\"google-site-verification\" content=\"HF7lfF8YEGs1qtCE-kPml8Z469e2RHhGajy6JPVy5XI\" />\n" +
                "  <meta http-equiv=\"mobile-agent\" content=\"format=html5; url=https://www.jianshu.com/u/c38a29bd2e6d\">\n" +
                "\n" +
                "  <!-- Apple -->\n" +
                "  <meta name=\"apple-mobile-web-app-title\" content=\"简书\">\n" +
                "\n" +
                "  \n" +
                "\n" +
                "    <title>为战而生C - 简书</title>\n" +
                "\n" +
                "  <meta name=\"csrf-param\" content=\"authenticity_token\" />\n" +
                "<meta name=\"csrf-token\" content=\"uzbaFwhuWnkMK6MRAeOaJUKU43MdOj3Lnffi8OfuE5VA+w5JEEkjiHb4bMZquMzqV4kts9zAxsPkaP5fW0LGbg==\" />\n" +
                "\n" +
                "  <link rel=\"stylesheet\" media=\"all\" href=\"//cdn2.jianshu.io/assets/web-d5108cec60c4ed55f041.css\" />\n" +
                "  \n" +
                "  <link rel=\"stylesheet\" media=\"all\" href=\"//cdn2.jianshu.io/assets/web/pages/users/show/entry-8e775d8bb60eed8c1bc2.css\" />\n" +
                "\n" +
                "  <link href=\"//cdn2.jianshu.io/assets/favicons/favicon-e743bfb1821442341c3ab15bdbe804f7ad97676bd07a770ccc9483473aa76f06.ico\" rel=\"shortcut icon\" type=\"image/x-icon\">\n" +
                "      <link rel=\"apple-touch-icon-precomposed\" href=\"//cdn2.jianshu.io/assets/apple-touch-icons/57-a6f1f1ee62ace44f6dc2f6a08575abd3c3b163288881c78dd8d75247682a4b27.png\" sizes=\"57x57\" />\n" +
                "      <link rel=\"apple-touch-icon-precomposed\" href=\"//cdn2.jianshu.io/assets/apple-touch-icons/72-fb9834bcfce738fd7b9c5e31363e79443e09a81a8e931170b58bc815387c1562.png\" sizes=\"72x72\" />\n" +
                "      <link rel=\"apple-touch-icon-precomposed\" href=\"//cdn2.jianshu.io/assets/apple-touch-icons/76-49d88e539ff2489475d603994988d871219141ecaa0b1a7a9a1914f4fe3182d6.png\" sizes=\"76x76\" />\n" +
                "      <link rel=\"apple-touch-icon-precomposed\" href=\"//cdn2.jianshu.io/assets/apple-touch-icons/114-24252fe693524ed3a9d0905e49bff3cbd0228f25a320aa09053c2ebb4955de97.png\" sizes=\"114x114\" />\n" +
                "      <link rel=\"apple-touch-icon-precomposed\" href=\"//cdn2.jianshu.io/assets/apple-touch-icons/120-1bb7371f5e87f93ce780a5f1a05ff1b176828ee0d1d130e768575918a2e05834.png\" sizes=\"120x120\" />\n" +
                "      <link rel=\"apple-touch-icon-precomposed\" href=\"//cdn2.jianshu.io/assets/apple-touch-icons/152-bf209460fc1c17bfd3e2b84c8e758bc11ca3e570fd411c3bbd84149b97453b99.png\" sizes=\"152x152\" />\n" +
                "\n" +
                "  <!-- Start of 访问统计 -->\n" +
                "    <script>\n" +
                "    var _hmt = _hmt || [];\n" +
                "    (function() {\n" +
                "      var hm = document.createElement(\"script\");\n" +
                "      hm.src = \"//hm.baidu.com/hm.js?0c0e9d9b1e7d617b3e6842e85b9fb068\";\n" +
                "      var s = document.getElementsByTagName(\"script\")[0];\n" +
                "      s.parentNode.insertBefore(hm, s);\n" +
                "    })();\n" +
                "  </script>\n" +
                "\n" +
                "  <!-- End of 访问统计 -->\n" +
                "</head>\n" +
                "\n" +
                "  <body lang=\"zh-CN\" class=\"reader-black-font\">\n" +
                "    <!-- 全局顶部导航栏 -->\n" +
                "<nav class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\">\n" +
                "  <div class=\"width-limit\">\n" +
                "    <!-- 左上方 Logo -->\n" +
                "    <a class=\"logo\" href=\"/\"><img src=\"//cdn2.jianshu.io/assets/web/nav-logo-4c7bbafe27adc892f3046e6978459bac.png\" alt=\"Nav logo\" /></a>\n" +
                "\n" +
                "    <!-- 右上角 -->\n" +
                "      <!-- 登录显示写文章 -->\n" +
                "      <a class=\"btn write-btn\" target=\"_blank\" href=\"/writer#/\">\n" +
                "        <i class=\"iconfont ic-write\"></i>写文章\n" +
                "</a>\n" +
                "    <!-- 如果用户登录，显示下拉菜单 -->\n" +
                "      <div class=\"user\">\n" +
                "        <div data-hover=\"dropdown\">\n" +
                "          <a class=\"avatar\" href=\"/u/c38a29bd2e6d\"><img src=\"//upload.jianshu.io/users/upload_avatars/7117641/5f390749-5ef8-4975-8293-3fe1cb714e54?imageMogr2/auto-orient/strip|imageView2/1/w/120/h/120\" alt=\"120\" /></a>\n" +
                "        </div>\n" +
                "        <ul class=\"dropdown-menu\">\n" +
                "          <li>\n" +
                "            <a href=\"/u/c38a29bd2e6d\">\n" +
                "              <i class=\"iconfont ic-navigation-profile\"></i><span>我的主页</span>\n" +
                "</a>          </li>\n" +
                "          <li>\n" +
                "            <!-- TODO bookmarks_path -->\n" +
                "            <a href=\"/bookmarks\">\n" +
                "              <i class=\"iconfont ic-navigation-mark\"></i><span>收藏的文章</span>\n" +
                "</a>          </li>\n" +
                "          <li>\n" +
                "            <a href=\"/users/c38a29bd2e6d/liked_notes\">\n" +
                "              <i class=\"iconfont ic-navigation-like\"></i><span>喜欢的文章</span>\n" +
                "</a>          </li>\n" +
                "          <li>\n" +
                "            <a href=\"/my/paid_notes\">\n" +
                "              <i class=\"iconfont ic-paid\"></i><span>已购内容</span>\n" +
                "</a>          </li>\n" +
                "          <li>\n" +
                "            <a href=\"/wallet\">\n" +
                "              <i class=\"iconfont ic-navigation-wallet\"></i><span>我的钱包</span>\n" +
                "</a>          </li>\n" +
                "          <li>\n" +
                "            <a href=\"/settings\">\n" +
                "              <i class=\"iconfont ic-navigation-settings\"></i><span>设置</span>\n" +
                "</a>          </li>\n" +
                "          <li>\n" +
                "            <a href=\"/faqs\">\n" +
                "              <i class=\"iconfont ic-navigation-feedback\"></i><span>帮助与反馈</span>\n" +
                "</a>          </li>\n" +
                "          <li>\n" +
                "            <a rel=\"nofollow\" data-method=\"delete\" href=\"/sign_out\">\n" +
                "              <i class=\"iconfont ic-navigation-signout\"></i><span>退出</span>\n" +
                "</a>          </li>\n" +
                "        </ul>\n" +
                "      </div>\n" +
                "\n" +
                "    <div id=\"view-mode-ctrl\">\n" +
                "    </div>\n" +
                "    <div class=\"container\">\n" +
                "      <div class=\"navbar-header\">\n" +
                "        <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#menu\" aria-expanded=\"false\">\n" +
                "          <span class=\"icon-bar\"></span>\n" +
                "          <span class=\"icon-bar\"></span>\n" +
                "          <span class=\"icon-bar\"></span>\n" +
                "        </button>\n" +
                "      </div>\n" +
                "      <div class=\"collapse navbar-collapse\" id=\"menu\">\n" +
                "        <ul class=\"nav navbar-nav\">\n" +
                "            <li class=\"tab \">\n" +
                "              <a href=\"/\">\n" +
                "                <span class=\"menu-text\">发现</span><i class=\"iconfont ic-navigation-discover menu-icon\"></i>\n" +
                "</a>            </li>\n" +
                "            <li class=\"tab \">\n" +
                "              <a href=\"/subscriptions\">\n" +
                "                <span class=\"menu-text\">关注</span><i class=\"iconfont ic-navigation-follow menu-icon\"></i>\n" +
                "</a>            </li>\n" +
                "            <li class=\"tab notification v-notification-dropdown-menu \">\n" +
                "              <a class=\"notification-btn\" href=\"/notifications\" data-hover=\"dropdown\">\n" +
                "                <span class=\"menu-text\">消息</span>\n" +
                "                <i class=\"iconfont ic-navigation-notification menu-icon\"></i>\n" +
                "                <span class=\"badge\"></span>\n" +
                "              </a>\n" +
                "            </li>\n" +
                "          <li class=\"search\">\n" +
                "            <form target=\"_blank\" action=\"/search\" accept-charset=\"UTF-8\" method=\"get\"><input name=\"utf8\" type=\"hidden\" value=\"&#x2713;\" />\n" +
                "              <input type=\"text\" name=\"q\" id=\"q\" value=\"\" autocomplete=\"off\" placeholder=\"搜索\" class=\"search-input\" />\n" +
                "              <a class=\"search-btn\" href=\"javascript:void(null)\"><i class=\"iconfont ic-search\"></i></a>\n" +
                "</form>          </li>\n" +
                "        </ul>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</nav>\n" +
                "\n" +
                "    \n" +
                "\n" +
                "<div class=\"container person\">\n" +
                "  <div class=\"row\">\n" +
                "    <div class=\"col-xs-16 main\">\n" +
                "      <div class=\"main-top\">\n" +
                "\n" +
                "  <a class=\"avatar\" href=\"/u/c38a29bd2e6d\">\n" +
                "    <img src=\"//upload.jianshu.io/users/upload_avatars/7117641/5f390749-5ef8-4975-8293-3fe1cb714e54?imageMogr2/auto-orient/strip|imageView2/1/w/240/h/240\" alt=\"240\" />\n" +
                "</a>\n" +
                "\n" +
                "  <div class=\"title\">\n" +
                "    <a class=\"name\" href=\"/u/c38a29bd2e6d\">为战而生C</a>\n" +
                "      <i class=\"iconfont ic-man\"></i>\n" +
                "  </div>\n" +
                "  <div class=\"info\">\n" +
                "    <ul>\n" +
                "      <li>\n" +
                "        <div class=\"meta-block\">\n" +
                "          <a href=\"/users/c38a29bd2e6d/following\">\n" +
                "            <p>75</p>\n" +
                "            关注 <i class=\"iconfont ic-arrow\"></i>\n" +
                "</a>        </div>\n" +
                "      </li>\n" +
                "      <li>\n" +
                "        <div class=\"meta-block\">\n" +
                "          <a href=\"/users/c38a29bd2e6d/followers\">\n" +
                "            <p>3</p>\n" +
                "            粉丝 <i class=\"iconfont ic-arrow\"></i>\n" +
                "</a>        </div>\n" +
                "      </li>\n" +
                "      <li>\n" +
                "        <div class=\"meta-block\">\n" +
                "          <a href=\"/u/c38a29bd2e6d\">\n" +
                "            <p>27</p>\n" +
                "            文章 <i class=\"iconfont ic-arrow\"></i>\n" +
                "</a>        </div>\n" +
                "      </li>\n" +
                "      <li>\n" +
                "        <div class=\"meta-block\">\n" +
                "          <p>21655</p>\n" +
                "          <div>字数</div>\n" +
                "        </div>\n" +
                "      </li>\n" +
                "      <li>\n" +
                "        <div class=\"meta-block\">\n" +
                "          <p>35</p>\n" +
                "          <div>收获喜欢</div>\n" +
                "        </div>\n" +
                "      </li>\n" +
                "    </ul>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "      <ul class=\"trigger-menu\" data-pjax-container=\"#list-container\"><li class=\"active\"><a href=\"/u/c38a29bd2e6d?order_by=shared_at\"><i class=\"iconfont ic-articles\"></i> 文章</a></li><li class=\"\"><a href=\"/users/c38a29bd2e6d/timeline\"><i class=\"iconfont ic-feed\"></i> 动态</a></li><li class=\"\"><a href=\"/u/c38a29bd2e6d?order_by=commented_at\"><i class=\"iconfont ic-latestcomments\"></i> 最新评论</a></li><li class=\"\"><a href=\"/u/c38a29bd2e6d?order_by=top\"><i class=\"iconfont ic-hot\"></i> 热门</a></li></ul>\n" +
                "\n" +
                "      <div id=\"list-container\">\n" +
                "        <!-- 文章列表模块 -->\n" +
                "<ul class=\"note-list\" infinite-scroll-url=\"/u/c38a29bd2e6d?order_by=shared_at\">\n" +
                "    \n" +
                "\n" +
                "<li id=\"note-33130538\" data-note-id=\"33130538\" class=\"\">\n" +
                "  <div class=\"content\">\n" +
                "    <a class=\"title\" target=\"_blank\" href=\"/p/9a3478698aba\">Android OkHttp3 源码解析 CallServerInterceptor（六）</a>\n" +
                "    <p class=\"abstract\">\n" +
                "      前言 激动人心的时刻将要来了，我们将会看到数据是怎么在客户端服务端之间进行交互的，但是再此之前，我们有必要了解一下 socket 纠结是什么东西...\n" +
                "    </p>\n" +
                "    <div class=\"meta\">\n" +
                "      <a target=\"_blank\" href=\"/p/9a3478698aba\">\n" +
                "        <i class=\"iconfont ic-list-read\"></i> 0\n" +
                "</a>        <a target=\"_blank\" href=\"/p/9a3478698aba#comments\">\n" +
                "          <i class=\"iconfont ic-list-comments\"></i> 0\n" +
                "</a>      <span><i class=\"iconfont ic-list-like\"></i> 0</span>\n" +
                "      <span class=\"time\" data-shared-at=\"2018-09-01T00:00:26+08:00\"></span>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</li>\n" +
                "\n" +
                "    \n" +
                "\n" +
                "<li id=\"note-33044954\" data-note-id=\"33044954\" class=\"\">\n" +
                "  <div class=\"content\">\n" +
                "    <a class=\"title\" target=\"_blank\" href=\"/p/6cadb3e5621d\">Android OkHttp3 源码解析 ConnectInterceptor（五）</a>\n" +
                "    <p class=\"abstract\">\n" +
                "      前言 几天过去了，之前我们依次学习了 RetryAndFollowUpInterceptor、BridgeInterceptor、CacheIn...\n" +
                "    </p>\n" +
                "    <div class=\"meta\">\n" +
                "      <a target=\"_blank\" href=\"/p/6cadb3e5621d\">\n" +
                "        <i class=\"iconfont ic-list-read\"></i> 0\n" +
                "</a>        <a target=\"_blank\" href=\"/p/6cadb3e5621d#comments\">\n" +
                "          <i class=\"iconfont ic-list-comments\"></i> 0\n" +
                "</a>      <span><i class=\"iconfont ic-list-like\"></i> 0</span>\n" +
                "      <span class=\"time\" data-shared-at=\"2018-08-30T22:22:51+08:00\"></span>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</li>\n" +
                "\n" +
                "    \n" +
                "\n" +
                "<li id=\"note-33021973\" data-note-id=\"33021973\" class=\"\">\n" +
                "  <div class=\"content\">\n" +
                "    <a class=\"title\" target=\"_blank\" href=\"/p/dc769fd99c10\">Android OkHttp3 源码解析 CacheInterceptor（四）</a>\n" +
                "    <p class=\"abstract\">\n" +
                "      前言 桥接 Interceptor 之后就是缓存 Interceptor 了，缓存在浏览器中运用十分广泛，如果在加载网页时使用了缓存，主要是二次...\n" +
                "    </p>\n" +
                "    <div class=\"meta\">\n" +
                "      <a target=\"_blank\" href=\"/p/dc769fd99c10\">\n" +
                "        <i class=\"iconfont ic-list-read\"></i> 2\n" +
                "</a>        <a target=\"_blank\" href=\"/p/dc769fd99c10#comments\">\n" +
                "          <i class=\"iconfont ic-list-comments\"></i> 0\n" +
                "</a>      <span><i class=\"iconfont ic-list-like\"></i> 1</span>\n" +
                "      <span class=\"time\" data-shared-at=\"2018-08-29T23:00:04+08:00\"></span>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</li>\n" +
                "\n" +
                "    \n" +
                "\n" +
                "<li id=\"note-32919487\" data-note-id=\"32919487\" class=\"\">\n" +
                "  <div class=\"content\">\n" +
                "    <a class=\"title\" target=\"_blank\" href=\"/p/af329489ea26\">Android OkHttp3 源码解析 BridgeInterceptor (三)</a>\n" +
                "    <p class=\"abstract\">\n" +
                "      前言 之前我们学习了 OkHttp3 的使用以及 RetryAndFollowUpInterceptor 的源码，至今还记忆尤新，今天我给大家带...\n" +
                "    </p>\n" +
                "    <div class=\"meta\">\n" +
                "      <a target=\"_blank\" href=\"/p/af329489ea26\">\n" +
                "        <i class=\"iconfont ic-list-read\"></i> 0\n" +
                "</a>        <a target=\"_blank\" href=\"/p/af329489ea26#comments\">\n" +
                "          <i class=\"iconfont ic-list-comments\"></i> 0\n" +
                "</a>      <span><i class=\"iconfont ic-list-like\"></i> 1</span>\n" +
                "      <span class=\"time\" data-shared-at=\"2018-08-27T22:49:28+08:00\"></span>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</li>\n" +
                "\n" +
                "    \n" +
                "\n" +
                "<li id=\"note-32854336\" data-note-id=\"32854336\" class=\"\">\n" +
                "  <div class=\"content\">\n" +
                "    <a class=\"title\" target=\"_blank\" href=\"/p/d0ee1ca57f14\">Java8 InvocationHandler 动态代理 源码解析</a>\n" +
                "    <p class=\"abstract\">\n" +
                "      前言 之前对动态代理了解仅仅在于表层，一直觉得高不可攀，今天点开了 Proxy 类，欲知故事如何，需 Read The Source Code，...\n" +
                "    </p>\n" +
                "    <div class=\"meta\">\n" +
                "      <a target=\"_blank\" href=\"/p/d0ee1ca57f14\">\n" +
                "        <i class=\"iconfont ic-list-read\"></i> 0\n" +
                "</a>        <a target=\"_blank\" href=\"/p/d0ee1ca57f14#comments\">\n" +
                "          <i class=\"iconfont ic-list-comments\"></i> 0\n" +
                "</a>      <span><i class=\"iconfont ic-list-like\"></i> 1</span>\n" +
                "      <span class=\"time\" data-shared-at=\"2018-08-26T15:30:58+08:00\"></span>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</li>\n" +
                "\n" +
                "    \n" +
                "\n" +
                "<li id=\"note-32763361\" data-note-id=\"32763361\" class=\"\">\n" +
                "  <div class=\"content\">\n" +
                "    <a class=\"title\" target=\"_blank\" href=\"/p/6ed80c0d91ee\">Android DiskLruCache 源码解析</a>\n" +
                "    <p class=\"abstract\">\n" +
                "      前言 之前在看 LruCache 的时候，就像看看基于 Disk 版的 LruCache，当我看完 LruCache 后，如果是我自己去写，大概...\n" +
                "    </p>\n" +
                "    <div class=\"meta\">\n" +
                "      <a target=\"_blank\" href=\"/p/6ed80c0d91ee\">\n" +
                "        <i class=\"iconfont ic-list-read\"></i> 0\n" +
                "</a>        <a target=\"_blank\" href=\"/p/6ed80c0d91ee#comments\">\n" +
                "          <i class=\"iconfont ic-list-comments\"></i> 0\n" +
                "</a>      <span><i class=\"iconfont ic-list-like\"></i> 0</span>\n" +
                "      <span class=\"time\" data-shared-at=\"2018-08-24T23:03:49+08:00\"></span>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</li>\n" +
                "\n" +
                "    \n" +
                "\n" +
                "<li id=\"note-32742567\" data-note-id=\"32742567\" class=\"\">\n" +
                "  <div class=\"content\">\n" +
                "    <a class=\"title\" target=\"_blank\" href=\"/p/eb3287643065\">Android OkHttp3 源码解析 Interceptor (二)</a>\n" +
                "    <p class=\"abstract\">\n" +
                "      前言 之前我们掌握了 OkHttpClient 的基本使用，在最后面我们抛出了很多 Interceptor，现在我们看一下 Intercepto...\n" +
                "    </p>\n" +
                "    <div class=\"meta\">\n" +
                "      <a target=\"_blank\" href=\"/p/eb3287643065\">\n" +
                "        <i class=\"iconfont ic-list-read\"></i> 0\n" +
                "</a>        <a target=\"_blank\" href=\"/p/eb3287643065#comments\">\n" +
                "          <i class=\"iconfont ic-list-comments\"></i> 0\n" +
                "</a>      <span><i class=\"iconfont ic-list-like\"></i> 1</span>\n" +
                "      <span class=\"time\" data-shared-at=\"2018-08-23T23:50:41+08:00\"></span>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</li>\n" +
                "\n" +
                "    \n" +
                "\n" +
                "<li id=\"note-32663007\" data-note-id=\"32663007\" class=\"\">\n" +
                "  <div class=\"content\">\n" +
                "    <a class=\"title\" target=\"_blank\" href=\"/p/196f7b2a703c\">Android OkHttp3 源码解析 入门 (一)</a>\n" +
                "    <p class=\"abstract\">\n" +
                "      前言 总觉得网络这一块不是那么的熟悉，也找不到窍门，索性看一个网络请求框架，来加深自己对网络请求的认识。这个系列应该会很长，毕竟这个库也不简单，...\n" +
                "    </p>\n" +
                "    <div class=\"meta\">\n" +
                "      <a target=\"_blank\" href=\"/p/196f7b2a703c\">\n" +
                "        <i class=\"iconfont ic-list-read\"></i> 0\n" +
                "</a>        <a target=\"_blank\" href=\"/p/196f7b2a703c#comments\">\n" +
                "          <i class=\"iconfont ic-list-comments\"></i> 0\n" +
                "</a>      <span><i class=\"iconfont ic-list-like\"></i> 1</span>\n" +
                "      <span class=\"time\" data-shared-at=\"2018-08-23T19:30:40+08:00\"></span>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</li>\n" +
                "\n" +
                "    \n" +
                "\n" +
                "<li id=\"note-32663082\" data-note-id=\"32663082\" class=\"\">\n" +
                "  <div class=\"content\">\n" +
                "    <a class=\"title\" target=\"_blank\" href=\"/p/6e231df7bef6\">HTTP Code 总结</a>\n" +
                "    <p class=\"abstract\">\n" +
                "      每天背一个状态码系列 1xx Informational response 100 Continue 通俗点说的话，如果是POST 请求，我们的...\n" +
                "    </p>\n" +
                "    <div class=\"meta\">\n" +
                "      <a target=\"_blank\" href=\"/p/6e231df7bef6\">\n" +
                "        <i class=\"iconfont ic-list-read\"></i> 0\n" +
                "</a>        <a target=\"_blank\" href=\"/p/6e231df7bef6#comments\">\n" +
                "          <i class=\"iconfont ic-list-comments\"></i> 0\n" +
                "</a>      <span><i class=\"iconfont ic-list-like\"></i> 1</span>\n" +
                "      <span class=\"time\" data-shared-at=\"2018-08-23T14:29:39+08:00\"></span>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</li>\n" +
                "\n" +
                "</ul>\n" +
                "\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    \n" +
                "<div class=\"col-xs-7 col-xs-offset-1 aside\">\n" +
                "    <div class=\"title\">个人介绍</div>\n" +
                "    <a class=\"function-btn\" data-action=\"start-edit-intro\" href=\"javascript:void(0)\"><i class=\"iconfont ic-edit-s\"></i>编辑</a>\n" +
                "    <form class=\"profile-edit js-intro-form\" data-type=\"json\" id=\"edit_user_7117641\" action=\"/users/c38a29bd2e6d\" accept-charset=\"UTF-8\" data-remote=\"true\" method=\"post\"><input name=\"utf8\" type=\"hidden\" value=\"&#x2713;\" /><input type=\"hidden\" name=\"_method\" value=\"patch\" />\n" +
                "      <textarea name=\"user[intro]\" id=\"user_intro\">\n" +
                "一只想了解源码的渣渣</textarea>\n" +
                "      <input type=\"submit\" name=\"commit\" value=\"保存\" class=\"btn btn-hollow\" data-action=\"save-edit-intro\" data-disable-with=\"保存\" />\n" +
                "      <a data-action=\"cancel-edit-intro\" href=\"javascript:void(null);\">取消</a>\n" +
                "</form>  <div class=\"description\">\n" +
                "    <div class=\"js-intro\">一只想了解源码的渣渣</div>\n" +
                "    <a class=\"social-icon-sprite social-icon-index\" target=\"_blank\" href=\"https://github.com/wzes\"></a>\n" +
                "    \n" +
                "  </div>\n" +
                "  <div class=\"publication-list\"></div>\n" +
                "  <div class=\"course-list\"></div>\n" +
                "  <ul class=\"list user-dynamic\">\n" +
                "    <li>\n" +
                "      <a href=\"/users/c38a29bd2e6d/subscriptions\">\n" +
                "        <i class=\"iconfont ic-collection\"></i> <span>我关注的专题/文集/连载</span>\n" +
                "</a>    </li>\n" +
                "    <li>\n" +
                "      <a href=\"/users/c38a29bd2e6d/liked_notes\">\n" +
                "        <i class=\"iconfont ic-like\"></i> <span>我喜欢的文章</span>\n" +
                "</a>    </li>\n" +
                "  </ul>\n" +
                "  <!-- 专题和文集 -->\n" +
                "  <div class=\"js-collection-and-notebook-container\"></div>\n" +
                "</div>\n" +
                "\n" +
                "  </div>\n" +
                "</div>\n" +
                "<div data-vcomp=\"side-tool\"></div>\n" +
                "\n" +
                "    <script type=\"application/json\" data-name=\"page-data\">{\"user_signed_in\":true,\"locale\":\"zh-CN\",\"os\":\"windows\",\"read_mode\":\"day\",\"read_font\":\"font2\",\"current_user\":{\"id\":7117641,\"nickname\":\"为战而生C\",\"slug\":\"c38a29bd2e6d\",\"avatar\":\"http://upload.jianshu.io/users/upload_avatars/7117641/5f390749-5ef8-4975-8293-3fe1cb714e54\",\"unread_counts\":{\"chats\":0,\"total\":0}},\"user\":{\"slug\":\"c38a29bd2e6d\",\"gender\":1},\"has_collections\":true}</script>\n" +
                "    \n" +
                "    <script src=\"//cdn2.jianshu.io/assets/babel-polyfill-6cd2d6b53fe3184b71cc.js\" crossorigin=\"anonymous\"></script>\n" +
                "    <script src=\"//cdn2.jianshu.io/assets/web-base-4589a22a9bce73bd8ab5.js\" crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"//cdn2.jianshu.io/assets/web-aea14d23c47f3db4a92b.js\" crossorigin=\"anonymous\"></script>\n" +
                "    \n" +
                "    <script src=\"//cdn2.jianshu.io/assets/web/pages/users/show/entry-1b51a01c2a466871d2ae.js\" crossorigin=\"anonymous\"></script>\n" +
                "    <script>\n" +
                "  (function(){\n" +
                "      var bp = document.createElement('script');\n" +
                "      var curProtocol = window.location.protocol.split(':')[0];\n" +
                "      if (curProtocol === 'https') {\n" +
                "          bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';\n" +
                "      }\n" +
                "      else {\n" +
                "          bp.src = 'http://push.zhanzhang.baidu.com/push.js';\n" +
                "      }\n" +
                "      var s = document.getElementsByTagName(\"script\")[0];\n" +
                "      s.parentNode.insertBefore(bp, s);\n" +
                "  })();\n" +
                "</script>\n" +
                "\n" +
                "  </body>\n" +
                "</html>");

        urlList.stream().forEach(u -> System.out.println(u.getName()));
        System.out.println(urlList.size());
    }

    @Test
    public void getAllLinks1() {
    }

    @Test
    public void getText() {
    }

    @Test
    public void getText1() {
    }
}