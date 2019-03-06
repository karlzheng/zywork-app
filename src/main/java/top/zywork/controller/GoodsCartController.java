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
import top.zywork.dto.GoodsCartDTO;
import top.zywork.query.GoodsCartQuery;
import top.zywork.service.GoodsCartService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.GoodsCartVO;

import java.util.List;

/**
 * GoodsCartController控制器类<br/>
 *
 * 创建于2019-03-06<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/goods-cart")
public class GoodsCartController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsCartController.class);

    private GoodsCartService goodsCartService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated GoodsCartVO goodsCartVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsCartService.save(BeanUtils.copy(goodsCartVO, GoodsCartDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<GoodsCartVO> goodsCartVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsCartService.saveBatch(BeanUtils.copyListObj(goodsCartVOList, GoodsCartDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        goodsCartService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        goodsCartService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated GoodsCartVO goodsCartVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = goodsCartService.update(BeanUtils.copy(goodsCartVO, GoodsCartDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<GoodsCartVO> goodsCartVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsCartService.updateBatch(BeanUtils.copyListObj(goodsCartVOList, GoodsCartDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody GoodsCartVO goodsCartVO) {
        goodsCartService.update(BeanUtils.copy(goodsCartVO, GoodsCartDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<GoodsCartVO> goodsCartVOList) {
        goodsCartService.updateBatch(BeanUtils.copyListObj(goodsCartVOList, GoodsCartDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        GoodsCartVO goodsCartVO = new GoodsCartVO();
        Object obj = goodsCartService.getById(id);
        if (obj != null) {
            goodsCartVO = BeanUtils.copy(obj, GoodsCartVO.class);
        }
        return ResponseStatusVO.ok("查询成功", goodsCartVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = goodsCartService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsCartVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody GoodsCartQuery goodsCartQuery) {
        PagerDTO pagerDTO = goodsCartService.listAllByCondition(goodsCartQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsCartVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody GoodsCartQuery goodsCartQuery) {
        PagerDTO pagerDTO = goodsCartService.listPageByCondition(goodsCartQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsCartVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setGoodsCartService(GoodsCartService goodsCartService) {
        this.goodsCartService = goodsCartService;
    }
}
