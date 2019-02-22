package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.common.BindingResultUtils;
import top.zywork.dto.GoodsCategoryAttributeDTO;
import top.zywork.dto.PagerDTO;
import top.zywork.query.GoodsCategoryAttributeQuery;
import top.zywork.service.GoodsCategoryAttributeService;
import top.zywork.vo.GoodsCategoryAttributeVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ResponseStatusVO;

import java.util.List;

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

    /**
     * 批量保存商品类目与商品属性的关系
     *
     * @param goodsCategoryAttributeVOList
     * @param bindingResult
     * @return
     */
    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<GoodsCategoryAttributeVO> goodsCategoryAttributeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsCategoryAttributeService.saveBatch(BeanUtils.copyListObj(goodsCategoryAttributeVOList, GoodsCategoryAttributeDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    /**
     * 批量更新类目与属性关系
     * @param goodsCategoryAttributeVOList
     * @param bindingResult
     * @return
     */
    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<GoodsCategoryAttributeVO> goodsCategoryAttributeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsCategoryAttributeService.updateBatch(BeanUtils.copyListObj(goodsCategoryAttributeVOList, GoodsCategoryAttributeDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

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

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody GoodsCategoryAttributeQuery goodsCategoryAttributeQuery) {
        PagerDTO pagerDTO = goodsCategoryAttributeService.listAllByCondition(goodsCategoryAttributeQuery);
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
