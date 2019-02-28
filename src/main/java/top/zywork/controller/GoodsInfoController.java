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
import top.zywork.dto.GoodsInfoDTO;
import top.zywork.query.GoodsInfoQuery;
import top.zywork.service.GoodsInfoService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.GoodsInfoVO;

import java.util.List;

/**
 * GoodsInfoController控制器类<br/>
 *
 * 创建于2019-02-27<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/goods-info")
public class GoodsInfoController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsInfoController.class);

    private GoodsInfoService goodsInfoService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated GoodsInfoVO goodsInfoVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsInfoService.save(BeanUtils.copy(goodsInfoVO, GoodsInfoDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<GoodsInfoVO> goodsInfoVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsInfoService.saveBatch(BeanUtils.copyListObj(goodsInfoVOList, GoodsInfoDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        goodsInfoService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        goodsInfoService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated GoodsInfoVO goodsInfoVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = goodsInfoService.update(BeanUtils.copy(goodsInfoVO, GoodsInfoDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<GoodsInfoVO> goodsInfoVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsInfoService.updateBatch(BeanUtils.copyListObj(goodsInfoVOList, GoodsInfoDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody GoodsInfoVO goodsInfoVO) {
        goodsInfoService.update(BeanUtils.copy(goodsInfoVO, GoodsInfoDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<GoodsInfoVO> goodsInfoVOList) {
        goodsInfoService.updateBatch(BeanUtils.copyListObj(goodsInfoVOList, GoodsInfoDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        GoodsInfoVO goodsInfoVO = new GoodsInfoVO();
        Object obj = goodsInfoService.getById(id);
        if (obj != null) {
            goodsInfoVO = BeanUtils.copy(obj, GoodsInfoVO.class);
        }
        return ResponseStatusVO.ok("查询成功", goodsInfoVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = goodsInfoService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsInfoVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody GoodsInfoQuery goodsInfoQuery) {
        PagerDTO pagerDTO = goodsInfoService.listAllByCondition(goodsInfoQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsInfoVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody GoodsInfoQuery goodsInfoQuery) {
        PagerDTO pagerDTO = goodsInfoService.listPageByCondition(goodsInfoQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsInfoVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setGoodsInfoService(GoodsInfoService goodsInfoService) {
        this.goodsInfoService = goodsInfoService;
    }
}
