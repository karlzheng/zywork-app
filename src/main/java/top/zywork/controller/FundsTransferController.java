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
import top.zywork.dto.FundsTransferDTO;
import top.zywork.query.FundsTransferQuery;
import top.zywork.service.FundsTransferService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.FundsTransferVO;

import java.util.List;

/**
 * FundsTransferController控制器类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/funds-transfer")
public class FundsTransferController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(FundsTransferController.class);

    private FundsTransferService fundsTransferService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated FundsTransferVO fundsTransferVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        fundsTransferService.save(BeanUtils.copy(fundsTransferVO, FundsTransferDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<FundsTransferVO> fundsTransferVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        fundsTransferService.saveBatch(BeanUtils.copyListObj(fundsTransferVOList, FundsTransferDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        fundsTransferService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        fundsTransferService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated FundsTransferVO fundsTransferVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = fundsTransferService.update(BeanUtils.copy(fundsTransferVO, FundsTransferDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<FundsTransferVO> fundsTransferVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        fundsTransferService.updateBatch(BeanUtils.copyListObj(fundsTransferVOList, FundsTransferDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody FundsTransferVO fundsTransferVO) {
        fundsTransferService.update(BeanUtils.copy(fundsTransferVO, FundsTransferDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<FundsTransferVO> fundsTransferVOList) {
        fundsTransferService.updateBatch(BeanUtils.copyListObj(fundsTransferVOList, FundsTransferDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        FundsTransferVO fundsTransferVO = new FundsTransferVO();
        Object obj = fundsTransferService.getById(id);
        if (obj != null) {
            fundsTransferVO = BeanUtils.copy(obj, FundsTransferVO.class);
        }
        return ResponseStatusVO.ok("查询成功", fundsTransferVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = fundsTransferService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), FundsTransferVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody FundsTransferQuery fundsTransferQuery) {
        PagerDTO pagerDTO = fundsTransferService.listAllByCondition(fundsTransferQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), FundsTransferVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody FundsTransferQuery fundsTransferQuery) {
        PagerDTO pagerDTO = fundsTransferService.listPageByCondition(fundsTransferQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), FundsTransferVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setFundsTransferService(FundsTransferService fundsTransferService) {
        this.fundsTransferService = fundsTransferService;
    }
}
