package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.zywork.annotation.ExposeClass;
import top.zywork.common.*;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.SchedulerDTO;
import top.zywork.enums.SchedulerJobStatusEnum;
import top.zywork.query.SchedulerQuery;
import top.zywork.service.SchedulerService;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.SchedulerVO;

import java.util.List;

/**
 * SchedulerController控制器类<br/>
 *
 * 创建于2019-01-18<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/scheduler")
public class SchedulerController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerController.class);

    private SchedulerService schedulerService;

    private SchedulerFactoryBean schedulerFactoryBean;

    /**
     * 启动定时任务
     * @param jobId
     * @param jobClassName
     * @param jobName
     * @param jobGroup
     * @param triggerName
     * @param triggerGroup
     * @param cronExp
     * @return
     */
    @PostMapping("admin/start")
    public ResponseStatusVO startJob(Long jobId, String jobClassName, String jobName, String jobGroup, String triggerName, String triggerGroup, String cronExp) {
        if (jobId == null
                || org.apache.commons.lang.StringUtils.isEmpty(jobClassName)
                || org.apache.commons.lang.StringUtils.isEmpty(jobName)
                || org.apache.commons.lang.StringUtils.isEmpty(jobGroup)
                || org.apache.commons.lang.StringUtils.isEmpty(triggerName)
                || org.apache.commons.lang.StringUtils.isEmpty(triggerGroup)
                || org.apache.commons.lang.StringUtils.isEmpty(cronExp)) {
            return ResponseStatusVO.dataError("参数错误，所有参数都是必须的", null);
        }
        SchedulerUtils.initScheduler(schedulerFactoryBean);
        if (SchedulerUtils.startJob(jobClassName, jobName, jobGroup, triggerName, triggerGroup, cronExp)) {
            schedulerService.update(getSchedulerDTO(jobId, SchedulerJobStatusEnum.RUNNING));
            return ResponseStatusVO.ok("成功启动定时任务", null);
        }
        return ResponseStatusVO.error("定时任务启动失败，请检查所有参数", null);
    }

    /**
     * 暂停定时任务
     * @param jobId
     * @param jobName
     * @param jobGroup
     * @return
     */
    @PostMapping("admin/pause")
    public ResponseStatusVO pauseJob(Long jobId, String jobName, String jobGroup) {
        if (jobId == null
                || org.apache.commons.lang.StringUtils.isEmpty(jobName)
                || org.apache.commons.lang.StringUtils.isEmpty(jobGroup)) {
            return ResponseStatusVO.dataError("参数错误，所有参数都是必须的", null);
        }
        SchedulerUtils.initScheduler(schedulerFactoryBean);
        if (SchedulerUtils.pauseJob(jobName, jobGroup)) {
            schedulerService.update(getSchedulerDTO(jobId, SchedulerJobStatusEnum.PAUSED));
            return ResponseStatusVO.ok("成功暂停定时任务", null);
        }
        return ResponseStatusVO.error("定时任务暂停失败，请检查所有参数", null);
    }

    /**
     * 恢复定时任务
     * @param jobId
     * @param jobName
     * @param jobGroup
     * @return
     */
    @PostMapping("admin/resume")
    public ResponseStatusVO resumeJob(Long jobId, String jobName, String jobGroup) {
        if (jobId == null
                || org.apache.commons.lang.StringUtils.isEmpty(jobName)
                || org.apache.commons.lang.StringUtils.isEmpty(jobGroup)) {
            return ResponseStatusVO.dataError("参数错误，所有参数都是必须的", null);
        }
        SchedulerUtils.initScheduler(schedulerFactoryBean);
        if (SchedulerUtils.resumeJob(jobName, jobGroup)) {
            schedulerService.update(getSchedulerDTO(jobId, SchedulerJobStatusEnum.RUNNING));
            return ResponseStatusVO.ok("成功恢复定时任务", null);
        }
        return ResponseStatusVO.error("定时任务恢复失败，请检查所有参数", null);
    }

    /**
     * 停止定时任务
     * @param jobId
     * @param jobName
     * @param jobGroup
     * @param triggerName
     * @param triggerGroup
     * @return
     */
    @PostMapping("admin/stop")
    public ResponseStatusVO stopJob(Long jobId, String jobName, String jobGroup, String triggerName, String triggerGroup) {
        if (jobId == null
                || org.apache.commons.lang.StringUtils.isEmpty(jobName)
                || org.apache.commons.lang.StringUtils.isEmpty(jobGroup)
                || org.apache.commons.lang.StringUtils.isEmpty(triggerName)
                || org.apache.commons.lang.StringUtils.isEmpty(triggerGroup)) {
            return ResponseStatusVO.dataError("参数错误，所有参数都是必须的", null);
        }
        SchedulerUtils.initScheduler(schedulerFactoryBean);
        if (SchedulerUtils.stopJob(jobName, jobGroup, triggerName, triggerGroup)) {
            schedulerService.update(getSchedulerDTO(jobId, SchedulerJobStatusEnum.STOPED));
            return ResponseStatusVO.ok("成功停止定时任务", null);
        }
        return ResponseStatusVO.error("定时任务停止失败，请检查所有参数", null);
    }

    /**
     * 删除定时任务
     * @param jobId
     * @param jobName
     * @param jobGroup
     * @param triggerName
     * @param triggerGroup
     * @return
     */
    @PostMapping("admin/del")
    public ResponseStatusVO delJob(Long jobId, String jobName, String jobGroup, String triggerName, String triggerGroup) {
        if (jobId == null
                || org.apache.commons.lang.StringUtils.isEmpty(jobName)
                || org.apache.commons.lang.StringUtils.isEmpty(jobGroup)
                || org.apache.commons.lang.StringUtils.isEmpty(triggerName)
                || org.apache.commons.lang.StringUtils.isEmpty(triggerGroup)) {
            return ResponseStatusVO.dataError("参数错误，所有参数都是必须的", null);
        }
        SchedulerUtils.initScheduler(schedulerFactoryBean);
        if (SchedulerUtils.deleteJob(jobName, jobGroup, triggerName, triggerGroup)) {
            schedulerService.update(getSchedulerDTO(jobId, SchedulerJobStatusEnum.DELETED));
            return ResponseStatusVO.ok("成功删除调度器中的定时任务", null);
        }
        return ResponseStatusVO.error("调度器中定时任务删除失败，请检查所有参数", null);
    }

    /**
     * 修改定时任务的cron表达式并重新调度
     * @param jobId
     * @param jobName
     * @param jobGroup
     * @param triggerName
     * @param triggerGroup
     * @param cronExp
     * @return
     */
    @PostMapping("admin/modify")
    public ResponseStatusVO modifyJob(Long jobId, String jobName, String jobGroup, String triggerName, String triggerGroup, String cronExp) {
        if (jobId == null
                || org.apache.commons.lang.StringUtils.isEmpty(jobName)
                || org.apache.commons.lang.StringUtils.isEmpty(jobGroup)
                || org.apache.commons.lang.StringUtils.isEmpty(triggerName)
                || org.apache.commons.lang.StringUtils.isEmpty(triggerGroup)
                || org.apache.commons.lang.StringUtils.isEmpty(cronExp)) {
            return ResponseStatusVO.dataError("参数错误，所有参数都是必须的", null);
        }
        SchedulerUtils.initScheduler(schedulerFactoryBean);
        if (SchedulerUtils.modifyJob(jobName, jobGroup, triggerName, triggerGroup, cronExp)) {
            SchedulerDTO schedulerDTO = getSchedulerDTO(jobId, SchedulerJobStatusEnum.RUNNING);
            schedulerDTO.setCronExpression(cronExp);
            schedulerService.update(schedulerDTO);
            return ResponseStatusVO.ok("已修改cron表达式，并重新启动定时任务", null);
        }
        return ResponseStatusVO.error("修改cron表达式失败，请检查所有参数", null);
    }

    private SchedulerDTO getSchedulerDTO(Long jobId, SchedulerJobStatusEnum schedulerJobStatusEnum) {
        SchedulerDTO schedulerDTO = new SchedulerDTO();
        schedulerDTO.setId(jobId);
        schedulerDTO.setJobStatus(schedulerJobStatusEnum.getValue().byteValue());
        schedulerDTO.setJobStatusTime(DateUtils.currentDate());
        return schedulerDTO;
    }

    /**
     * 获取所有定时任务类完整类名
     * @return
     */
    @GetMapping("admin/job-classes")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO getJobClassNames() {
        List<Object> classNames = (List) ReflectUtils.getClassNames("top.zywork.job", false, ExposeClass.class);
        PagerVO pagerVO = new PagerVO();
        pagerVO.setTotal((long) classNames.size());
        pagerVO.setRows(classNames);
        return ResponseStatusVO.ok("成功获取所有定时任务类", pagerVO);
    }

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated SchedulerVO schedulerVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        schedulerService.save(BeanUtils.copy(schedulerVO, SchedulerDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<SchedulerVO> schedulerVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        schedulerService.saveBatch(BeanUtils.copyListObj(schedulerVOList, SchedulerDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        schedulerService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        schedulerService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated SchedulerVO schedulerVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = schedulerService.update(BeanUtils.copy(schedulerVO, SchedulerDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<SchedulerVO> schedulerVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        schedulerService.updateBatch(BeanUtils.copyListObj(schedulerVOList, SchedulerDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody SchedulerVO schedulerVO) {
        schedulerService.update(BeanUtils.copy(schedulerVO, SchedulerDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<SchedulerVO> schedulerVOList) {
        schedulerService.updateBatch(BeanUtils.copyListObj(schedulerVOList, SchedulerDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        SchedulerVO schedulerVO = new SchedulerVO();
        Object obj = schedulerService.getById(id);
        if (obj != null) {
            schedulerVO = BeanUtils.copy(obj, SchedulerVO.class);
        }
        return ResponseStatusVO.ok("查询成功", schedulerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = schedulerService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), SchedulerVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody SchedulerQuery schedulerQuery) {
        PagerDTO pagerDTO = schedulerService.listAllByCondition(schedulerQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), SchedulerVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody SchedulerQuery schedulerQuery) {
        PagerDTO pagerDTO = schedulerService.listPageByCondition(schedulerQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), SchedulerVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setSchedulerService(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @Autowired
    public void setSchedulerFactoryBean(SchedulerFactoryBean schedulerFactoryBean) {
        this.schedulerFactoryBean = schedulerFactoryBean;
    }
}
