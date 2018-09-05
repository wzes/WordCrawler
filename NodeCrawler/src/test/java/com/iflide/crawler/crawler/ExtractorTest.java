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
        List<Url> urlList =  extractor.getAllLinks("https://weibo.com/ttarticle/p/show?id=2309351000344279752335732692", "\n" +
                "<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\">\n" +
                "<title>“昆山砍人案”为什么认定于海明是正当防卫？</title>\n" +
                "<link href=\"//img.t.sinajs.cn/t6/style/css/module/base/frame.css?_v=1729f71be52e97d400ebf8d24a139b02\" type=\"text/css\" rel=\"stylesheet\" />\n" +
                "<link href=\"//img.t.sinajs.cn/t6/style/css/module/combination/comb_artical.css?_v=1729f71be52e97d400ebf8d24a139b02\" type=\"text/css\" rel=\"stylesheet\" />\n" +
                "<link id=\"uuskin_host\" href=\"//img.t.sinajs.cn/t6/skin/default/skin.css?_v=1729f71be52e97d400ebf8d24a139b02\" type=\"text/css\" rel=\"stylesheet\" />\n" +
                "    <script src=\"//js2.t.sinajs.cn/t1/kuran/js/lib/open/krv/video.js?_v=7b7f005df3bba4bfbbeac33a068981ee\"></script>\n" +
                "\n" +
                "    <script type=\"text/javascript\">\n" +
                "        function play_music(){}\n" +
                "var $CONFIG = {};\n" +
                "$CONFIG['uid'] = '5589559954';\n" +
                "$CONFIG['nick'] = '为战而生c';\n" +
                "$CONFIG['onick'] = '广州日报';\n" +
                "$CONFIG['oid'] = '1887790981';\n" +
                "$CONFIG['isPay'] = '0';\n" +
                "$CONFIG['isMask'] = '0';\n" +
                "$CONFIG['article_list_url'] = '/1887790981/wenzhang';\n" +
                "$CONFIG['isImport'] = '0';\n" +
                "$CONFIG['isVClub'] = '0';\n" +
                "$CONFIG['cssPath'] = '//img.t.sinajs.cn';\n" +
                "$CONFIG['jsPath'] = '//js.t.sinajs.cn';\n" +
                "$CONFIG['tt_version'] = '1729f71be52e97d400ebf8d24a139b02';\n" +
                "</script>\n" +
                "</head>\n" +
                "<body class=\"B_artical \">\n" +
                "  <div class=\"WB_miniblog\" id=\"articleRoot\">\n" +
                "    <div class=\"WB_miniblog_fb\">\n" +
                "                     <div id=\"plc_top\">\n" +
                "        <div class=\"WB_global_nav\">\n" +
                "          <div id=\"weibo_top_public\">          \n" +
                "            <script src=\"//js.t.sinajs.cn/t6/home/js/pl/top/topInit.js?t=2\"></script>\n" +
                "            <script>\n" +
                "              WBtopGlobal && WBtopGlobal.init({\n" +
                "                \"uid\": 5589559954, \n" +
                "                //是否登陆\n" +
                "                \"islogin\":1,// 0未登录。1登录，2 预登录\n" +
                "                \"pid\" : 1,\n" +
                "                \"lang\":\"zh-cn\",\n" +
                "                \"rbackurl\":\"//weibo.com\"\n" +
                "              });\n" +
                "          </script>\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "  \n" +
                "            <div class=\"WB_main clearfix\" id=\"plc_frame\">\n" +
                "                  <div class=\"WB_frame\">\n" +
                "          <div id=\"plc_main\">\n" +
                "            <div class=\"WB_frame_a\">\n" +
                "              <div class=\"WB_cardwrap S_bg2\">\n" +
                "                <div class=\"WB_artical\">\n" +
                "                  <div class=\"main_toppic\">\n" +
                "                    <div class=\"picbox\">\n" +
                "                      <img node-type=\"articleHeaderPic\" src=\"https://tc.sinaimg.cn/images/tc2.service.jpg\" />\n" +
                "                                          </div>\n" +
                "                  </div>\n" +
                "\n" +
                "                                      <div class=\"main_editor \" node-type=\"articleContent\">\n" +
                "                                                        <div class=\"title\" node-type=\"articleTitle\">“昆山砍人案”为什么认定于海明是正当防卫？</div>\n" +
                "                    <div class=\"authorinfo clearfix S_txt2\">\n" +
                "                      <div class=\"W_fl\">\n" +
                "                                              <span class=\"author1 W_autocut\"><img title=\"\" alt=\"\" src=\"//tva4.sinaimg.cn/crop.0.0.179.179.50/70856785gw1ezgct0epprj2050050q37.jpg\" class=\"W_face_radius\"><a href=\"/u/1887790981\" class=\"S_txt1\" target=\"_blank\"><em class=\"W_autocut\">广州日报</em>\n" +
                "                                                        <i title=\"微博机构认证\" class=\"W_icon icon_approve_co\"></i>\n" +
                "                                                    </a></span>\n" +
                "                            <em class=\"W_vline S_line1\"></em>\n" +
                "                                                                     <span class=\"author2 W_autocut\">\n" +
                "                                <span class=\"author2in\">作者：\n" +
                "                                                            广州日报                                                            </span>\n" +
                "                        </span>\n" +
                "                        <em class=\"W_vline S_line1\"></em>\n" +
                "                        \n" +
                "                        \n" +
                "                                                <span class=\"time\"> 发布于 2018-09-02 10:30:15</span>\n" +
                "                        \n" +
                "\n" +
                "                                                      <em class=\"W_vline S_line1\"></em>\n" +
                "                            <span class=\"del\"><a href=\"javascript:void(0);\" onclick=\"javascript:window.open('http://service.account.weibo.com/reportspam?rid=4279752250441675&type=32&from=11101', 'newwindow', 'height=700, width=550, toolbar =yes, menubar=no, scrollbars=yes, resizable=yes, location=no, status=no');\"  suda-uatrack=\"key=tblog_headline_article&value=headline_pc_trend_report_click\">举报</a></span>\n" +
                "                          \n" +
                "                                                   <em class=\"W_vline S_line1\"></em>\n" +
                "                        <span class=\"del\"><a href=\"http://gzrbshare.gzcankao.net/news/wx/detail?newsid=207995&time=1535855515633\"  target=\"_blank\" suda-uatrack=\"key=tblog_headline_article&value=headline_pc_trend_ourl_click\">查看源网址</a></span>\n" +
                "                                                                          \n" +
                "                      </div>\n" +
                "                                             <div class=\"W_fr\"><span class=\"num\">阅读数：10万+</span></div>\n" +
                "                                            </div>\n" +
                "                                        \n" +
                "                                                        <div class=\"WB_editor_iframe\" node-type=\"contentBody\" style=\"visibility: hidden\">\n" +
                "                          \n" +
                "                                  <p>\u200B\u200B正当防卫？防卫过当？还是故意伤害致死？备受社会舆论关注的昆山市“8.27”于海明致刘海龙死亡案有了结果。<a href=\"http://mp.weixin.qq.com/s?__biz=MjM5NzI3NDg4MA==&amp;mid=2658519452&amp;idx=1&amp;sn=7704636f5cf6a73547b653db76997123&amp;chksm=bd5d1df38a2a94e5c5e3ddfdecd5f257adffaebb7b79caecee704df3bc8500a4cd8871c3c397&amp;scene=21#wechat_redirect\">9月1日下午，昆山市公安局和检察院相继发布通报，认定于海明的行为属于正当防卫，不负刑事责任。</a>案件经历了什么，有哪些你所不知的细节，为什么认定正当防卫，这里有江苏检察的意见和声音。</p><p><br/></p><p><b>一、案件基本情况</b></p><p><br/></p><p>2018年8月27日21时30分许，昆山市震川路发生一起宝马轿车驾驶员持刀砍人反被杀案。公安机关接警后及时赶赴现场调查处理，并于当日立案侦查。检察机关对此案高度重视，昆山市检察院第一时间派员依法提前介入侦查活动，查阅案件证据材料，对侦查取证和法律适用提出意见和建议，并依法履行法律监督职责。江苏省检察院、苏州市检察院及时派员进行指导，最高人民检察院也对此案表示关切。</p><p><br/></p><p>公安机关查明，案发当晚刘海龙醉酒驾驶皖AP9G57宝马轿车（经检测，血液酒精含量为87mg/100ml），载刘某某（男）、刘某（女）、唐某某（女）行至昆山市震川路，向右强行闯入非机动车道，与正常骑自行车的于海明险些碰擦，双方遂发生争执。经双方同行人员劝解，交通争执基本平息，但刘海龙突然下车，上前推搡、踢打于海明。虽经劝架，刘海龙仍持续追打，后返回宝马轿车拿出一把砍刀（经鉴定，该刀为尖角双面开刃，全长59厘米，其中刀身长43厘米、宽5厘米，系管制刀具），连续用刀击打于海明颈部、腰部、腿部。击打中砍刀甩脱，于海明抢到砍刀，并在争夺中捅刺、砍击刘海龙5刀，刺砍过程持续7秒。刘海龙受伤后跑向宝马轿车，于海明继续追砍2刀均未砍中。刘海龙跑向宝马轿车东北侧，于海明追赶数米被同行人员拉阻，后返回宝马轿车，将车内刘海龙手机取出放入自己口袋。民警到达现场后，于海明将手机和砍刀主动交给处警民警（于海明称拿走刘海龙手机是为了防止对方打电话召集人员报复）。</p><p><br/></p><p>刘海龙后经送医抢救无效于当日死亡。经法医鉴定并结合视频监控认定，刘海龙连续被刺砍5刀，其中，第1刀为左腹部刺戳伤，致腹部大静脉、肠管、肠系膜破裂；其余4刀依次造成左臀部、右胸部并右上臂、左肩部、左肘部共5处开放性创口及3处骨折，死因为失血性休克。</p><p><br/></p><p>于海明经人身检查，见左颈部条形挫伤1处，左胸季肋部条形挫伤1处。</p><p><br/></p><p><b>二、认定于海明行为属于正当防卫的分析意见</b></p><p><br/></p><p>我国刑法第二十条第三款规定：“对正在进行行凶、杀人、抢劫、强奸、绑架以及其他严重危及人身安全的暴力犯罪，采取防卫行为，造成不法侵害人伤亡的，不属于防卫过当，不负刑事责任。”根据本案事实及现有证据，检察机关认为于海明属于正当防卫，不负刑事责任。<br/></p><p><br/></p><p><b>1. 刘海龙挑起事端、过错在先。</b></p><p><br/></p><p>从该案的起因看，刘海龙醉酒驾车，违规变道，主动滋事，挑起事端；从事态发展看，刘海龙先是推搡，继而拳打脚踢，最后持刀击打，不法侵害步步升级。</p><p><br/></p><p><b>2. 于海明正面临严重危及人身安全的现实危险。</b></p><p><br/></p><p>本案系“正在进行的行凶”，刘海龙使用的双刃尖角刀系国家禁止的管制刀具，属于刑法规定中的凶器；其持凶器击打他人颈部等要害部位，严重危及于海明人身安全；砍刀甩落在地后，其立即上前争夺，没有放弃迹象。刘海龙受伤起身后，立即跑向原放置砍刀的汽车——于海明无法排除其从车内取出其他“凶器”的可能性。砍刀虽然易手，危险并未消除，于海明的人身安全始终面临着紧迫而现实的危险。</p><p><br/></p><p><b>3. 于海明抢刀反击的行为属于情急下的正常反应，符合特殊防卫要求。</b></p><p><br/></p><p>于海明抢刀后，连续捅刺、砍击刘海龙5刀，所有伤情均在7秒内形成。面对不法侵害不断升级的紧急情况，一般人很难精准判断出自己可能受到多大伤害，然后冷静换算出等值的防卫强度。法律不会强人所难，所以刑法规定，面对行凶等严重暴力犯罪进行防卫时，没有防卫限度的限制。检察机关认为，于海明面对挥舞的长刀，所做出的抢刀反击行为，属于情急下的正常反应，不能苛求他精准控制捅刺的力量和部位。虽然造成不法侵害人的死亡，但符合特殊防卫要求，依法不需要承担刑事责任。</p><p><br/></p><p><b>4. 从正当防卫的制度价值看，应当优先保护防卫者。</b></p><p><br/></p><p>“合法没有必要向不法让步”。正当防卫的实质在于“以正对不正”，是正义行为对不法侵害的反击，因此应明确防卫者在刑法中的优先保护地位。实践中，许多不法侵害是突然、急促的，防卫者在仓促、紧张状态下往往难以准确地判断侵害行为的性质和强度，难以周全、慎重地选择相应的防卫手段。在事实认定和法律适用上，司法机关应充分考虑防卫者面临的紧急情况，依法准确适用正当防卫规定，保护防卫者的合法权益，从而树立良好的社会价值导向。本案是刘海龙交通违章在先，寻衅滋事在先，持刀攻击在先。于海明面对这样的不法侵害，根据法律规定有实施正当防卫的权利。</p><p><br/></p><p img-box=\"img-box\" class=\"picbox\"><img src=\"https://tc.sinaimg.cn/maxwidth.2048/tc.service.weibo.com/gzrbimages_gzcankao_net/db4f5d194a1a8829ccef39725eabd903.jpeg\"/></p><p><br/></p><p>社会各界对这起案件给予了极大关注，尤其是广大网民、专家、学者、律师积极提出意见建议，理性表达观点诉求，促进了案件的依法办理，江苏检察机关表示衷心感谢。</p><p><br/></p><p>人身安全是每个公民最基本的要求，面对来自不法行为的严重紧急危害，法律应当引导鼓励公民勇于自我救济，坚持同不法侵害作斗争。司法应当负起倡导风尚、弘扬正气的责任，检察机关也将会依法保障人民群众的正当防卫权利，切实维护人民群众合法权益。</p><p><br/></p><br/><p><br/></p><p>（来源：“江苏检察在线” ID：jsjczx）\u200B\u200B\u200B\u200B</p>                                                            </div>\n" +
                "\n" +
                "                          <!--v+付费阅读和单篇付费-->\n" +
                "                          <div node-type=\"fanService\">\n" +
                "\n" +
                "                              \n" +
                "                              <div action-type=\"reward\"></div>\n" +
                "                          </div>\n" +
                "\n" +
                "                                                                         <div class=\"artical_add_box S_bg2\" node-type=\"addBox\">\n" +
                "                   <div class=\"btn_line W_tc W_f14 W_fb\" node-type=\"maskContent\" style=\"display:none\"><a href=\"javascript:\" action-type=\"maskFollow\" action-data=\"uid=1887790981&owner_id=1887790981&refer_flag=2309350003_2309351000344279752335732692\">关注作者，阅读全文<i class=\"W_ficon ficon_arrow_down\">c</i></a>\n" +
                "                   <div class=\"tips\">还有50%的精彩内容，作者设置为仅对粉丝可见</div>\n" +
                "                   </div>\n" +
                "                    <div class=\"PCD_counter_b\">\n" +
                "                      <div class=\"WB_innerwrap\">\n" +
                "                        <div class=\"userbox S_line2\">\n" +
                "                          <div class=\"midbox clearfix\">\n" +
                "                            <div class=\"pic_wrap\">\n" +
                "                              <p class=\"pic_box\">\n" +
                "                                <a href=\"/u/1887790981\" target=\"_blank\"><img src=\"//tva4.sinaimg.cn/crop.0.0.179.179.50/70856785gw1ezgct0epprj2050050q37.jpg\" width=\"50\" height=\"50\" class=\"pic\"></a>\n" +
                "                              </p>\n" +
                "                            </div>\n" +
                "                            <div class=\"info_wrap\">\n" +
                "                              <div class=\"title W_fb W_autocut \">\n" +
                "                                <a href=\"/u/1887790981\" target=\"_blank\" class=\"S_txt1\">广州日报</a>\n" +
                "                                                        <i title=\"微博机构认证\" class=\"W_icon icon_approve_co\"></i>\n" +
                "                                                                                      </div>\n" +
                "                              <div class=\"text S_txt2\">\n" +
                "                                  <a href=\"/u/1887790981\"  target=\"_blank\"  class=\"S_txt1\">《广州日报》创刊于1952年12月1日，是广东省发行量第一、订阅量第一、零售量第一和传阅率第一的报纸。</a>\n" +
                "                              </div>\n" +
                "                            </div>\n" +
                "                            <div class=\"opt\">\n" +
                "                              <p class=\"btn_bed\">\n" +
                "                                                                 <a class=\"W_btn_b W_btn_b_disable\" href=\"javascript:\"><em class=\"W_ficon ficon_right\">Y</em>已关注</a>\n" +
                "                                                            </div>\n" +
                "                          </div>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                 </div>\n" +
                "                          \n" +
                "                                                            \n" +
                "                          <!--因为推荐阅读影响打赏放在作者模块下方-->\n" +
                "                          <div node-type=\"fanService\">\n" +
                "                                                                <div rewardComponent=\"seller=1887790981&bid=1000207805&oid=1022%3A2309351000344279752335732692&access_type=pcLayer&share=1&sign=c1fa761b6d43179a502a9322d0ea88d0\" extendParam=\"type=pagecard&version=237b505d3a234b6a\"></div>\n" +
                "                              \n" +
                "                              <div action-type=\"reward\"></div>\n" +
                "                          </div>\n" +
                "\n" +
                "                  </div>\n" +
                "\n" +
                "                  <div node-type=\"thirdModule\">\n" +
                "                  </div>\n" +
                "                      <div  node-type=\"recommend\">\n" +
                "                      </div>\n" +
                "\n" +
                "                                    <div class=\"WB_feed WB_feed_v3 WB_feed_v3_one\">\n" +
                "  <div class=\"WB_cardwrap WB_feed_type S_bg2\" node-type=\"feed_list\">\n" +
                "    <div action-type=\"feed_list_item\" mid=\"4279752250441675\" isforward=\"1\">\n" +
                "      <div class=\"WB_feed_handle\" node-type=\"feed_list_options\">\n" +
                "        <div class=\"WB_handle\">\n" +
                "          <ul class=\"WB_row_line WB_row_r3 clearfix S_line2\">\n" +
                "            <li>\n" +
                "                                    <a  action-data=\"allowForward=1&url=http%3A%2F%2Fweibo.com%2F1887790981%2FGxsIF1QTN&mid=4279752250441675&name=%E5%B9%BF%E5%B7%9E%E6%97%A5%E6%8A%A5&uid=1887790981&domain=gzdaily&pid=\" action-type=\"fl_forward\" action-history=\"rec=1\"  href=\"javascript:void(0);\" class=\"S_txt2\" suda-uatrack=\"key=profile_feed&value=transfer\"><span class=\"pos\"><span class=\"line S_line1\" node-type=\"forward_btn_text\">转发 49</span></span></a>\n" +
                "                                <span class=\"arrow\"><span class=\"W_arrow_bor W_arrow_bor_t\"><i class=\"S_line1\"></i><em class=\"S_bg1_br\"></em></span></span>\n" +
                "            </li>\n" +
                "            <li>\n" +
                "                                    <a href=\"javascript:void(0);\" class=\"S_txt2\" action-type=\"fl_comment\" action-data=\"ouid=1887790981&location=&comment_type=1\" suda-uatrack=\"key=profile_feed&value=comment:4279752250441675\"><span class=\"pos\"><span class=\"line S_line1\" node-type=\"comment_btn_text\">评论 160</span></span></a>\n" +
                "                                <span class=\"arrow\"><span class=\"W_arrow_bor W_arrow_bor_t\"><i class=\"S_line1\"></i><em class=\"S_bg1_br\"></em></span></span>\n" +
                "            </li>\n" +
                "            <li>\n" +
                "              <a href=\"javascript:void(0);\" class=\"S_txt2\" action-type=\"fl_like\" action-data=\"version=mini&qid=heart&mid=4279752250441675&loc=profile\" title=\"赞\" suda-uatrack=\"key=profile_feed&value=like\"><span class=\"pos\"><span class=\"line S_line1\"><span node-type=\"like_status\"><i class=\"W_icon icon_praised_b\"></i> <em>150</em></span></span></span></a>\n" +
                "              <span class=\"arrow\"><span class=\"W_arrow_bor W_arrow_bor_t\"><i class=\"S_line1\"></i><em class=\"S_bg1_br\"></em></span></span>\n" +
                "            </li>\n" +
                "          </ul>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "                    <div class=\"WB_feed_repeat S_bg1\" node-type=\"like_detail\" style=\"display:none;\"></div>\n" +
                "      <div class=\"WB_feed_repeat S_bg1\" node-type=\"comment_detail\">\n" +
                "          <div class=\"WB_repeat S_line1\" node-type=\"comment\" count=\"160\">\n" +
                "\n" +
                "                    <div class=\"WB_feed_publish clearfix\">\n" +
                "              <div class=\"WB_publish\">\n" +
                "                  <div class=\"p_input\"><textarea class=\"W_input\" node-type=\"textEl\"></textarea></div>\n" +
                "                  <div class=\"p_opt clearfix\">\n" +
                "                      <div class=\"btn W_fr\"><a href=\"javascript:void(0);\" class=\"W_btn_a W_btn_a_disable\" action-type=\"post\" diss-data=\"module=bcommlist\"><em node-type=\"btnText\">评论</em></a></div>\n" +
                "                      <div class=\"opt clearfix\" node-type=\"widget\">\n" +
                "                          <span class=\"ico\" class=\"W_ico16 ico_faces\"><a href=\"javascript:void(0);\" node-type=\"smileyBtn\"><i class=\"W_ficon ficon_face\">o</i></a><a href=\"javascript:void(0);\" node-type=\"imgBtn\"><i class=\"W_ficon ficon_image\">p</i></a></span>\n" +
                "                          <ul class=\"ipt\">\n" +
                "                              <li >\n" +
                "                                                                        <label  for=\"ipt11\" class=\"W_label\"><input id=\"ipt11\" suda-data=\"key=tblog_tran_comm&value=bigcomm_tran_weibo\" type=\"checkbox\" name=\"forward\" class=\"W_checkbox\" /><span>同时转发到我的微博</span></label>\n" +
                "                                                                </li>\n" +
                "                                                        </ul>\n" +
                "                      </div>\n" +
                "                  </div>\n" +
                "              </div>\n" +
                "          </div>\n" +
                "          <div class=\"repeat_list\" node-type=\"feed_cate\">\n" +
                "              <div class=\"tab_feed_a clearfix S_line1\">\n" +
                "                  <div class=\"tab\" node-type=\"feed_cate\">\n" +
                "                      <ul class=\"clearfix\">\n" +
                "                      <li><span class=\"line S_line1\"><a href=\"javascript:void(0);\" class=\"S_txt1 curr\" suda-uatrack=\"key=comment&value=big_comment_friends\" node-type=\"feed_list_commentTabAll\" action-type=\"search_type\" action-data=\"id=4279752250441675&filter=0\">全部</a></span></li>\n" +
                "                      <li><span class=\"line S_line1\"><a href=\"javascript:void(0);\" class=\"S_txt1\" suda-uatrack=\"key=comment&value=hotcomm\" action-type=\"search_type\" action-data=\"id=4279752250441675&filter=hot\">热门</a></span></li>\n" +
                "                      <li><span class=\"line S_line1\"><a href=\"javascript:void(0);\" class=\"S_txt1\" suda-uatrack=\"key=comment&value=big_comment_friends\" action-type=\"search_type\" action-data=\"id=4279752250441675&filter=3\">认证用户</a></span></li>\n" +
                "                      <li><span class=\"line S_line1\"><a href=\"javascript:void(0);\" class=\"S_txt1\" suda-uatrack=\"key=comment&value=big_comment_following\" action-type=\"search_type\" action-data=\"id=4279752250441675&filter=1\">关注的人</a></span></li>\n" +
                "                      <li><span class=\"line S_line1\"><a href=\"javascript:void(0);\" class=\"S_txt1\" suda-uatrack=\"key=comment&value=big_comment_stranger\" action-type=\"search_type\" action-data=\"id=4279752250441675&filter=2\">陌生人</a></span></li>\n" +
                "                      </ul>\n" +
                "                  </div>\n" +
                "              </div>\n" +
                "              <div node-type=\"feed_list\"></div>\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "      <div class=\"WB_feed_repeat S_bg1\" node-type=\"forward_detail\"  style=\"display:none;\">\n" +
                "        <div class=\"WB_repeat S_line1\">\n" +
                "           <div class=\"WB_minitab clearfix\" node-type=\"forward_tab\">\n" +
                "             <ul class=\"minitb_ul S_line1 S_bg1 clearfix\">\n" +
                "               <li class=\"minitb_item current S_line1\"> <a href=\"javascript:void(0);\" class=\"minitb_lk S_txt1 S_bg2\" action-type=\"forword_tab_click\" action-data=\"microblog\">转发到微博</a><span class=\"cur_block\"></span></li>\n" +
                "               <li class=\"minitb_item S_line1\"> <a href=\"javascript:void(0);\" class=\"minitb_lk S_txt1\" action-type=\"forword_tab_click\" action-data=\"privatemsg\">转发到私信</a><span class=\"cur_block\"></span></li>\n" +
                "             </ul>\n" +
                "            </div>\n" +
                "            <div node-type=\"forward\"></div>\n" +
                "            <div class=\"repeat_list\">\n" +
                "                <div class=\"tab_feed_a clearfix S_line1\">\n" +
                "                    <div class=\"tab\" node-type=\"feed_cate\">\n" +
                "                        <ul class=\"clearfix\">\n" +
                "                        <li><span class=\"line S_line1\"><a href=\"javascript:void(0);\" class=\"S_txt1 curr\" node-type=\"feed_list_commentTabAll\" action-type=\"search_type\" action-data=\"id=4279752250441675&filter=0\">全部</a></span></li>\n" +
                "                        <li><span class=\"line S_line1\"><a href=\"javascript:void(0);\" class=\"S_txt1\" suda-uatrack=\"key=tblog_tran&value=tran_hot\" action-type=\"search_type\" action-data=\"id=4279752250441675&filter=hot\">热门</a></span></li>\n" +
                "                        <li><span class=\"line S_line1\"><a href=\"javascript:void(0);\" class=\"S_txt1\" suda-uatrack=\"key=tblog_tran&value=tran_att\" action-type=\"search_type\" action-data=\"id=4279752250441675&filter=1\">关注的人</a></span></li>\n" +
                "                        <li><span class=\"line S_line1\"><a href=\"javascript:void(0);\" class=\"S_txt1\" suda-uatrack=\"key=tblog_tran&value=tran_notatt\" action-type=\"search_type\" action-data=\"id=4279752250441675&filter=2\">陌生人</a></span></li>\n" +
                "                        </ul>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"list_box\">\n" +
                "                    <div class=\"list_ul\" node-type=\"feed_list\"></div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "                  \n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "\n" +
                "  <div node-type=\"sidebar\">\n" +
                "        <div class=\"W_gotop W_gotop_v2\" action-type=\"shareBox\">\n" +
                "            <a href=\"javascript:\" action-type=\"data-tip\" data-tip=\"text=分享到微博&showWithAni=fadeInRight&hideWithAni=fadeOutLeft&pos=left-middle\" class=\"S_ficon_bg\" suda-uatrack=\"key=tblog_headline_article&value=headline_pc_weibo_click\"><em class=\"W_ficon ficon_wb S_bg2_c\" action-type=\"shareToWeibo\">\uE604</em></a>\n" +
                "            <!--<a href=\"javascript:\" action-type=\"data-tip\" data-tip=\"text=分享到微信&showWithAni=fadeInRight&hideWithAni=fadeOutLeft&pos=left-middle\" class=\"S_ficon_bg\" suda-uatrack=\"key=tblog_headline_article&value=headline_pc_wechat_click\"><em class=\"W_ficon ficon_wx S_bg2_c\" action-type=\"shareToWeiXin\">\uE605</em></a> -->\n" +
                "      <a href=\"javascript:\" action-type=\"data-tip\" data-tip=\"text=分享到QQ&showWithAni=fadeInRight&hideWithAni=fadeOutLeft&pos=left-middle\" class=\"S_ficon_bg\" suda-uatrack=\"key=tblog_headline_article&value=headline_pc_qq_click\"><em class=\"W_ficon ficon_qq S_bg2_c\" action-type=\"shareToQQ\">\uE603</em></a>\n" +
                "      <!-- <a href=\"//js.t.sinajs.cn/t6/article/publish/dist/js/static/faq.pdf?_v=1729f71be52e97d400ebf8d24a139b02\" action-type=\"data-tip\" data-tip=\"text=使用说明&showWithAni=fadeInRight&hideWithAni=fadeOutLeft&pos=left-middle\" class=\"S_ficon_bg\" target=\"_blank\"><em class=\"W_ficon ficon_FAQ S_bg2_c\">\uE610</em></a> -->\n" +
                "      </div>\n" +
                "      <a href=\"javascript:\" data-tip=\"text=回到顶部&showWithAni=fadeInRight&hideWithAni=fadeOutLeft&pos=left-middle\" class=\"W_gotop S_ficon_bg\" action-type=\"data-tip\"><em class=\"W_ficon ficon_backtop S_bg2_c\" action-type=\"goTop\">Ú</em></a>\n" +
                "    </div>\n" +
                "\n" +
                "          <div id=\"pl_common_footer\">\n" +
                "      <div class=\"WB_footer S_bg2\">\n" +
                "        <div class=\"footer_link clearfix\">\n" +
                "          <dl class=\"list\">\n" +
                "            <dt>微博精彩</dt>\n" +
                "            <dd><a class=\"col1 S_txt2\" target=\"_blank\" href=\"http://hot.plaza.weibo.com/?bottomnav=1&amp;wvr=6&amp;type=re&amp;act=day\">热门微博</a><a class=\"col1 S_txt2\" target=\"_blank\" href=\"http://huati.weibo.com/?bottomnav=1&amp;wvr=6\">热门话题</a></dd>\n" +
                "            <dd><a class=\"col1 S_txt2\" target=\"_blank\" href=\"http://verified.weibo.com/?bottomnav=1&amp;wvr=6\">名人堂</a><a class=\"col1 S_txt2\" target=\"_blank\" href=\"http://vip.weibo.com/home?bottomnav=1&amp;wvr=6\">微博会员</a></dd>\n" +
                "            <dd><a class=\"col1 S_txt2\" target=\"_blank\" href=\"http://photo.weibo.com/?bottomnav=1&amp;wvr=6\">微相册</a><a class=\"col1 S_txt2\" target=\"_blank\" href=\"http://game.weibo.com/?bottomnav=1&amp;wvr=6\">微游戏</a></dd>\n" +
                "            <dd><a class=\"col1 S_txt2\" target=\"_blank\" href=\"http://data.weibo.com/index/?bottomnav=1&amp;wvr=6\">微指数</a></dd>\n" +
                "          </dl>\n" +
                "          <dl class=\"list\">\n" +
                "            <dt>手机玩微博</dt>\n" +
                "            <dd><a class=\"T_code col2\">\n" +
                "                <img src=\"//img.t.sinajs.cn/t6/style/images/common/footer_code.jpg\" alt=\"二维码\">\n" +
                "              </a>\n" +
                "              <a class=\"T_txt S_txt2 \" href=\"http://m.weibo.cn/client/guide/show\">扫码下载，更多版本<br>戳这里</a>\n" +
                "            </dd>\n" +
                "          </dl>\n" +
                "          <dl class=\"list\">\n" +
                "            <dt>认证&amp;合作</dt>\n" +
                "            <dd><a class=\"col3 S_txt2\" target=\"_blank\" href=\"http://verified.weibo.com/verify?bottomnav=1&amp;wvr=6\">申请认证</a><a class=\"col3 S_txt2\" target=\"_blank\" href=\"http://open.weibo.com/?bottomnav=1&amp;wvr=6\">开放平台</a></dd>\n" +
                "            <dd><a class=\"col3 S_txt2\" target=\"_blank\" href=\"http://e.weibo.com/introduce/introduce?bottomnav=1&amp;wvr=6\">企业微博</a><a class=\"col3 S_txt2\" target=\"_blank\" href=\"http://open.weibo.com/connect?bottomnav=1&amp;wvr=6\">链接网站</a></dd>\n" +
                "            <dd><a class=\"col3 S_txt2\" target=\"_blank\" href=\"//weibo.com/static/logo?bottomnav=1&amp;wvr=6\">微博标识</a><a class=\"col3 S_txt2\" target=\"_blank\" href=\"http://tui.weibo.com/?bottomnav=1&amp;wvr=6\">广告服务</a></dd>\n" +
                "            <dd><a class=\"col3 S_txt2\" target=\"_blank\" href=\"http://xueyuan.weibo.com/?bottomnav=1&amp;wvr=6\">微博商学院</a></dd>\n" +
                "          </dl>\n" +
                "          <dl class=\"list\">\n" +
                "            <dt>微博帮助</dt>\n" +
                "            <dd><a class=\"col4 S_txt2\" target=\"_blank\" href=\"http://help.weibo.com/faq/q/358?bottomnav=1&amp;wvr=6\">常见问题</a></dd>\n" +
                "            <dd><a class=\"col4 S_txt2\" target=\"_blank\" href=\"http://help.weibo.com/selfservice?bottomnav=1&amp;wvr=6\">自助服务</a></dd>\n" +
                "           </dl>\n" +
                "          </div>\n" +
                "          <div class=\"other_link S_bg1 clearfix\">\n" +
                "            <p class=\"copy\">\n" +
                "            <a href=\"http://ir.weibo.com/?bottomnav=1&amp;wvr=6\" class=\"S_txt2\" target=\"__blank\"><i class=\"W_icon icon_weibo\"></i>关于微博</a><a href=\"http://help.weibo.com/?refer=didao&amp;bottomnav=1\" target=\"_blank\" class=\"S_txt2\">微博帮助</a><a class=\"S_txt2\" href=\"http://help.weibo.com/newtopic/suggest?bottomnav=1\" target=\"_blank\">意见反馈</a><a class=\"S_txt2\" target=\"_blank\" href=\"//weibo.com/aj/static/report.html?_wv=6\">舞弊举报</a><a class=\"S_txt2\" href=\"http://open.weibo.com/?bottomnav=1\" target=\"_blank\">开放平台</a><a class=\"S_txt2\" href=\"http://hr.weibo.com?bottomnav=1\" target=\"_blank\">微博招聘</a><a class=\"S_txt2\" href=\"http://news.sina.com.cn/guide/?bottomnav=1\" target=\"_blank\">新浪网导航</a><a class=\"S_txt2\" href=\"http://service.account.weibo.com/?bottomnav=1\" target=\"_blank\">社区管理中心</a><a class=\"S_txt2\" href=\"http://service.account.weibo.com/roles/gongyue?bottomnav=1\" target=\"_blank\">微博社区公约</a><a class=\"S_txt2\" href=\"//weibo.com/aj/static/jicp.html?_wv=6\" target=\"_blank\">京ICP证100780号</a><a class=\"S_txt2\" href=\"//weibo.com/aj/static/medi_license.html?_wv=6\" target=\"__blank\">互联网药品服务许可证</a></p>\n" +
                "            <p class=\"company\"><span class=\"copy S_txt2\">Copyright ? 2009-2015 WEIBO 北京微梦创科网络技术有限公司</span><span><a class=\"S_txt2\" href=\"//weibo.com/aj/static/jww.html?_wv=6\" target=\"_blank\">京网文[2014]2046-296号</a><a class=\"S_txt2\" href=\"http://www.miibeian.gov.cn\" target=\"_blank\">京ICP备12002058号</a><a class=\"S_txt2\" href=\"//weibo.com/aj/static/license.html?_wv=6\" target=\"_blank\">增值电信业务经营许可证B2-20140447</a>\n" +
                "            <select node-type=\"changeLanguage\" suda-data=\"key=tblog_home_click&amp;value=language_versions_click\">\n" +
                "              <option value=\"zh-cn\" selected=\"\">中文(简体)</option>\n" +
                "              <option value=\"zh-tw\">中文(台灣)</option>\n" +
                "              <option value=\"zh-hk\">中文(香港)</option>\n" +
                "              <option value=\"en\">English</option>\n" +
                "             </select></span></p>\n" +
                "            <p class=\"T_server S_txt2\">服务热线：4000 960 960（个人/企业）服务时间9:00-21:00 4000 980 980（广告主）服务时间9:00-18:00 （按当地市话标准计算）    </p></div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  <script type=\"text/javascript\" charset=\"utf-8\" async=\"\" src=\"//js.t.sinajs.cn/open/analytics/js/suda.js?_v=1729f71be52e97d400ebf8d24a139b02\"></script>\n" +
                "<script type=\"text/javascript\" src=\"//js.t.sinajs.cn/t6/article/page/js/page/show/init.js?_v=1729f71be52e97d400ebf8d24a139b02\"></script>\n" +
                "<script type=\"text/javascript\" src=\"//js.t.sinajs.cn/t5/apps/fans_service_platform/js/pl/reward_m/index.js?_v=237b505d3a234b6a\" type=\"text/javascript\"></script>\n" +
                "<script>\n" +
                "var SUDA = SUDA || [];\n" +
                "SUDA.push([\"setGatherInfo\", null, 'WEIBO-V6']);\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>\n");

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