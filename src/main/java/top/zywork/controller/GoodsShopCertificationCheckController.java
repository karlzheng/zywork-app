package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.GoodsShopCertificationCheckQuery;
import top.zywork.service.GoodsShopCertificationCheckService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.GoodsShopCertificationCheckVO;

/**
 * GoodsShopCertificationCheckController控制器类<br/>
 *
 * 创建于2019-02-22<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/shop-certification-check")
public class GoodsShopCertificationCheckController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsShopCertificationCheckController.class);

    private GoodsShopCertificationCheckService goodsShopCertificationCheckService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = goodsShopCertificationCheckService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsShopCertificationCheckVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = goodsShopCertificationCheckService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsShopCertificationCheckVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody GoodsShopCertificationCheckQuery goodsShopCertificationCheckQuery) {
        PagerDTO pagerDTO = goodsShopCertificationCheckService.listAllByCondition(goodsShopCertificationCheckQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsShopCertificationCheckVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody GoodsShopCertificationCheckQuery goodsShopCertificationCheckQuery) {
        PagerDTO pagerDTO = goodsShopCertificationCheckService.listPageByCondition(goodsShopCertificationCheckQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsShopCertificationCheckVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setGoodsShopCertificationCheckService(GoodsShopCertificationCheckService goodsShopCertificationCheckService) {
        this.goodsShopCertificationCheckService = goodsShopCertificationCheckService;
    }
}
