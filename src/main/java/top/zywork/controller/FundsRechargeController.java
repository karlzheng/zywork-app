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
import top.zywork.dto.FundsRechargeDTO;
import top.zywork.query.FundsRechargeQuery;
import top.zywork.service.FundsRechargeService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.FundsRechargeVO;

import java.util.List;

/**
 * FundsRechargeController控制器类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/funds-recharge")
public class FundsRechargeController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(FundsRechargeController.class);

    private FundsRechargeService fundsRechargeService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated FundsRechargeVO fundsRechargeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        fundsRechargeService.save(BeanUtils.copy(fundsRechargeVO, FundsRechargeDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<FundsRechargeVO> fundsRechargeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        fundsRechargeService.saveBatch(BeanUtils.copyListObj(fundsRechargeVOList, FundsRechargeDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        fundsRechargeService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        fundsRechargeService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated FundsRechargeVO fundsRechargeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = fundsRechargeService.update(BeanUtils.copy(fundsRechargeVO, FundsRechargeDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<FundsRechargeVO> fundsRechargeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        fundsRechargeService.updateBatch(BeanUtils.copyListObj(fundsRechargeVOList, FundsRechargeDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody FundsRechargeVO fundsRechargeVO) {
        fundsRechargeService.update(BeanUtils.copy(fundsRechargeVO, FundsRechargeDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<FundsRechargeVO> fundsRechargeVOList) {
        fundsRechargeService.updateBatch(BeanUtils.copyListObj(fundsRechargeVOList, FundsRechargeDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        FundsRechargeVO fundsRechargeVO = new FundsRechargeVO();
        Object obj = fundsRechargeService.getById(id);
        if (obj != null) {
            fundsRechargeVO = BeanUtils.copy(obj, FundsRechargeVO.class);
        }
        return ResponseStatusVO.ok("查询成功", fundsRechargeVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = fundsRechargeService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), FundsRechargeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody FundsRechargeQuery fundsRechargeQuery) {
        PagerDTO pagerDTO = fundsRechargeService.listAllByCondition(fundsRechargeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), FundsRechargeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody FundsRechargeQuery fundsRechargeQuery) {
        PagerDTO pagerDTO = fundsRechargeService.listPageByCondition(fundsRechargeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), FundsRechargeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setFundsRechargeService(FundsRechargeService fundsRechargeService) {
        this.fundsRechargeService = fundsRechargeService;
    }
}
