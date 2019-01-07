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
import top.zywork.exception.ServiceException;
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
        try {
            accountDetailService.save(BeanUtils.copy(accountDetailVO, AccountDetailDTO.class));
            return ResponseStatusVO.ok("添加成功", null);
        } catch (ServiceException e) {
            logger.error("添加失败：{}", e.getMessage());
            return ResponseStatusVO.error("添加失败", null);
        }
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<AccountDetailVO> accountDetailVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        try {
            accountDetailService.saveBatch(BeanUtils.copyListObj(accountDetailVOList, AccountDetailDTO.class));
            return ResponseStatusVO.ok("批量添加成功", null);
        } catch (ServiceException e) {
            logger.error("添加失败：{}", e.getMessage());
            return ResponseStatusVO.error("批量添加失败", null);
        }
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        try {
            accountDetailService.removeById(id);
            return ResponseStatusVO.ok("删除成功", null);
        } catch (ServiceException e) {
            logger.error("删除失败：{}", e.getMessage());
            return ResponseStatusVO.error("删除失败", null);
        }
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        try {
            accountDetailService.removeByIds(StringUtils.strArrayToLongArray(ids));
            return ResponseStatusVO.ok("批量删除成功", null);
        } catch (ServiceException e) {
            logger.error("批量删除失败：{}", e.getMessage());
            return ResponseStatusVO.error("批量删除失败", null);
        }
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated AccountDetailVO accountDetailVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        try {
            int updateRows = accountDetailService.update(BeanUtils.copy(accountDetailVO, AccountDetailDTO.class));
            if (updateRows == 1) {
                return ResponseStatusVO.ok("更新成功", null);
            } else {
                return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
            }
        } catch (ServiceException e) {
            logger.error("更新失败：{}", e.getMessage());
            return ResponseStatusVO.error("更新失败", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<AccountDetailVO> accountDetailVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        try {
            accountDetailService.updateBatch(BeanUtils.copyListObj(accountDetailVOList, AccountDetailDTO.class));
            return ResponseStatusVO.ok("批量更新成功", null);
        } catch (ServiceException e) {
            logger.error("批量更新失败：{}", e.getMessage());
            return ResponseStatusVO.error("批量更新失败", null);
        }
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody AccountDetailVO accountDetailVO) {
        try {
            accountDetailService.update(BeanUtils.copy(accountDetailVO, AccountDetailDTO.class));
            return ResponseStatusVO.ok("激活或冻结成功", null);
        } catch (ServiceException e) {
            logger.error("激活或冻结失败：{}", e.getMessage());
            return ResponseStatusVO.error("激活或冻结失败", null);
        }
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<AccountDetailVO> accountDetailVOList) {
        try {
            accountDetailService.updateBatch(BeanUtils.copyListObj(accountDetailVOList, AccountDetailDTO.class));
            return ResponseStatusVO.ok("批量激活或冻结成功", null);
        } catch (ServiceException e) {
            logger.error("批量激活或冻结失败：{}", e.getMessage());
            return ResponseStatusVO.error("批量激活或冻结失败", null);
        }
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        AccountDetailVO accountDetailVO = new AccountDetailVO();
        try {
            Object obj = accountDetailService.getById(id);
            if (obj != null) {
                accountDetailVO = BeanUtils.copy(obj, AccountDetailVO.class);
            }
            return ResponseStatusVO.ok("查询成功", accountDetailVO);
        } catch (ServiceException e) {
            logger.error("返回单个对象JSON数据失败：{}", e.getMessage());
            return ResponseStatusVO.error("查询失败", null);
        }
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        try {
            PagerDTO pagerDTO = accountDetailService.listAll();
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), AccountDetailVO.class));
            return ResponseStatusVO.ok("查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回所有对象JSON数据失败：{}", e.getMessage());
            return ResponseStatusVO.error("查询失败", null);
        }
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody AccountDetailQuery accountDetailQuery) {
        try {
            PagerDTO pagerDTO = accountDetailService.listPageByCondition(accountDetailQuery);
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), AccountDetailVO.class));
            return ResponseStatusVO.ok("查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回指定条件的分页对象JSON数据失败：{}", e.getMessage());
            return ResponseStatusVO.error("查询失败", null);
        }
    }

    @Autowired
    public void setAccountDetailService(AccountDetailService accountDetailService) {
        this.accountDetailService = accountDetailService;
    }
}
