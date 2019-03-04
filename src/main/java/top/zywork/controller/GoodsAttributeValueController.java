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
import top.zywork.dto.GoodsAttributeValueDTO;
import top.zywork.query.GoodsAttributeValueQuery;
import top.zywork.service.GoodsAttributeValueService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.GoodsAttributeValueVO;

import java.util.List;

/**
 * GoodsAttributeValueController控制器类<br/>
 *
 * 创建于2019-03-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/goods-attribute-value")
public class GoodsAttributeValueController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsAttributeValueController.class);

    private GoodsAttributeValueService goodsAttributeValueService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated GoodsAttributeValueVO goodsAttributeValueVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsAttributeValueService.save(BeanUtils.copy(goodsAttributeValueVO, GoodsAttributeValueDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<GoodsAttributeValueVO> goodsAttributeValueVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsAttributeValueService.saveBatch(BeanUtils.copyListObj(goodsAttributeValueVOList, GoodsAttributeValueDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        goodsAttributeValueService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        goodsAttributeValueService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated GoodsAttributeValueVO goodsAttributeValueVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = goodsAttributeValueService.update(BeanUtils.copy(goodsAttributeValueVO, GoodsAttributeValueDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<GoodsAttributeValueVO> goodsAttributeValueVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsAttributeValueService.updateBatch(BeanUtils.copyListObj(goodsAttributeValueVOList, GoodsAttributeValueDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody GoodsAttributeValueVO goodsAttributeValueVO) {
        goodsAttributeValueService.update(BeanUtils.copy(goodsAttributeValueVO, GoodsAttributeValueDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<GoodsAttributeValueVO> goodsAttributeValueVOList) {
        goodsAttributeValueService.updateBatch(BeanUtils.copyListObj(goodsAttributeValueVOList, GoodsAttributeValueDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        GoodsAttributeValueVO goodsAttributeValueVO = new GoodsAttributeValueVO();
        Object obj = goodsAttributeValueService.getById(id);
        if (obj != null) {
            goodsAttributeValueVO = BeanUtils.copy(obj, GoodsAttributeValueVO.class);
        }
        return ResponseStatusVO.ok("查询成功", goodsAttributeValueVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = goodsAttributeValueService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsAttributeValueVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody GoodsAttributeValueQuery goodsAttributeValueQuery) {
        PagerDTO pagerDTO = goodsAttributeValueService.listAllByCondition(goodsAttributeValueQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsAttributeValueVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody GoodsAttributeValueQuery goodsAttributeValueQuery) {
        PagerDTO pagerDTO = goodsAttributeValueService.listPageByCondition(goodsAttributeValueQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsAttributeValueVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setGoodsAttributeValueService(GoodsAttributeValueService goodsAttributeValueService) {
        this.goodsAttributeValueService = goodsAttributeValueService;
    }
}
