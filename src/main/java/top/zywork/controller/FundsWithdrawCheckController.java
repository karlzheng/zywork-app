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
import top.zywork.dto.FundsWithdrawCheckDTO;
import top.zywork.query.FundsWithdrawCheckQuery;
import top.zywork.service.FundsWithdrawCheckService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.FundsWithdrawCheckVO;

import java.util.List;

/**
 * FundsWithdrawCheckController控制器类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/funds-withdraw-check")
public class FundsWithdrawCheckController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(FundsWithdrawCheckController.class);

    private FundsWithdrawCheckService fundsWithdrawCheckService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated FundsWithdrawCheckVO fundsWithdrawCheckVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        fundsWithdrawCheckService.save(BeanUtils.copy(fundsWithdrawCheckVO, FundsWithdrawCheckDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<FundsWithdrawCheckVO> fundsWithdrawCheckVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        fundsWithdrawCheckService.saveBatch(BeanUtils.copyListObj(fundsWithdrawCheckVOList, FundsWithdrawCheckDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        fundsWithdrawCheckService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        fundsWithdrawCheckService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated FundsWithdrawCheckVO fundsWithdrawCheckVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = fundsWithdrawCheckService.update(BeanUtils.copy(fundsWithdrawCheckVO, FundsWithdrawCheckDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<FundsWithdrawCheckVO> fundsWithdrawCheckVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        fundsWithdrawCheckService.updateBatch(BeanUtils.copyListObj(fundsWithdrawCheckVOList, FundsWithdrawCheckDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody FundsWithdrawCheckVO fundsWithdrawCheckVO) {
        fundsWithdrawCheckService.update(BeanUtils.copy(fundsWithdrawCheckVO, FundsWithdrawCheckDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<FundsWithdrawCheckVO> fundsWithdrawCheckVOList) {
        fundsWithdrawCheckService.updateBatch(BeanUtils.copyListObj(fundsWithdrawCheckVOList, FundsWithdrawCheckDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        FundsWithdrawCheckVO fundsWithdrawCheckVO = new FundsWithdrawCheckVO();
        Object obj = fundsWithdrawCheckService.getById(id);
        if (obj != null) {
            fundsWithdrawCheckVO = BeanUtils.copy(obj, FundsWithdrawCheckVO.class);
        }
        return ResponseStatusVO.ok("查询成功", fundsWithdrawCheckVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = fundsWithdrawCheckService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), FundsWithdrawCheckVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody FundsWithdrawCheckQuery fundsWithdrawCheckQuery) {
        PagerDTO pagerDTO = fundsWithdrawCheckService.listAllByCondition(fundsWithdrawCheckQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), FundsWithdrawCheckVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody FundsWithdrawCheckQuery fundsWithdrawCheckQuery) {
        PagerDTO pagerDTO = fundsWithdrawCheckService.listPageByCondition(fundsWithdrawCheckQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), FundsWithdrawCheckVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setFundsWithdrawCheckService(FundsWithdrawCheckService fundsWithdrawCheckService) {
        this.fundsWithdrawCheckService = fundsWithdrawCheckService;
    }
}
