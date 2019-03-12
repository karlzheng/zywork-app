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
import top.zywork.dto.GoodsOrderItemDTO;
import top.zywork.query.GoodsOrderItemQuery;
import top.zywork.service.GoodsOrderItemService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.GoodsOrderItemVO;

import java.util.List;

/**
 * GoodsOrderItemController控制器类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/goods-order-item")
public class GoodsOrderItemController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsOrderItemController.class);

    private GoodsOrderItemService goodsOrderItemService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated GoodsOrderItemVO goodsOrderItemVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsOrderItemService.save(BeanUtils.copy(goodsOrderItemVO, GoodsOrderItemDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<GoodsOrderItemVO> goodsOrderItemVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsOrderItemService.saveBatch(BeanUtils.copyListObj(goodsOrderItemVOList, GoodsOrderItemDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        goodsOrderItemService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        goodsOrderItemService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated GoodsOrderItemVO goodsOrderItemVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = goodsOrderItemService.update(BeanUtils.copy(goodsOrderItemVO, GoodsOrderItemDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<GoodsOrderItemVO> goodsOrderItemVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsOrderItemService.updateBatch(BeanUtils.copyListObj(goodsOrderItemVOList, GoodsOrderItemDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody GoodsOrderItemVO goodsOrderItemVO) {
        goodsOrderItemService.update(BeanUtils.copy(goodsOrderItemVO, GoodsOrderItemDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<GoodsOrderItemVO> goodsOrderItemVOList) {
        goodsOrderItemService.updateBatch(BeanUtils.copyListObj(goodsOrderItemVOList, GoodsOrderItemDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        GoodsOrderItemVO goodsOrderItemVO = new GoodsOrderItemVO();
        Object obj = goodsOrderItemService.getById(id);
        if (obj != null) {
            goodsOrderItemVO = BeanUtils.copy(obj, GoodsOrderItemVO.class);
        }
        return ResponseStatusVO.ok("查询成功", goodsOrderItemVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = goodsOrderItemService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsOrderItemVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody GoodsOrderItemQuery goodsOrderItemQuery) {
        PagerDTO pagerDTO = goodsOrderItemService.listAllByCondition(goodsOrderItemQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsOrderItemVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody GoodsOrderItemQuery goodsOrderItemQuery) {
        PagerDTO pagerDTO = goodsOrderItemService.listPageByCondition(goodsOrderItemQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsOrderItemVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setGoodsOrderItemService(GoodsOrderItemService goodsOrderItemService) {
        this.goodsOrderItemService = goodsOrderItemService;
    }
}
