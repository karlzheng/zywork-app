package top.zywork.enums;

/**
 * 系统配置名称枚举类，每增加一个系统配置名称，增加一个枚举<br/>
 *
 * 创建于2018-12-17<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public enum SysConfigEnum {

    ALIYUN_SMS_CONFIG("aliyun_sms_config"),
    ALIYUN_MAIL_CONFIG("aliyun_mail_config"),
    WEIXIN_GZH_CONFIG("weixin_gzh_config"),
    WEIXIN_XCX_CONFIG("weixin_xcx_config"),
    WX_PAY_CONFIG("wx_pay_config"),
    DEFAULT_DISTRIBUTION_CONFIG("default_distribution_config"),
    ALIYUN_OSS_CONFIG("aliyun_oss_config"),
    QINIU_OSS_CONFIG("qiniu_oss_config");

    private String value;

    SysConfigEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
