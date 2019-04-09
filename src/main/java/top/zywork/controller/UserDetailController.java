package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.zywork.common.BeanUtils;
import top.zywork.common.BindingResultUtils;
import top.zywork.common.StringUtils;
import top.zywork.common.UploadUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.UserDetailDTO;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.enums.UploadTypeEnum;
import top.zywork.query.UserDetailQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UploadService;
import top.zywork.service.UserDetailService;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.UserDetailVO;

import java.util.List;

/**
 * UserDetailController控制器类<br/>
 *
 * 创建于2019-01-29<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/user-detail")
public class UserDetailController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailController.class);

    @Value("${storage.provider}")
    private String storageProvider;

    @Value("${storage.local.compressSizes}")
    private String compressSizes;

    @Value("${storage.local.compressScales}")
    private String compressScales;

    @Value("${storage.local.user.imgParentDir}")
    private String imgParentDir;

    @Value("${storage.local.user.imgDir}")
    private String imgDir;

    @Value("${storage.local.user.imgUrl}")
    private String imgUrl;

    private UserDetailService userDetailService;

    private UploadService uploadService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated UserDetailVO userDetailVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userDetailService.save(BeanUtils.copy(userDetailVO, UserDetailDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<UserDetailVO> userDetailVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userDetailService.saveBatch(BeanUtils.copyListObj(userDetailVOList, UserDetailDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        userDetailService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        userDetailService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated UserDetailVO userDetailVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        return update(userDetailVO);
    }

    private ResponseStatusVO update(UserDetailVO userDetailVO) {
        int updateRows = userDetailService.update(BeanUtils.copy(userDetailVO, UserDetailDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    /**
     * 用户更新自己的详情信息
     * @param userDetailVO
     * @param bindingResult
     * @return
     */
    @PostMapping("user/update")
    public ResponseStatusVO userUpdate(@RequestBody @Validated UserDetailVO userDetailVO, BindingResult bindingResult) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        userDetailVO.setId(jwtUser.getUserId());
        return update(userDetailVO, bindingResult);
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<UserDetailVO> userDetailVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userDetailService.updateBatch(BeanUtils.copyListObj(userDetailVOList, UserDetailDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody UserDetailVO userDetailVO) {
        userDetailService.update(BeanUtils.copy(userDetailVO, UserDetailDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<UserDetailVO> userDetailVOList) {
        userDetailService.updateBatch(BeanUtils.copyListObj(userDetailVOList, UserDetailDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        UserDetailVO userDetailVO = new UserDetailVO();
        Object obj = userDetailService.getById(id);
        if (obj != null) {
            userDetailVO = BeanUtils.copy(obj, UserDetailVO.class);
        }
        return ResponseStatusVO.ok("查询成功", userDetailVO);
    }

    /**
     * 用户获取用户详情信息
     * @return
     */
    @GetMapping("user/one")
    public ResponseStatusVO userGetById() {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        return getById(jwtUser.getUserId());
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userDetailService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserDetailVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserDetailQuery userDetailQuery) {
        PagerDTO pagerDTO = userDetailService.listAllByCondition(userDetailQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserDetailVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserDetailQuery userDetailQuery) {
        PagerDTO pagerDTO = userDetailService.listPageByCondition(userDetailQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserDetailVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 上传头像
     * @param file
     * @return
     */
    @PostMapping("admin/upload-headicon/{userId}")
    public ResponseStatusVO uploadHeadicon(@PathVariable("userId") Long userId, MultipartFile file) {
        UploadUtils.UploadOptions uploadOptions = new UploadUtils.UploadOptions(imgParentDir, imgDir, imgUrl);
        ResponseStatusVO responseStatusVO = uploadService.uploadFile(storageProvider, file, UploadTypeEnum.IMAGE.getAllowedExts(), UploadTypeEnum.IMAGE.getMaxSize(), uploadOptions);
        if (responseStatusVO.getCode() == ResponseStatusEnum.OK.getCode().intValue()) {
            UserDetailVO userDetailVO = new UserDetailVO();
            userDetailVO.setId(userId);
            userDetailVO.setHeadicon(responseStatusVO.getData().toString());
            update(userDetailVO);
        }
        return responseStatusVO;
    }

    /**
     * 用户上传头像
     * @param file
     * @return
     */
    @PostMapping("user/upload-headicon")
    public ResponseStatusVO userUploadHeadicon(MultipartFile file) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        return uploadHeadicon(jwtUser.getUserId(), file);
    }

    /**
     * 用户上传微信二维码
     * @param file
     * @return
     */
    @PostMapping("user/upload-wx-qrcode")
    public ResponseStatusVO userUploadWechatQrcode(MultipartFile file) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        UploadUtils.UploadOptions uploadOptions = new UploadUtils.UploadOptions(imgParentDir, imgDir, imgUrl);
        ResponseStatusVO responseStatusVO = uploadService.uploadFile(storageProvider, file, UploadTypeEnum.IMAGE.getAllowedExts(), UploadTypeEnum.IMAGE.getMaxSize(), uploadOptions);
        if (responseStatusVO.getCode() == ResponseStatusEnum.OK.getCode().intValue()) {
            UserDetailVO userDetailVO = new UserDetailVO();
            userDetailVO.setId(jwtUser.getUserId());
            userDetailVO.setWechatQrcode(responseStatusVO.getData().toString());
            update(userDetailVO);
        }
        return responseStatusVO;
    }

    /**
     * 用户上传支付宝二维码
     * @param file
     * @return
     */
    @PostMapping("user/upload-ali-qrcode")
    public ResponseStatusVO userUploadAlipayQrcode(MultipartFile file) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        UploadUtils.UploadOptions uploadOptions = new UploadUtils.UploadOptions(imgParentDir, imgDir, imgUrl);
        ResponseStatusVO responseStatusVO = uploadService.uploadFile(storageProvider, file, UploadTypeEnum.IMAGE.getAllowedExts(), UploadTypeEnum.IMAGE.getMaxSize(), uploadOptions);
        if (responseStatusVO.getCode() == ResponseStatusEnum.OK.getCode().intValue()) {
            UserDetailVO userDetailVO = new UserDetailVO();
            userDetailVO.setId(jwtUser.getUserId());
            userDetailVO.setAlipayQrcode(responseStatusVO.getData().toString());
            update(userDetailVO);
        }
        return responseStatusVO;
    }

    /**
     * 用户上传QQ二维码
     * @param file
     * @return
     */
    @PostMapping("user/upload-qq-qrcode")
    public ResponseStatusVO userUploadQqQrcode(MultipartFile file) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        UploadUtils.UploadOptions uploadOptions = new UploadUtils.UploadOptions(imgParentDir, imgDir, imgUrl);
        ResponseStatusVO responseStatusVO = uploadService.uploadFile(storageProvider, file, UploadTypeEnum.IMAGE.getAllowedExts(), UploadTypeEnum.IMAGE.getMaxSize(), uploadOptions);
        if (responseStatusVO.getCode() == ResponseStatusEnum.OK.getCode().intValue()) {
            UserDetailVO userDetailVO = new UserDetailVO();
            userDetailVO.setId(jwtUser.getUserId());
            userDetailVO.setQqQrcode(responseStatusVO.getData().toString());
            update(userDetailVO);
        }
        return responseStatusVO;
    }

    @Autowired
    public void setUserDetailService(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Autowired
    public void setUploadService(UploadService uploadService) {
        this.uploadService = uploadService;
    }
}
