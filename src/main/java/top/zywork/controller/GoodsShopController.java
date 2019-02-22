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
import top.zywork.dto.GoodsShopDTO;
import top.zywork.query.GoodsShopQuery;
import top.zywork.service.GoodsShopService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.GoodsShopVO;

import java.util.List;

/**
 * GoodsShopController控制器类<br/>
 *
 * 创建于2019-02-22<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/goods-shop")
public class GoodsShopController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsShopController.class);

    private GoodsShopService goodsShopService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated GoodsShopVO goodsShopVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsShopService.save(BeanUtils.copy(goodsShopVO, GoodsShopDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<GoodsShopVO> goodsShopVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsShopService.saveBatch(BeanUtils.copyListObj(goodsShopVOList, GoodsShopDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        goodsShopService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        goodsShopService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated GoodsShopVO goodsShopVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = goodsShopService.update(BeanUtils.copy(goodsShopVO, GoodsShopDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<GoodsShopVO> goodsShopVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsShopService.updateBatch(BeanUtils.copyListObj(goodsShopVOList, GoodsShopDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody GoodsShopVO goodsShopVO) {
        goodsShopService.update(BeanUtils.copy(goodsShopVO, GoodsShopDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<GoodsShopVO> goodsShopVOList) {
        goodsShopService.updateBatch(BeanUtils.copyListObj(goodsShopVOList, GoodsShopDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        GoodsShopVO goodsShopVO = new GoodsShopVO();
        Object obj = goodsShopService.getById(id);
        if (obj != null) {
            goodsShopVO = BeanUtils.copy(obj, GoodsShopVO.class);
        }
        return ResponseStatusVO.ok("查询成功", goodsShopVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = goodsShopService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsShopVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody GoodsShopQuery goodsShopQuery) {
        PagerDTO pagerDTO = goodsShopService.listAllByCondition(goodsShopQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsShopVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody GoodsShopQuery goodsShopQuery) {
        PagerDTO pagerDTO = goodsShopService.listPageByCondition(goodsShopQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsShopVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setGoodsShopService(GoodsShopService goodsShopService) {
        this.goodsShopService = goodsShopService;
    }
}
