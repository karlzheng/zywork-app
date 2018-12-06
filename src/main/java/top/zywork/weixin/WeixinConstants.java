package top.zywork.weixin;

/**
 * 微信相关的通用常量<br/>
 *
 * 创建于2018-12-04<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public class WeixinConstants {

    // 服务器根域名
    public static final String BASE_URL = "http://www.zywork.top";

    // 微信公众号用户cookie名称
    public static final String WEIXIN_GZH_USER_COOKIE_NAME = "zywork_weixin_gzh_openid";

    // 微信小程序用户cookie名称
    public static final String WEIXIN_XCX_USER_COOKIE_NAME = "zywork_weixin_xcx_openid";

    // 微信返回消息，如果出错，则包含有errcode
    public static final String ERROR_CODE_STR = "errcode";

}
