package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.GoodsCategoryAttributeQuery;
import top.zywork.service.GoodsCategoryAttributeService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.GoodsCategoryAttributeVO;

/**
 * GoodsCategoryAttributeController控制器类<br/>
 *
 * 创建于2019-02-13<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/goods-category-attr")
public class GoodsCategoryAttributeController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsCategoryAttributeController.class);

    private GoodsCategoryAttributeService goodsCategoryAttributeService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = goodsCategoryAttributeService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsCategoryAttributeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = goodsCategoryAttributeService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsCategoryAttributeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody GoodsCategoryAttributeQuery goodsCategoryAttributeQuery) {
        PagerDTO pagerDTO = goodsCategoryAttributeService.listPageByCondition(goodsCategoryAttributeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsCategoryAttributeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setGoodsCategoryAttributeService(GoodsCategoryAttributeService goodsCategoryAttributeService) {
        this.goodsCategoryAttributeService = goodsCategoryAttributeService;
    }
}
