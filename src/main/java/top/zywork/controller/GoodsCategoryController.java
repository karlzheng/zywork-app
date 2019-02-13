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
import top.zywork.dto.GoodsCategoryDTO;
import top.zywork.query.GoodsCategoryQuery;
import top.zywork.service.GoodsCategoryService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.GoodsCategoryVO;

import java.util.List;

/**
 * GoodsCategoryController控制器类<br/>
 *
 * 创建于2019-02-13<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/goods-category")
public class GoodsCategoryController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsCategoryController.class);

    private GoodsCategoryService goodsCategoryService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated GoodsCategoryVO goodsCategoryVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsCategoryService.save(BeanUtils.copy(goodsCategoryVO, GoodsCategoryDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<GoodsCategoryVO> goodsCategoryVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsCategoryService.saveBatch(BeanUtils.copyListObj(goodsCategoryVOList, GoodsCategoryDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        goodsCategoryService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        goodsCategoryService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated GoodsCategoryVO goodsCategoryVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = goodsCategoryService.update(BeanUtils.copy(goodsCategoryVO, GoodsCategoryDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<GoodsCategoryVO> goodsCategoryVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsCategoryService.updateBatch(BeanUtils.copyListObj(goodsCategoryVOList, GoodsCategoryDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody GoodsCategoryVO goodsCategoryVO) {
        goodsCategoryService.update(BeanUtils.copy(goodsCategoryVO, GoodsCategoryDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<GoodsCategoryVO> goodsCategoryVOList) {
        goodsCategoryService.updateBatch(BeanUtils.copyListObj(goodsCategoryVOList, GoodsCategoryDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        GoodsCategoryVO goodsCategoryVO = new GoodsCategoryVO();
        Object obj = goodsCategoryService.getById(id);
        if (obj != null) {
            goodsCategoryVO = BeanUtils.copy(obj, GoodsCategoryVO.class);
        }
        return ResponseStatusVO.ok("查询成功", goodsCategoryVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = goodsCategoryService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsCategoryVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody GoodsCategoryQuery goodsCategoryQuery) {
        PagerDTO pagerDTO = goodsCategoryService.listAllByCondition(goodsCategoryQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsCategoryVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody GoodsCategoryQuery goodsCategoryQuery) {
        PagerDTO pagerDTO = goodsCategoryService.listPageByCondition(goodsCategoryQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsCategoryVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 用户条件查询商品类目
     * @param goodsCategoryQuery
     * @return
     */
    @PostMapping("user/pager-cond")
    public ResponseStatusVO userListPageByCondition(@RequestBody GoodsCategoryQuery goodsCategoryQuery) {
        return listPageByCondition(goodsCategoryQuery);
    }

    @Autowired
    public void setGoodsCategoryService(GoodsCategoryService goodsCategoryService) {
        this.goodsCategoryService = goodsCategoryService;
    }
}
