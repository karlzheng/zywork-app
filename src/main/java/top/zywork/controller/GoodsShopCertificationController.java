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
import top.zywork.dto.GoodsShopCertificationDTO;
import top.zywork.query.GoodsShopCertificationQuery;
import top.zywork.service.GoodsShopCertificationService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.GoodsShopCertificationVO;

import java.util.List;

/**
 * GoodsShopCertificationController控制器类<br/>
 *
 * 创建于2019-02-22<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/goods-shop-certification")
public class GoodsShopCertificationController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsShopCertificationController.class);

    private GoodsShopCertificationService goodsShopCertificationService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated GoodsShopCertificationVO goodsShopCertificationVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsShopCertificationService.save(BeanUtils.copy(goodsShopCertificationVO, GoodsShopCertificationDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<GoodsShopCertificationVO> goodsShopCertificationVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsShopCertificationService.saveBatch(BeanUtils.copyListObj(goodsShopCertificationVOList, GoodsShopCertificationDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        goodsShopCertificationService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        goodsShopCertificationService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated GoodsShopCertificationVO goodsShopCertificationVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = goodsShopCertificationService.update(BeanUtils.copy(goodsShopCertificationVO, GoodsShopCertificationDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<GoodsShopCertificationVO> goodsShopCertificationVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsShopCertificationService.updateBatch(BeanUtils.copyListObj(goodsShopCertificationVOList, GoodsShopCertificationDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody GoodsShopCertificationVO goodsShopCertificationVO) {
        goodsShopCertificationService.update(BeanUtils.copy(goodsShopCertificationVO, GoodsShopCertificationDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<GoodsShopCertificationVO> goodsShopCertificationVOList) {
        goodsShopCertificationService.updateBatch(BeanUtils.copyListObj(goodsShopCertificationVOList, GoodsShopCertificationDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        GoodsShopCertificationVO goodsShopCertificationVO = new GoodsShopCertificationVO();
        Object obj = goodsShopCertificationService.getById(id);
        if (obj != null) {
            goodsShopCertificationVO = BeanUtils.copy(obj, GoodsShopCertificationVO.class);
        }
        return ResponseStatusVO.ok("查询成功", goodsShopCertificationVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = goodsShopCertificationService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsShopCertificationVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody GoodsShopCertificationQuery goodsShopCertificationQuery) {
        PagerDTO pagerDTO = goodsShopCertificationService.listAllByCondition(goodsShopCertificationQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsShopCertificationVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody GoodsShopCertificationQuery goodsShopCertificationQuery) {
        PagerDTO pagerDTO = goodsShopCertificationService.listPageByCondition(goodsShopCertificationQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsShopCertificationVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setGoodsShopCertificationService(GoodsShopCertificationService goodsShopCertificationService) {
        this.goodsShopCertificationService = goodsShopCertificationService;
    }
}
