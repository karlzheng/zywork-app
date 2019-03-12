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
import top.zywork.dto.GoodsOrderLogisticsDTO;
import top.zywork.query.GoodsOrderLogisticsQuery;
import top.zywork.service.GoodsOrderLogisticsService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.GoodsOrderLogisticsVO;

import java.util.List;

/**
 * GoodsOrderLogisticsController控制器类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/goods-order-logistics")
public class GoodsOrderLogisticsController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsOrderLogisticsController.class);

    private GoodsOrderLogisticsService goodsOrderLogisticsService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated GoodsOrderLogisticsVO goodsOrderLogisticsVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsOrderLogisticsService.save(BeanUtils.copy(goodsOrderLogisticsVO, GoodsOrderLogisticsDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<GoodsOrderLogisticsVO> goodsOrderLogisticsVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsOrderLogisticsService.saveBatch(BeanUtils.copyListObj(goodsOrderLogisticsVOList, GoodsOrderLogisticsDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        goodsOrderLogisticsService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        goodsOrderLogisticsService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated GoodsOrderLogisticsVO goodsOrderLogisticsVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = goodsOrderLogisticsService.update(BeanUtils.copy(goodsOrderLogisticsVO, GoodsOrderLogisticsDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<GoodsOrderLogisticsVO> goodsOrderLogisticsVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsOrderLogisticsService.updateBatch(BeanUtils.copyListObj(goodsOrderLogisticsVOList, GoodsOrderLogisticsDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody GoodsOrderLogisticsVO goodsOrderLogisticsVO) {
        goodsOrderLogisticsService.update(BeanUtils.copy(goodsOrderLogisticsVO, GoodsOrderLogisticsDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<GoodsOrderLogisticsVO> goodsOrderLogisticsVOList) {
        goodsOrderLogisticsService.updateBatch(BeanUtils.copyListObj(goodsOrderLogisticsVOList, GoodsOrderLogisticsDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        GoodsOrderLogisticsVO goodsOrderLogisticsVO = new GoodsOrderLogisticsVO();
        Object obj = goodsOrderLogisticsService.getById(id);
        if (obj != null) {
            goodsOrderLogisticsVO = BeanUtils.copy(obj, GoodsOrderLogisticsVO.class);
        }
        return ResponseStatusVO.ok("查询成功", goodsOrderLogisticsVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = goodsOrderLogisticsService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsOrderLogisticsVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody GoodsOrderLogisticsQuery goodsOrderLogisticsQuery) {
        PagerDTO pagerDTO = goodsOrderLogisticsService.listAllByCondition(goodsOrderLogisticsQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsOrderLogisticsVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody GoodsOrderLogisticsQuery goodsOrderLogisticsQuery) {
        PagerDTO pagerDTO = goodsOrderLogisticsService.listPageByCondition(goodsOrderLogisticsQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsOrderLogisticsVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setGoodsOrderLogisticsService(GoodsOrderLogisticsService goodsOrderLogisticsService) {
        this.goodsOrderLogisticsService = goodsOrderLogisticsService;
    }
}
