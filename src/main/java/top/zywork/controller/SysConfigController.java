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
import top.zywork.dto.SysConfigDTO;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.exception.ServiceException;
import top.zywork.query.SysConfigQuery;
import top.zywork.service.SysConfigService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.SysConfigVO;

import java.util.List;

/**
 * SysConfigController控制器类<br/>
 *
 * 创建于2018-12-20<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/sys-config")
public class SysConfigController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SysConfigController.class);

    private SysConfigService sysConfigService;

    @PostMapping("save")
    public ResponseStatusVO save(@RequestBody @Validated SysConfigVO sysConfigVO, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                sysConfigService.save(BeanUtils.copy(sysConfigVO, SysConfigDTO.class));
                statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "添加成功", null);
            } catch (ServiceException e) {
                logger.error("添加失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "添加失败", null);
            }
        }
        return statusVO;
    }

    @PostMapping("batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<SysConfigVO> sysConfigVOList, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                sysConfigService.saveBatch(BeanUtils.copyListObj(sysConfigVOList, SysConfigDTO.class));
                statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "批量添加成功", null);
            } catch (ServiceException e) {
                logger.error("添加失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "批量添加失败", null);
            }
        }
        return statusVO;
    }

    @GetMapping("remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            sysConfigService.removeById(id);
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "删除成功", null);
        } catch (ServiceException e) {
            logger.error("删除失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "删除失败", null);
        }
        return statusVO;
    }

    @PostMapping("batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            sysConfigService.removeByIds(StringUtils.strArrayToLongArray(ids));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "批量删除成功", null);
        } catch (ServiceException e) {
            logger.error("批量删除失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "批量删除失败", null);
        }
        return statusVO;
    }

    @PostMapping("update")
    public ResponseStatusVO update(@RequestBody @Validated SysConfigVO sysConfigVO, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                sysConfigService.update(BeanUtils.copy(sysConfigVO, SysConfigDTO.class));
                statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "更新成功", null);
            } catch (ServiceException e) {
                logger.error("更新失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "更新失败", null);
            }
        }
        return statusVO;
    }

    @PostMapping("batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<SysConfigVO> sysConfigVOList, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                sysConfigService.updateBatch(BeanUtils.copyListObj(sysConfigVOList, SysConfigDTO.class));
                statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "批量更新成功", null);
            } catch (ServiceException e) {
                logger.error("批量更新失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "批量更新失败", null);
            }
        }
        return statusVO;
    }

    @PostMapping("active")
    public ResponseStatusVO active(@RequestBody SysConfigVO sysConfigVO) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            sysConfigService.update(BeanUtils.copy(sysConfigVO, SysConfigDTO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "激活或冻结成功", null);
        } catch (ServiceException e) {
            logger.error("激活或冻结失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "激活或冻结失败", null);
        }
        return statusVO;
    }

    @PostMapping("batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<SysConfigVO> sysConfigVOList) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            sysConfigService.updateBatch(BeanUtils.copyListObj(sysConfigVOList, SysConfigDTO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "批量激活或冻结成功", null);
        } catch (ServiceException e) {
            logger.error("批量激活或冻结失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "批量激活或冻结失败", null);
        }
        return statusVO;
    }

    @GetMapping("one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        SysConfigVO sysConfigVO = new SysConfigVO();
        try {
            Object obj = sysConfigService.getById(id);
            if (obj != null) {
                sysConfigVO = BeanUtils.copy(obj, SysConfigVO.class);
            }
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", sysConfigVO);
        } catch (ServiceException e) {
            logger.error("返回单个对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    @GetMapping("all")
    public ResponseStatusVO listAll() {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            PagerDTO pagerDTO = sysConfigService.listAll();
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), SysConfigVO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回所有对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    @PostMapping("pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody SysConfigQuery sysConfigQuery) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            PagerDTO pagerDTO = sysConfigService.listPageByCondition(sysConfigQuery);
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), SysConfigVO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回指定条件的分页对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    @Autowired
    public void setSysConfigService(SysConfigService sysConfigService) {
        this.sysConfigService = sysConfigService;
    }
}
