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
import top.zywork.dto.SysLogDTO;
import top.zywork.exception.ServiceException;
import top.zywork.query.SysLogQuery;
import top.zywork.service.SysLogService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.SysLogVO;

import java.util.List;

/**
 * SysLogController控制器类<br/>
 *
 * 创建于2018-12-25<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/sys-log")
public class SysLogController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SysLogController.class);

    private SysLogService sysLogService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated SysLogVO sysLogVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        try {
            sysLogService.save(BeanUtils.copy(sysLogVO, SysLogDTO.class));
            return ResponseStatusVO.ok("添加成功", null);
        } catch (ServiceException e) {
            logger.error("添加失败：{}", e.getMessage());
            return ResponseStatusVO.error("添加失败", null);
        }
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<SysLogVO> sysLogVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        try {
            sysLogService.saveBatch(BeanUtils.copyListObj(sysLogVOList, SysLogDTO.class));
            return ResponseStatusVO.ok("批量添加成功", null);
        } catch (ServiceException e) {
            logger.error("添加失败：{}", e.getMessage());
            return ResponseStatusVO.error("批量添加失败", null);
        }
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        try {
            sysLogService.removeById(id);
            return ResponseStatusVO.ok("删除成功", null);
        } catch (ServiceException e) {
            logger.error("删除失败：{}", e.getMessage());
            return ResponseStatusVO.error("删除失败", null);
        }
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        try {
            sysLogService.removeByIds(StringUtils.strArrayToLongArray(ids));
            return ResponseStatusVO.ok("批量删除成功", null);
        } catch (ServiceException e) {
            logger.error("批量删除失败：{}", e.getMessage());
            return ResponseStatusVO.error("批量删除失败", null);
        }
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated SysLogVO sysLogVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        try {
            int updateRows = sysLogService.update(BeanUtils.copy(sysLogVO, SysLogDTO.class));
            if (updateRows == 1) {
                return ResponseStatusVO.ok("更新成功", null);
            } else {
                return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
            }
        } catch (ServiceException e) {
            logger.error("更新失败：{}", e.getMessage());
            return ResponseStatusVO.error("更新失败", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<SysLogVO> sysLogVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        try {
            sysLogService.updateBatch(BeanUtils.copyListObj(sysLogVOList, SysLogDTO.class));
            return ResponseStatusVO.ok("批量更新成功", null);
        } catch (ServiceException e) {
            logger.error("批量更新失败：{}", e.getMessage());
            return ResponseStatusVO.error("批量更新失败", null);
        }

    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody SysLogVO sysLogVO) {
        try {
            sysLogService.update(BeanUtils.copy(sysLogVO, SysLogDTO.class));
            return ResponseStatusVO.ok("激活或冻结成功", null);
        } catch (ServiceException e) {
            logger.error("激活或冻结失败：{}", e.getMessage());
            return ResponseStatusVO.error("激活或冻结失败", null);
        }
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<SysLogVO> sysLogVOList) {
        try {
            sysLogService.updateBatch(BeanUtils.copyListObj(sysLogVOList, SysLogDTO.class));
            return ResponseStatusVO.ok("批量激活或冻结成功", null);
        } catch (ServiceException e) {
            logger.error("批量激活或冻结失败：{}", e.getMessage());
            return ResponseStatusVO.error("批量激活或冻结失败", null);
        }
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        SysLogVO sysLogVO = new SysLogVO();
        try {
            Object obj = sysLogService.getById(id);
            if (obj != null) {
                sysLogVO = BeanUtils.copy(obj, SysLogVO.class);
            }
            return ResponseStatusVO.ok("查询成功", sysLogVO);
        } catch (ServiceException e) {
            logger.error("返回单个对象JSON数据失败：{}", e.getMessage());
            return ResponseStatusVO.error("查询失败", null);
        }
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        try {
            PagerDTO pagerDTO = sysLogService.listAll();
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), SysLogVO.class));
            return ResponseStatusVO.ok("查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回所有对象JSON数据失败：{}", e.getMessage());
            return ResponseStatusVO.error("查询失败", null);
        }
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody SysLogQuery sysLogQuery) {
        try {
            PagerDTO pagerDTO = sysLogService.listPageByCondition(sysLogQuery);
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), SysLogVO.class));
            return ResponseStatusVO.ok("查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回指定条件的分页对象JSON数据失败：{}", e.getMessage());
            return ResponseStatusVO.error("查询失败", null);
        }
    }

    @Autowired
    public void setSysLogService(SysLogService sysLogService) {
        this.sysLogService = sysLogService;
    }
}
