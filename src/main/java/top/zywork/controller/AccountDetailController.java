package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.common.BindingResultUtils;
import top.zywork.common.StringUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.AccountDetailDTO;
import top.zywork.query.AccountDetailQuery;
import top.zywork.service.AccountDetailService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.AccountDetailVO;

import java.util.List;

/**
 * AccountDetailController控制器类<br/>
 *
 * 创建于2018-12-25<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/accoundetail")
public class AccountDetailController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(AccountDetailController.class);

    private AccountDetailService accountDetailService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated AccountDetailVO accountDetailVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        accountDetailService.save(BeanUtils.copy(accountDetailVO, AccountDetailDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<AccountDetailVO> accountDetailVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        accountDetailService.saveBatch(BeanUtils.copyListObj(accountDetailVOList, AccountDetailDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        accountDetailService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        accountDetailService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated AccountDetailVO accountDetailVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = accountDetailService.update(BeanUtils.copy(accountDetailVO, AccountDetailDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<AccountDetailVO> accountDetailVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        accountDetailService.updateBatch(BeanUtils.copyListObj(accountDetailVOList, AccountDetailDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody AccountDetailVO accountDetailVO) {
        accountDetailService.update(BeanUtils.copy(accountDetailVO, AccountDetailDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<AccountDetailVO> accountDetailVOList) {
        accountDetailService.updateBatch(BeanUtils.copyListObj(accountDetailVOList, AccountDetailDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        AccountDetailVO accountDetailVO = new AccountDetailVO();
        Object obj = accountDetailService.getById(id);
        if (obj != null) {
            accountDetailVO = BeanUtils.copy(obj, AccountDetailVO.class);
        }
        return ResponseStatusVO.ok("查询成功", accountDetailVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = accountDetailService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), AccountDetailVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody AccountDetailQuery accountDetailQuery) {
        PagerDTO pagerDTO = accountDetailService.listAllByCondition(accountDetailQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), AccountDetailVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody AccountDetailQuery accountDetailQuery) {
        PagerDTO pagerDTO = accountDetailService.listPageByCondition(accountDetailQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), AccountDetailVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setAccountDetailService(AccountDetailService accountDetailService) {
        this.accountDetailService = accountDetailService;
    }
}
