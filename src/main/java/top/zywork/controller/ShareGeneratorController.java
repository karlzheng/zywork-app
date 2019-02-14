package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zywork.common.QrCodeUtils;
import top.zywork.dto.UserUserDetailDTO;
import top.zywork.enums.ContentTypeEnum;
import top.zywork.enums.MIMETypeEnum;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserUserDetailService;
import top.zywork.vo.ResponseStatusVO;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 用户邀请生成控制器<br/>
 *
 * 创建于2018-12-29<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/share-generator")
public class ShareGeneratorController {

    private static final Logger logger = LoggerFactory.getLogger(DistributionController.class);

    @Value("${user.reg-share-url}")
    private String regShareUrl;

    @Value("${user.weixin-gzh-share-url}")
    private String gzhShareUrl;

    private UserUserDetailService userUserDetailService;

    /**
     * 生成用户普通邀请二维码
     */
    @GetMapping("qrcode")
    public ResponseStatusVO generateQrCode(HttpServletResponse response) {
        return generateQrCode(response, regShareUrl);
    }

    /**
     * 生成用户普通邀请链接
     *
     * @return
     */
    @GetMapping("link")
    public ResponseStatusVO generateLink() {
        return generateLink(regShareUrl);
    }

    /**
     * 生成用户公众号邀请二维码
     */
    @GetMapping("gzh-qrcode")
    public ResponseStatusVO generateGzhQrCode(HttpServletResponse response) {
        return generateQrCode(response, gzhShareUrl);
    }

    /**
     * 生成用户公众号邀请链接
     *
     * @return
     */
    @GetMapping("gzh-link")
    public ResponseStatusVO generateGzhLink() {
        return generateLink(gzhShareUrl);
    }

    /**
     * 生成邀请二维码
     * @param response
     * @param shareUrl
     * @return
     */
    public ResponseStatusVO generateQrCode(HttpServletResponse response, String shareUrl) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        UserUserDetailDTO userUserDetailDTO = (UserUserDetailDTO) userUserDetailService.listById(jwtUser.getUserId()).getRows().get(0);
        BufferedImage bufferedImage = QrCodeUtils.generateQrCode(shareUrl + userUserDetailDTO.getUserDetailShareCode(), 200, 200);
        response.setContentType(ContentTypeEnum.PNG.getValue());
        if (bufferedImage != null) {
            try {
                OutputStream outputStream = response.getOutputStream();
                ImageIO.write(bufferedImage, MIMETypeEnum.PNG.getValue(), outputStream);
                outputStream.close();
            } catch (IOException e) {
                logger.error("generate share qr code error： {}", e.getMessage());
            }
        }
        return null;
    }

    /**
     * 生成邀请链接
     * @param shareUrl
     * @return
     */
    private ResponseStatusVO generateLink(String shareUrl) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        UserUserDetailDTO userUserDetailDTO = (UserUserDetailDTO) userUserDetailService.listById(jwtUser.getUserId()).getRows().get(0);
        return ResponseStatusVO.ok("成功获取邀请链接", shareUrl + userUserDetailDTO.getUserDetailShareCode());
    }

    @Autowired
    public void setUserUserDetailService(UserUserDetailService userUserDetailService) {
        this.userUserDetailService = userUserDetailService;
    }
}
