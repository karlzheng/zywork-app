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
import top.zywork.dto.GoodsAttributeDTO;
import top.zywork.query.GoodsAttributeQuery;
import top.zywork.service.GoodsAttributeService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.GoodsAttributeVO;

import java.util.List;

/**
 * GoodsAttributeController控制器类<br/>
 *
 * 创建于2019-02-13<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/goods-attribute")
public class GoodsAttributeController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsAttributeController.class);

    private GoodsAttributeService goodsAttributeService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated GoodsAttributeVO goodsAttributeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsAttributeService.save(BeanUtils.copy(goodsAttributeVO, GoodsAttributeDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<GoodsAttributeVO> goodsAttributeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsAttributeService.saveBatch(BeanUtils.copyListObj(goodsAttributeVOList, GoodsAttributeDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        goodsAttributeService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        goodsAttributeService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated GoodsAttributeVO goodsAttributeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = goodsAttributeService.update(BeanUtils.copy(goodsAttributeVO, GoodsAttributeDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<GoodsAttributeVO> goodsAttributeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsAttributeService.updateBatch(BeanUtils.copyListObj(goodsAttributeVOList, GoodsAttributeDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody GoodsAttributeVO goodsAttributeVO) {
        goodsAttributeService.update(BeanUtils.copy(goodsAttributeVO, GoodsAttributeDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<GoodsAttributeVO> goodsAttributeVOList) {
        goodsAttributeService.updateBatch(BeanUtils.copyListObj(goodsAttributeVOList, GoodsAttributeDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        GoodsAttributeVO goodsAttributeVO = new GoodsAttributeVO();
        Object obj = goodsAttributeService.getById(id);
        if (obj != null) {
            goodsAttributeVO = BeanUtils.copy(obj, GoodsAttributeVO.class);
        }
        return ResponseStatusVO.ok("查询成功", goodsAttributeVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = goodsAttributeService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsAttributeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody GoodsAttributeQuery goodsAttributeQuery) {
        PagerDTO pagerDTO = goodsAttributeService.listAllByCondition(goodsAttributeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsAttributeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody GoodsAttributeQuery goodsAttributeQuery) {
        PagerDTO pagerDTO = goodsAttributeService.listPageByCondition(goodsAttributeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsAttributeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setGoodsAttributeService(GoodsAttributeService goodsAttributeService) {
        this.goodsAttributeService = goodsAttributeService;
    }
}
