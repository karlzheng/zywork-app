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
import top.zywork.dto.FundsFrezeeDTO;
import top.zywork.query.FundsFrezeeQuery;
import top.zywork.service.FundsFrezeeService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.FundsFrezeeVO;

import java.util.List;

/**
 * FundsFrezeeController控制器类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/funds-frezee")
public class FundsFrezeeController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(FundsFrezeeController.class);

    private FundsFrezeeService fundsFrezeeService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated FundsFrezeeVO fundsFrezeeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        fundsFrezeeService.save(BeanUtils.copy(fundsFrezeeVO, FundsFrezeeDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<FundsFrezeeVO> fundsFrezeeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        fundsFrezeeService.saveBatch(BeanUtils.copyListObj(fundsFrezeeVOList, FundsFrezeeDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        fundsFrezeeService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        fundsFrezeeService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated FundsFrezeeVO fundsFrezeeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = fundsFrezeeService.update(BeanUtils.copy(fundsFrezeeVO, FundsFrezeeDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<FundsFrezeeVO> fundsFrezeeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        fundsFrezeeService.updateBatch(BeanUtils.copyListObj(fundsFrezeeVOList, FundsFrezeeDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody FundsFrezeeVO fundsFrezeeVO) {
        fundsFrezeeService.update(BeanUtils.copy(fundsFrezeeVO, FundsFrezeeDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<FundsFrezeeVO> fundsFrezeeVOList) {
        fundsFrezeeService.updateBatch(BeanUtils.copyListObj(fundsFrezeeVOList, FundsFrezeeDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        FundsFrezeeVO fundsFrezeeVO = new FundsFrezeeVO();
        Object obj = fundsFrezeeService.getById(id);
        if (obj != null) {
            fundsFrezeeVO = BeanUtils.copy(obj, FundsFrezeeVO.class);
        }
        return ResponseStatusVO.ok("查询成功", fundsFrezeeVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = fundsFrezeeService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), FundsFrezeeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody FundsFrezeeQuery fundsFrezeeQuery) {
        PagerDTO pagerDTO = fundsFrezeeService.listAllByCondition(fundsFrezeeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), FundsFrezeeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody FundsFrezeeQuery fundsFrezeeQuery) {
        PagerDTO pagerDTO = fundsFrezeeService.listPageByCondition(fundsFrezeeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), FundsFrezeeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setFundsFrezeeService(FundsFrezeeService fundsFrezeeService) {
        this.fundsFrezeeService = fundsFrezeeService;
    }
}
