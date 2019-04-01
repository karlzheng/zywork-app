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
import top.zywork.dto.FundsWithdrawDTO;
import top.zywork.query.FundsWithdrawQuery;
import top.zywork.service.FundsWithdrawService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.FundsWithdrawVO;

import java.util.List;

/**
 * FundsWithdrawController控制器类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/funds-withdraw")
public class FundsWithdrawController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(FundsWithdrawController.class);

    private FundsWithdrawService fundsWithdrawService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated FundsWithdrawVO fundsWithdrawVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        fundsWithdrawService.save(BeanUtils.copy(fundsWithdrawVO, FundsWithdrawDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<FundsWithdrawVO> fundsWithdrawVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        fundsWithdrawService.saveBatch(BeanUtils.copyListObj(fundsWithdrawVOList, FundsWithdrawDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        fundsWithdrawService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        fundsWithdrawService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated FundsWithdrawVO fundsWithdrawVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = fundsWithdrawService.update(BeanUtils.copy(fundsWithdrawVO, FundsWithdrawDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<FundsWithdrawVO> fundsWithdrawVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        fundsWithdrawService.updateBatch(BeanUtils.copyListObj(fundsWithdrawVOList, FundsWithdrawDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody FundsWithdrawVO fundsWithdrawVO) {
        fundsWithdrawService.update(BeanUtils.copy(fundsWithdrawVO, FundsWithdrawDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<FundsWithdrawVO> fundsWithdrawVOList) {
        fundsWithdrawService.updateBatch(BeanUtils.copyListObj(fundsWithdrawVOList, FundsWithdrawDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        FundsWithdrawVO fundsWithdrawVO = new FundsWithdrawVO();
        Object obj = fundsWithdrawService.getById(id);
        if (obj != null) {
            fundsWithdrawVO = BeanUtils.copy(obj, FundsWithdrawVO.class);
        }
        return ResponseStatusVO.ok("查询成功", fundsWithdrawVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = fundsWithdrawService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), FundsWithdrawVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody FundsWithdrawQuery fundsWithdrawQuery) {
        PagerDTO pagerDTO = fundsWithdrawService.listAllByCondition(fundsWithdrawQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), FundsWithdrawVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody FundsWithdrawQuery fundsWithdrawQuery) {
        PagerDTO pagerDTO = fundsWithdrawService.listPageByCondition(fundsWithdrawQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), FundsWithdrawVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setFundsWithdrawService(FundsWithdrawService fundsWithdrawService) {
        this.fundsWithdrawService = fundsWithdrawService;
    }
}
