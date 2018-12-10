package top.zywork.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zywork.common.*;
import top.zywork.enums.ContentTypeEnum;
import top.zywork.enums.MIMETypeEnum;
import top.zywork.enums.RandomCodeEnum;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.security.JwtTokenRedisUtils;
import top.zywork.security.JwtUser;
import top.zywork.security.VerifyCodeRedisUtils;
import top.zywork.security.mobile.AliyunSmsUtils;
import top.zywork.security.mobile.SmsCodeRedisUtils;
import top.zywork.vo.ResponseStatusVO;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * SpringSecurity的用户认证控制器<br/>
 *
 * 创建于2018-12-03<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Value("${verify.code.cookie-name}")
    private String verifyCodeCookieName;

    @Value("${verify.sms-code.expiration}")
    private Integer smsCodeExpiration;

    private JwtTokenRedisUtils jwtTokenRedisUtils;

    private VerifyCodeRedisUtils verifyCodeRedisUtils;

    private SmsCodeRedisUtils smsCodeRedisUtils;

    /**
     * 普通账号（手机号，邮箱），密码登录处理，可以配置是否开启验证码功能
     * @param username
     * @param password
     * @param verifyCode
     */
    @PostMapping("login")
    public void login(String username, String password, String verifyCode) {}

    /**
     * 手机验证码登录处理
     * @param phone
     * @param smsCode
     */
    @PostMapping("mobile")
    public void mobile(String phone, String smsCode) {}

    /**
     * 未认证处理
     * @return
     */
    @GetMapping("require")
    public ResponseStatusVO require() {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        statusVO.errorStatus(ResponseStatusEnum.AUTHENTICATION_ERROR.getCode(),
                ResponseStatusEnum.AUTHENTICATION_ERROR.getMessage(), null);
        return statusVO;
    }

    /**
     * 退出登录处理，只有登录过的用户才需要退出
     * @return
     */
    @GetMapping("logout")
    public ResponseStatusVO logout() {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
            jwtTokenRedisUtils.removeToken(jwtUser.getUserId() + "");
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "已安全退出", null);
        } else {
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "未登录，无需退出", null);
        }
        return statusVO;
    }

    /**
     * 生成验证码图片，把验证码保存到redis中，有效期参考application配置文件
     * @param response
     */
    @GetMapping("verify-code")
    public void generateVerifyCode(HttpServletRequest request, HttpServletResponse response) {
        String sessionId = WebUtils.getCookieValue(request, verifyCodeCookieName);
        String verifyCode = VerifyCodeUtils.generateCode();
        BufferedImage bufferedImage = VerifyCodeUtils.generateImage(verifyCode);
        response.setContentType(ContentTypeEnum.PNG.getValue());
        try {
            if (sessionId == null) {
                sessionId = UUIDUtils.uuid();
                response.addCookie(new Cookie(verifyCodeCookieName, sessionId));
            }
            verifyCodeRedisUtils.storeCode(sessionId, verifyCode);
            ImageIO.write(bufferedImage, MIMETypeEnum.PNG.getValue(), response.getOutputStream());
        } catch (IOException e) {
            logger.error("返回验证码图片出错： {}", e.getMessage());
        }
    }

    /**
     * 发送手机验证码
     * @param phone
     */
    @PostMapping("sms-code")
    public ResponseStatusVO sendSmsCode(String phone) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (!StringUtils.isEmpty(phone) && RegexUtils.match(RegexUtils.REGEX_PHONE, phone)) {
            try {
                // 此code用于发送短信
                String code = RandomUtils.randomCode(RandomCodeEnum.NUMBER_CODE, 6);
                SendSmsResponse smsResponse = AliyunSmsUtils.sendSms(phone, "signName", "templateCode", "templateParam", null);
                if(smsResponse.getCode() != null && smsResponse.getCode().equals("OK")) {
                    smsCodeRedisUtils.storeCode(SmsCodeRedisUtils.SMS_CODE_LOGIN_PREFIX, phone, code);
                    statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "短信发送成功", smsCodeExpiration);
                } else {
                    logger.error("短信发送失败：{}", smsResponse.getMessage());
                    statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "短信发送失败", null);
                }
            } catch (ClientException e) {
                logger.error("短信发送失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "短信发送失败", null);
            }
        } else {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "错误的手机号", null);
        }
        return statusVO;
    }

    @Autowired
    public void setJwtTokenRedisUtils(JwtTokenRedisUtils jwtTokenRedisUtils) {
        this.jwtTokenRedisUtils = jwtTokenRedisUtils;
    }

    @Autowired
    public void setVerifyCodeRedisUtils(VerifyCodeRedisUtils verifyCodeRedisUtils) {
        this.verifyCodeRedisUtils = verifyCodeRedisUtils;
    }

    @Autowired
    public void setSmsCodeRedisUtils(SmsCodeRedisUtils smsCodeRedisUtils) {
        this.smsCodeRedisUtils = smsCodeRedisUtils;
    }
}
