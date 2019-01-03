package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.zywork.annotation.SysLog;
import top.zywork.common.*;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.UserBankcardDTO;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.exception.ServiceException;
import top.zywork.query.UserBankcardQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserBankcardService;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.UserBankcardVO;

import java.util.List;

/**
 * UserBankcardController控制器类<br/>
 *
 * 创建于2018-12-24<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/user-bankcard")
public class UserBankcardController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserBankcardController.class);

    private UserBankcardService userBankcardService;

    /**
     * 绑定银行卡
     * @param accountName
     * @param bankcardNo
     * @return
     */
    @PostMapping("user/bind")
    @SysLog(description = "绑定银行卡")
    public ResponseStatusVO bindBankcard(String accountName, String bankcardNo) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser != null) {
            if (org.apache.commons.lang.StringUtils.isNotEmpty(accountName) && BankCardUtils.checkBankCard(bankcardNo)) {
                String cardInfoJson = BankCardAliapiUtils.getBankCardInfoJson(bankcardNo);
                String bankName = BankCardAliapiUtils.getBankNameByCardInfo(cardInfoJson);
                if (bankName != null) {
                    UserBankcardDTO userBankcardDTO = userBankcardService.getByCardNo(bankcardNo);
                    if (userBankcardDTO == null) {
                        userBankcardDTO = new UserBankcardDTO();
                        userBankcardDTO.setUserId(jwtUser.getUserId());
                        userBankcardDTO.setAccountName(accountName);
                        userBankcardDTO.setBankcardNo(bankcardNo);
                        userBankcardDTO.setBankName(bankName);
                        userBankcardDTO.setBankCode(BankCardAliapiUtils.getBankCodeByCardInfo(cardInfoJson));
                        userBankcardService.save(userBankcardDTO);
                        statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "已绑定银行卡", null);
                    } else {
                        statusVO.okStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "不能再次绑定已绑定的银行卡", null);
                    }
                } else {
                    statusVO.okStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "无法获取银行卡基本信息", null);
                }
            } else {
                statusVO.okStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "填写正确的姓名和银行卡号", null);
            }
        } else {
            statusVO.okStatus(ResponseStatusEnum.AUTHENTICATION_ERROR.getCode(), ResponseStatusEnum.AUTHENTICATION_ERROR.getMessage(), null);
        }
        return statusVO;
    }

    /**
     * 解除绑定银行卡
     * @param bankcardNo
     * @return
     */
    @PostMapping("user/unbind")
    @SysLog(description = "解除绑定银行卡")
    public ResponseStatusVO unbindBankcard(String bankcardNo) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser != null) {
            UserBankcardDTO userBankcardDTO = userBankcardService.getByCardNo(bankcardNo);
            if (userBankcardDTO != null) {
                if (userBankcardDTO.getUserId() == jwtUser.getUserId()) {
                    userBankcardService.removeById(userBankcardDTO.getId());
                    statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "已解除绑定银行卡", null);
                } else {
                    statusVO.okStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "银行卡不属于此用户", null);
                }
            } else {
                statusVO.okStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "不存在的银行卡", null);
            }
        } else {
            statusVO.okStatus(ResponseStatusEnum.AUTHENTICATION_ERROR.getCode(), ResponseStatusEnum.AUTHENTICATION_ERROR.getMessage(), null);
        }
        return statusVO;
    }

    /**
     * 获取银行卡对应的银行名称
     * @param bankcardNo
     * @return
     */
    @PostMapping("user/info")
    public ResponseStatusVO bankcardInfo(String bankcardNo) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (BankCardUtils.checkBankCard(bankcardNo)) {
            String bankName = BankCardAliapiUtils.getBankNameByCardInfo(BankCardAliapiUtils.getBankCardInfoJson(bankcardNo));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "获取银行名称", bankName);
        } else {
            statusVO.okStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "错误的银行卡号", null);
        }
        return statusVO;
    }

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated UserBankcardVO userBankcardVO, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                userBankcardService.save(BeanUtils.copy(userBankcardVO, UserBankcardDTO.class));
                statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "添加成功", null);
            } catch (ServiceException e) {
                logger.error("添加失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "添加失败", null);
            }
        }
        return statusVO;
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<UserBankcardVO> userBankcardVOList, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                userBankcardService.saveBatch(BeanUtils.copyListObj(userBankcardVOList, UserBankcardDTO.class));
                statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "批量添加成功", null);
            } catch (ServiceException e) {
                logger.error("添加失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "批量添加失败", null);
            }
        }
        return statusVO;
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            userBankcardService.removeById(id);
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "删除成功", null);
        } catch (ServiceException e) {
            logger.error("删除失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "删除失败", null);
        }
        return statusVO;
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            userBankcardService.removeByIds(StringUtils.strArrayToLongArray(ids));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "批量删除成功", null);
        } catch (ServiceException e) {
            logger.error("批量删除失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "批量删除失败", null);
        }
        return statusVO;
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated UserBankcardVO userBankcardVO, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                int updateRows = userBankcardService.update(BeanUtils.copy(userBankcardVO, UserBankcardDTO.class));
                if (updateRows == 1) {
                    statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "更新成功", null);
                } else {
                    statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "数据版本号有问题，在此更新前数据已被更新", null);
                }
            } catch (ServiceException e) {
                logger.error("更新失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "更新失败", null);
            }
        }
        return statusVO;
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<UserBankcardVO> userBankcardVOList, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                userBankcardService.updateBatch(BeanUtils.copyListObj(userBankcardVOList, UserBankcardDTO.class));
                statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "批量更新成功", null);
            } catch (ServiceException e) {
                logger.error("批量更新失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "批量更新失败", null);
            }
        }
        return statusVO;
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody UserBankcardVO userBankcardVO) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            userBankcardService.update(BeanUtils.copy(userBankcardVO, UserBankcardDTO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "激活或冻结成功", null);
        } catch (ServiceException e) {
            logger.error("激活或冻结失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "激活或冻结失败", null);
        }
        return statusVO;
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<UserBankcardVO> userBankcardVOList) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            userBankcardService.updateBatch(BeanUtils.copyListObj(userBankcardVOList, UserBankcardDTO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "批量激活或冻结成功", null);
        } catch (ServiceException e) {
            logger.error("批量激活或冻结失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "批量激活或冻结失败", null);
        }
        return statusVO;
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        UserBankcardVO userBankcardVO = new UserBankcardVO();
        try {
            Object obj = userBankcardService.getById(id);
            if (obj != null) {
                userBankcardVO = BeanUtils.copy(obj, UserBankcardVO.class);
            }
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", userBankcardVO);
        } catch (ServiceException e) {
            logger.error("返回单个对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            PagerDTO pagerDTO = userBankcardService.listAll();
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserBankcardVO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回所有对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserBankcardQuery userBankcardQuery) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            PagerDTO pagerDTO = userBankcardService.listPageByCondition(userBankcardQuery);
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserBankcardVO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回指定条件的分页对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    @Autowired
    public void setUserBankcardService(UserBankcardService userBankcardService) {
        this.userBankcardService = userBankcardService;
    }
}
