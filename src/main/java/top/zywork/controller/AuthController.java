package top.zywork.controller;

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
import top.zywork.common.UUIDUtils;
import top.zywork.common.VerifyCodeUtils;
import top.zywork.common.WebUtils;
import top.zywork.enums.ContentTypeEnum;
import top.zywork.enums.MIMETypeEnum;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.security.JwtTokenRedisUtils;
import top.zywork.security.JwtUser;
import top.zywork.security.VerifyCodeRedisUtils;
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

    private JwtTokenRedisUtils jwtTokenRedisUtils;

    private VerifyCodeRedisUtils verifyCodeRedisUtils;

    /**
     * login处理
     */
    @PostMapping("login")
    public void login(String username, String password, String verifyCode) {}

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
    public void sendSmsCode(String phone) {

    }

    @Autowired
    public void setJwtTokenRedisUtils(JwtTokenRedisUtils jwtTokenRedisUtils) {
        this.jwtTokenRedisUtils = jwtTokenRedisUtils;
    }

    @Autowired
    public void setVerifyCodeRedisUtils(VerifyCodeRedisUtils verifyCodeRedisUtils) {
        this.verifyCodeRedisUtils = verifyCodeRedisUtils;
    }
}
