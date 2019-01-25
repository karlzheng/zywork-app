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
import top.zywork.dto.StatisticsDauDTO;
import top.zywork.query.StatisticsDauQuery;
import top.zywork.service.StatisticsDauService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.StatisticsDauVO;

import java.util.List;

/**
 * StatisticsDauController控制器类<br/>
 *
 * 创建于2019-01-18<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/statistics-dau")
public class StatisticsDauController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(StatisticsDauController.class);

    private StatisticsDauService statisticsDauService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated StatisticsDauVO statisticsDauVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        statisticsDauService.save(BeanUtils.copy(statisticsDauVO, StatisticsDauDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<StatisticsDauVO> statisticsDauVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        statisticsDauService.saveBatch(BeanUtils.copyListObj(statisticsDauVOList, StatisticsDauDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        statisticsDauService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        statisticsDauService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated StatisticsDauVO statisticsDauVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = statisticsDauService.update(BeanUtils.copy(statisticsDauVO, StatisticsDauDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<StatisticsDauVO> statisticsDauVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        statisticsDauService.updateBatch(BeanUtils.copyListObj(statisticsDauVOList, StatisticsDauDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody StatisticsDauVO statisticsDauVO) {
        statisticsDauService.update(BeanUtils.copy(statisticsDauVO, StatisticsDauDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<StatisticsDauVO> statisticsDauVOList) {
        statisticsDauService.updateBatch(BeanUtils.copyListObj(statisticsDauVOList, StatisticsDauDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        StatisticsDauVO statisticsDauVO = new StatisticsDauVO();
        Object obj = statisticsDauService.getById(id);
        if (obj != null) {
            statisticsDauVO = BeanUtils.copy(obj, StatisticsDauVO.class);
        }
        return ResponseStatusVO.ok("查询成功", statisticsDauVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = statisticsDauService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), StatisticsDauVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody StatisticsDauQuery statisticsDauQuery) {
        PagerDTO pagerDTO = statisticsDauService.listAllByCondition(statisticsDauQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), StatisticsDauVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody StatisticsDauQuery statisticsDauQuery) {
        PagerDTO pagerDTO = statisticsDauService.listPageByCondition(statisticsDauQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), StatisticsDauVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setStatisticsDauService(StatisticsDauService statisticsDauService) {
        this.statisticsDauService = statisticsDauService;
    }
}
