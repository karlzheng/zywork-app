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
     *
     * @param accountName
     * @param bankcardNo
     * @return
     */
    @PostMapping("user/bind")
    @SysLog(description = "绑定银行卡")
    public ResponseStatusVO bindBankcard(String accountName, String bankcardNo) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        if (org.apache.commons.lang.StringUtils.isEmpty(accountName) || !BankCardUtils.checkBankCard(bankcardNo)) {
            return ResponseStatusVO.dataError("错误的姓名和银行卡号", null);
        }
        String cardInfoJson = BankCardAliapiUtils.getBankCardInfoJson(bankcardNo);
        String bankName = BankCardAliapiUtils.getBankNameByCardInfo(cardInfoJson);
        if (bankName == null) {
            return ResponseStatusVO.dataError("无法获取银行卡基本信息", null);
        }
        UserBankcardDTO userBankcardDTO = userBankcardService.getByCardNo(bankcardNo);
        if (userBankcardDTO != null) {
            return ResponseStatusVO.dataError("不能再次绑定已绑定的银行卡", null);
        }
        userBankcardDTO = new UserBankcardDTO();
        userBankcardDTO.setUserId(jwtUser.getUserId());
        userBankcardDTO.setAccountName(accountName);
        userBankcardDTO.setBankcardNo(bankcardNo);
        userBankcardDTO.setBankName(bankName);
        userBankcardDTO.setBankCode(BankCardAliapiUtils.getBankCodeByCardInfo(cardInfoJson));
        userBankcardService.save(userBankcardDTO);
        return ResponseStatusVO.ok("已绑定银行卡", null);
    }

    /**
     * 解除绑定银行卡
     *
     * @param bankcardNo
     * @return
     */
    @PostMapping("user/unbind")
    @SysLog(description = "解除绑定银行卡")
    public ResponseStatusVO unbindBankcard(String bankcardNo) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        UserBankcardDTO userBankcardDTO = userBankcardService.getByCardNo(bankcardNo);
        if (userBankcardDTO == null) {
            return ResponseStatusVO.dataError("不存在的银行卡", null);
        }
        if (userBankcardDTO.getUserId() != jwtUser.getUserId()) {
            return ResponseStatusVO.dataError("银行卡不属于此用户", null);
        }
        userBankcardService.removeById(userBankcardDTO.getId());
        return ResponseStatusVO.ok("已解除绑定银行卡", null);
    }

    /**
     * 获取银行卡对应的银行名称
     *
     * @param bankcardNo
     * @return
     */
    @PostMapping("user/info")
    public ResponseStatusVO bankcardInfo(String bankcardNo) {
        if (!BankCardUtils.checkBankCard(bankcardNo)) {
            return ResponseStatusVO.dataError("错误的银行卡号", null);
        }
        String bankName = BankCardAliapiUtils.getBankNameByCardInfo(BankCardAliapiUtils.getBankCardInfoJson(bankcardNo));
        return ResponseStatusVO.ok("获取银行名称", bankName);
    }

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated UserBankcardVO userBankcardVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userBankcardService.save(BeanUtils.copy(userBankcardVO, UserBankcardDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<UserBankcardVO> userBankcardVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userBankcardService.saveBatch(BeanUtils.copyListObj(userBankcardVOList, UserBankcardDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        userBankcardService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        userBankcardService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated UserBankcardVO userBankcardVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = userBankcardService.update(BeanUtils.copy(userBankcardVO, UserBankcardDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<UserBankcardVO> userBankcardVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        userBankcardService.updateBatch(BeanUtils.copyListObj(userBankcardVOList, UserBankcardDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody UserBankcardVO userBankcardVO) {
        userBankcardService.update(BeanUtils.copy(userBankcardVO, UserBankcardDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<UserBankcardVO> userBankcardVOList) {
        userBankcardService.updateBatch(BeanUtils.copyListObj(userBankcardVOList, UserBankcardDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        UserBankcardVO userBankcardVO = new UserBankcardVO();
        Object obj = userBankcardService.getById(id);
        if (obj != null) {
            userBankcardVO = BeanUtils.copy(obj, UserBankcardVO.class);
        }
        return ResponseStatusVO.ok("查询成功", userBankcardVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userBankcardService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserBankcardVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserBankcardQuery userBankcardQuery) {
        PagerDTO pagerDTO = userBankcardService.listAllByCondition(userBankcardQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserBankcardVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 用户根据条件查询自己的所有银行卡
     * @param userBankcardQuery
     * @return
     */
    @PostMapping("user/all-cond")
    public ResponseStatusVO userListAllByCondition(@RequestBody UserBankcardQuery userBankcardQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        userBankcardQuery.setUserId(jwtUser.getUserId());
        return listAllByCondition(userBankcardQuery);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserBankcardQuery userBankcardQuery) {
        PagerDTO pagerDTO = userBankcardService.listPageByCondition(userBankcardQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserBankcardVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setUserBankcardService(UserBankcardService userBankcardService) {
        this.userBankcardService = userBankcardService;
    }
}
