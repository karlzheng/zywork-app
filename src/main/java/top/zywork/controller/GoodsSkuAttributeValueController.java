package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.GoodsSkuAttributeValueQuery;
import top.zywork.service.GoodsSkuAttributeValueService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.GoodsSkuAttributeValueVO;

/**
 * GoodsSkuAttributeValueController控制器类<br/>
 *
 * 创建于2019-02-28<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/goods-sku-attr-val")
public class GoodsSkuAttributeValueController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsSkuAttributeValueController.class);

    private GoodsSkuAttributeValueService goodsSkuAttributeValueService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = goodsSkuAttributeValueService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsSkuAttributeValueVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = goodsSkuAttributeValueService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsSkuAttributeValueVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody GoodsSkuAttributeValueQuery goodsSkuAttributeValueQuery) {
        PagerDTO pagerDTO = goodsSkuAttributeValueService.listAllByCondition(goodsSkuAttributeValueQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsSkuAttributeValueVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody GoodsSkuAttributeValueQuery goodsSkuAttributeValueQuery) {
        PagerDTO pagerDTO = goodsSkuAttributeValueService.listPageByCondition(goodsSkuAttributeValueQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsSkuAttributeValueVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setGoodsSkuAttributeValueService(GoodsSkuAttributeValueService goodsSkuAttributeValueService) {
        this.goodsSkuAttributeValueService = goodsSkuAttributeValueService;
    }
}
