package top.zywork.controller;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.*;
import top.zywork.dto.ProcessDTO;
import top.zywork.enums.ContentTypeEnum;
import top.zywork.enums.MIMETypeEnum;
import top.zywork.query.PageQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.ProcessService;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.activiti.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * ProcessActivitiController控制器类<br/>
 *
 * 创建于2019-02-13<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/process-activiti")
public class ProcessActivitiController {

    private static final Logger logger = LoggerFactory.getLogger(ProcessActivitiController.class);

    private RepositoryService repositoryService;

    private RuntimeService runtimeService;

    private IdentityService identityService;

    private TaskService taskService;

    private HistoryService historyService;

    private ProcessEngine processEngine;

    private ProcessService processService;

    /**
     * 根据流程路径部署流程
     * @param id
     * @param processPath
     * @param processName
     * @param processKey
     * @return
     */
    @PostMapping("admin/do/deploy")
    public ResponseStatusVO deploy(Long id, String processPath, String processName, String processKey) {
        Deployment deployment = ActivitiUtils.deployByPath(repositoryService, processPath, processName, processKey);
        if (deployment == null) {
            return ResponseStatusVO.dataError("流程文件路径错误", null);
        }
        ProcessDTO processDTO = new ProcessDTO();
        processDTO.setId(id);
        processDTO.setIsDeploy((byte) 1);
        processDTO.setDeployTime(DateUtils.currentDate());
        processService.update(processDTO);
        return ResponseStatusVO.ok(processName + "流程已成功部署", BeanUtils.copy(deployment, ActivitiDeploymentVO.class));
    }

    /**
     * 查询所有流程部署
     * @param processName
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("admin/query/all-deployment")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listDeploymentsByName(@RequestParam(value = "processName", required = false) String processName, Integer pageNo, Integer pageSize) {
        PageQuery pageQuery = PageQueryUtils.getPageQuery(pageNo, pageSize);
        PagerVO pagerVO;
        if (StringUtils.isEmpty(processName)) {
            pagerVO = ActivitiUtils.listDeployments(repositoryService, pageQuery.getBeginIndex(), pageQuery.getPageSize());
        } else {
            pagerVO = ActivitiUtils.listDeployments(repositoryService, processName, pageQuery.getBeginIndex(), pageQuery.getPageSize());
        }
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiDeploymentVO.class));
        }
        return ResponseStatusVO.ok(processName + "的所有流程部署", pagerVO);
    }

    /**
     * 查询指定流程的最新版本部署
     * @param processKey
     * @return
     */
    @PostMapping("admin/query/latest-deployment")
    public ResponseStatusVO getLatestDeployments(String processKey) {
        Deployment deployment = ActivitiUtils.getLatestDeployment(repositoryService, processKey);
        return ResponseStatusVO.ok(processKey + "的最新流程部署", deployment == null ? null : BeanUtils.copy(deployment, ActivitiDeploymentVO.class));
    }

    /**
     * 根据流程名删除所有部署
     * @param processKey
     * @return
     */
    @PostMapping("admin/do/remove-all-deployment")
    public ResponseStatusVO removeAllDeployment(String processKey) {
        int count = ActivitiUtils.removeAllDeployment(repositoryService, processKey);
        return ResponseStatusVO.ok("删除" + processKey + "流程的" + count + "个部署", null);
    }

    /**
     * 根据流程名删除所有旧部署
     * @param processKey
     * @return
     */
    @PostMapping("admin/do/remove-old-deployment")
    public ResponseStatusVO removeOldDeployment(String processKey) {
        int count = ActivitiUtils.removeOldDeployment(repositoryService, processKey);
        return ResponseStatusVO.ok("删除" + processKey + "流程的" + count + "个非最新部署", null);
    }

    /**
     * 获取所有流程定义
     * @param processName
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("admin/query/all-definitions")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listProcessDefinitions(@RequestParam(value = "processName", required = false) String processName, Integer pageNo, Integer pageSize) {
        PageQuery pageQuery = PageQueryUtils.getPageQuery(pageNo, pageSize);
        PagerVO pagerVO;
        if (StringUtils.isEmpty(processName)) {
            pagerVO = ActivitiUtils.listProcessDefinitions(repositoryService, pageQuery.getBeginIndex(), pageQuery.getPageSize());
        } else {
            pagerVO = ActivitiUtils.listProcessDefinitions(repositoryService, processName, pageQuery.getBeginIndex(), pageQuery.getPageSize());
        }
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiProcessDefinitionVO.class));
        }
        return ResponseStatusVO.ok(processName + "的所有流程定义", pagerVO);
    }

    /**
     * 获取指定名称的最新流程定义
     * @param processKey
     * @return
     */
    @PostMapping("admin/query/latest-definition")
    public ResponseStatusVO getLatestProcessDefinition(String processKey) {
        ProcessDefinition processDefinition = ActivitiUtils.getLatestProcessDefinition(repositoryService, processKey);
        return ResponseStatusVO.ok(processKey + "的最新流程定义", processDefinition == null ? null : BeanUtils.copy(processDefinition, ActivitiProcessDefinitionVO.class));
    }

    /**
     * 启动一个流程
     * @param processKey
     * @param variables
     * @return
     */
    @PostMapping("admin/do/start-one/{processKey}")
    public ResponseStatusVO startOneProcess(@PathVariable("processKey") String processKey, @RequestBody(required = false) Map<String, Object> variables) {
        ProcessDefinition processDefinition = ActivitiUtils.getLatestProcessDefinition(repositoryService, processKey);
        if (processDefinition == null) {
            return ResponseStatusVO.dataError(processKey + "流程定义不存在", null);
        }
        ProcessInstance processInstance;
        if (variables == null) {
            processInstance = ActivitiUtils.startOneProcess(runtimeService, processKey);
        } else {
            processInstance = ActivitiUtils.startOneProcess(runtimeService, processKey, variables);
        }
        if (processInstance == null) {
            return ResponseStatusVO.dataError(processKey+ "流程只能同时启动一个或流程启动失败", null);
        }
        return ResponseStatusVO.ok("成功启动流程：" + processKey, BeanUtils.copy(processInstance, ActivitiProcessInstanceVO.class));
    }

    /**
     * 启动一个流程
     * @param processKey
     * @param variables
     * @return
     */
    @PostMapping("admin/do/start-one-user/{processKey}")
    public ResponseStatusVO startOneProcessByUser(@PathVariable("processKey") String processKey, @RequestBody(required = false) Map<String, Object> variables) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        ProcessDefinition processDefinition = ActivitiUtils.getLatestProcessDefinition(repositoryService, processKey);
        if (processDefinition == null) {
            return ResponseStatusVO.dataError(processKey + "流程定义不存在", null);
        }
        ProcessInstance processInstance;
        if (variables == null) {
            processInstance = ActivitiUtils.startOneProcess(identityService, runtimeService, jwtUser.getUserId() + "", processKey);
        } else {
            processInstance = ActivitiUtils.startOneProcess(identityService, runtimeService, jwtUser.getUserId() + "", processKey, variables);
        }
        if (processInstance == null) {
            return ResponseStatusVO.dataError(processKey+ "流程只能同时启动一个或流程启动失败", null);
        }
        return ResponseStatusVO.ok("成功启动流程：" + processKey, BeanUtils.copy(processInstance, ActivitiProcessInstanceVO.class));
    }

    /**
     * 启动流程
     * @param processKey
     * @param variables
     * @return
     */
    @PostMapping("admin/do/start/{processKey}")
    public ResponseStatusVO startProcess(@PathVariable("processKey") String processKey, @RequestBody(required = false) Map<String, Object> variables) {
        ProcessDefinition processDefinition = ActivitiUtils.getLatestProcessDefinition(repositoryService, processKey);
        if (processDefinition == null) {
            return ResponseStatusVO.dataError(processKey + "流程定义不存在", null);
        }
        ProcessInstance processInstance;
        if (variables == null) {
            processInstance = ActivitiUtils.startProcess(runtimeService, processKey);
        } else {
            processInstance = ActivitiUtils.startProcess(runtimeService, processKey, variables);
        }
        if (processInstance == null) {
            return ResponseStatusVO.dataError(processKey+ "流程启动失败", null);
        }
        return ResponseStatusVO.ok("成功启动流程：" + processKey, BeanUtils.copy(processInstance, ActivitiProcessInstanceVO.class));
    }

    /**
     * 启动流程
     * @param processKey
     * @param variables
     * @return
     */
    @PostMapping("admin/do/start-user/{processKey}")
    public ResponseStatusVO startProcessByUser(@PathVariable("processKey") String processKey, @RequestBody(required = false) Map<String, Object> variables) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        ProcessDefinition processDefinition = ActivitiUtils.getLatestProcessDefinition(repositoryService, processKey);
        if (processDefinition == null) {
            return ResponseStatusVO.dataError(processKey + "流程定义不存在", null);
        }
        ProcessInstance processInstance;
        if (variables == null) {
            processInstance = ActivitiUtils.startProcess(identityService, runtimeService, jwtUser.getUserId() + "", processKey);
        } else {
            processInstance = ActivitiUtils.startProcess(identityService, runtimeService, jwtUser.getUserId() + "", processKey, variables);
        }
        if (processInstance == null) {
            return ResponseStatusVO.dataError(processKey+ "流程启动失败", null);
        }
        return ResponseStatusVO.ok("成功启动流程：" + processKey, BeanUtils.copy(processInstance, ActivitiProcessInstanceVO.class));
    }

    /**
     * 启动流程
     * @param processKey
     * @param variables
     * @return
     */
    @PostMapping("user/do/start-user/{processKey}")
    public ResponseStatusVO userStartProcessByUser(@PathVariable("processKey") String processKey, @RequestBody(required = false) Map<String, Object> variables) {
        return startProcessByUser(processKey, variables);
    }

    /**
     * 列出指定流程的所有流程实例
     * @param processKey
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("admin/query/all-process-instance")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listProcessInstance(@RequestParam(value = "processKey", required = false) String processKey, Integer pageNo, Integer pageSize) {
        PageQuery pageQuery = PageQueryUtils.getPageQuery(pageNo, pageSize);
        PagerVO pagerVO;
        if (StringUtils.isEmpty(processKey)) {
            pagerVO = ActivitiUtils.listProcessInstances(runtimeService, pageQuery.getBeginIndex(), pageQuery.getPageSize());
        } else {
            pagerVO = ActivitiUtils.listProcessInstances(runtimeService, processKey, pageQuery.getBeginIndex(), pageQuery.getPageSize());
        }
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiProcessInstanceVO.class));
        }
        return ResponseStatusVO.ok(processKey + "的所有流程实例", pagerVO);
    }

    /**
     * 列出指定用户的所有流程实例
     * @param processKey
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("admin/query/process-instance-user")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listUserProcessInstance(@RequestParam(value = "processKey", required = false) String processKey, Integer pageNo, Integer pageSize) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        PageQuery pageQuery = PageQueryUtils.getPageQuery(pageNo, pageSize);
        PagerVO pagerVO;
        if (StringUtils.isEmpty(processKey)) {
            pagerVO = ActivitiUtils.listUserProcessInstances(runtimeService, jwtUser.getUserId() + "", pageQuery.getBeginIndex(), pageQuery.getPageSize());
        } else {
            pagerVO = ActivitiUtils.listUserProcessInstances(runtimeService, jwtUser.getUserId() + "", processKey, pageQuery.getBeginIndex(), pageQuery.getPageSize());
        }
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiProcessInstanceVO.class));
        }
        return ResponseStatusVO.ok(processKey + "的所有流程实例", pagerVO);
    }

    /**
     * 列出指定用户的指定流程的所有流程实例
     * @param processKey
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("user/query/process-instance-user")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO userListUserProcessInstance(@RequestParam(value = "processKey", required = false) String processKey, Integer pageNo, Integer pageSize) {
        return listUserProcessInstance(processKey, pageNo, pageSize);
    }

    /**
     * 所有待办任务
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("admin/query/all-tasks")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listTasks(Integer pageNo, Integer pageSize) {
        PageQuery pageQuery = PageQueryUtils.getPageQuery(pageNo, pageSize);
        PagerVO pagerVO = ActivitiUtils.listTasks(taskService, pageQuery.getBeginIndex(), pageQuery.getPageSize());
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiTaskVO.class));
        }
        return ResponseStatusVO.ok("所有待办任务", pagerVO);
    }

    /**
     * 指派人任务
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("admin/query/assignee-tasks")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listAssigneeTasks(Integer pageNo, Integer pageSize) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        PageQuery pageQuery = PageQueryUtils.getPageQuery(pageNo, pageSize);
        PagerVO pagerVO = ActivitiUtils.listAssigneeTasks(taskService, jwtUser.getUserId() + "", pageQuery.getBeginIndex(), pageQuery.getPageSize());
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiTaskVO.class));
        }
        return ResponseStatusVO.ok("所有待办任务", pagerVO);
    }

    /**
     * 指派人任务
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("user/query/assignee-tasks")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO userListAssigneeTasks(Integer pageNo, Integer pageSize) {
        return listAssigneeTasks(pageNo, pageSize);
    }

    /**
     * 候选人任务
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("admin/query/candidate-tasks")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listCandidateUserTasks(Integer pageNo, Integer pageSize) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        PageQuery pageQuery = PageQueryUtils.getPageQuery(pageNo, pageSize);
        PagerVO pagerVO = ActivitiUtils.listCandidateUserTasks(taskService, jwtUser.getUserId() + "", pageQuery.getBeginIndex(), pageQuery.getPageSize());
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiTaskVO.class));
        }
        return ResponseStatusVO.ok("所有待办任务", pagerVO);
    }

    /**
     * 候选人任务
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("user/query/candidate-tasks")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO userListCandidateUserTasks(Integer pageNo, Integer pageSize) {
        return listCandidateGroupTasks(pageNo, pageSize);
    }

    /**
     * 候选组任务
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("admin/query/group-tasks")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listCandidateGroupTasks(Integer pageNo, Integer pageSize) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        Collection<SimpleGrantedAuthority> authorityCollection = jwtUser.getAuthorities();
        List<String> roles = new ArrayList<>();
        for (SimpleGrantedAuthority simpleGrantedAuthority : authorityCollection) {
            roles.add(simpleGrantedAuthority.getAuthority());
        }
        PageQuery pageQuery = PageQueryUtils.getPageQuery(pageNo, pageSize);
        PagerVO pagerVO = ActivitiUtils.listCandidateGroupTasks(taskService, roles, pageQuery.getBeginIndex(), pageQuery.getPageSize());
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiTaskVO.class));
        }
        return ResponseStatusVO.ok("所有待办任务", pagerVO);
    }

    /**
     * 候选组任务
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("user/query/group-tasks")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO userListCandidateGroupTasks(Integer pageNo, Integer pageSize) {
        return listCandidateGroupTasks(pageNo, pageSize);
    }

    /**
     * 获取任务参数
     * @param taskId
     * @return
     */
    @PostMapping("admin/query/task-vars")
    public ResponseStatusVO taskData(String taskId) {
        return ResponseStatusVO.ok("任务参数", taskService.getVariables(taskId));
    }

    /**
     * 获取任务参数
     * @param taskId
     * @return
     */
    @PostMapping("user/query/task-vars")
    public ResponseStatusVO userTaskData(String taskId) {
        return taskData(taskId);
    }

    /**
     * 完成任务
     * @param taskId
     * @return
     */
    @PostMapping("admin/do/complete-task")
    public ResponseStatusVO completeTask(String taskId) {
        ActivitiUtils.executeTask(taskService, taskId);
        return ResponseStatusVO.ok("完成任务", null);
    }

    /**
     * 完成任务
     * @param taskId
     * @return
     */
    @PostMapping("user/do/complete-task")
    public ResponseStatusVO userCompleteTask(String taskId) {
        return completeTask(taskId);
    }

    /**
     * 完成任务
     * @param taskId
     * @param variables
     * @return
     */
    @PostMapping("admin/do/complete-task-vars")
    public ResponseStatusVO completeTask(String taskId, Map<String, Object> variables) {
        ActivitiUtils.executeTask(taskService, taskId, variables);
        return ResponseStatusVO.ok("完成任务", null);
    }
    /**
     * 完成任务
     * @param taskId
     * @param variables
     * @return
     */
    @PostMapping("user/do/complete-task-vars")
    public ResponseStatusVO userCompleteTask(String taskId, Map<String, Object> variables) {
        return completeTask(taskId, variables);
    }

    /**
     * 列出指定流程的历史流程实例
     * @param processKey
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("admin/query/all-his-process-instance")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listHistoricProcessInstances(@RequestParam(value = "processKey", required = false) String processKey, Integer pageNo, Integer pageSize) {
        PageQuery pageQuery = PageQueryUtils.getPageQuery(pageNo, pageSize);
        PagerVO pagerVO;
        if (StringUtils.isEmpty(processKey)) {
            pagerVO = ActivitiUtils.listHistoricProcessInstances(historyService, pageQuery.getBeginIndex(), pageQuery.getPageSize());
        } else {
            pagerVO = ActivitiUtils.listHistoricProcessInstances(historyService, processKey, pageQuery.getBeginIndex(), pageQuery.getPageSize());
        }
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiHistoricProcessInstanceVO.class));
        }
        return ResponseStatusVO.ok(processKey + "的所有历史流程", pagerVO);
    }

    /**
     * 列出指定用户的指定流程的所有历史流程实例
     * @param processKey
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("admin/query/all-his-process-instance-user")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listUserHistoricProcessInstances(@RequestParam(value = "processKey", required = false) String processKey, Integer pageNo, Integer pageSize) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        PageQuery pageQuery = PageQueryUtils.getPageQuery(pageNo, pageSize);
        PagerVO pagerVO;
        if (StringUtils.isEmpty(processKey)) {
            pagerVO = ActivitiUtils.listUserHistoricProcessInstances(historyService, jwtUser.getUserId() + "", pageQuery.getBeginIndex(), pageQuery.getPageSize());
        } else {
            pagerVO = ActivitiUtils.listUserHistoricProcessInstances(historyService, processKey, jwtUser.getUserId() + "", pageQuery.getBeginIndex(), pageQuery.getPageSize());
        }
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiHistoricProcessInstanceVO.class));
        }
        return ResponseStatusVO.ok(processKey + "的所有历史流程", pagerVO);
    }

    /**
     * 列出指定用户的指定流程的所有历史流程实例
     * @param processKey
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("user/query/all-his-process-instance-user")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO userListUserHistoricProcessInstances(@RequestParam(value = "processKey", required = false) String processKey, Integer pageNo, Integer pageSize) {
        return listUserHistoricProcessInstances(processKey, pageNo, pageSize);
    }

    /**
     * 获取流程静态图
     * @param response
     * @param processKey
     * @return
     */
    @PostMapping("admin/query/bpmn-png")
    public ResponseStatusVO bpmnPng(HttpServletResponse response, String processKey) {
        InputStream inputStream = ActivitiUtils.getDiagramPNG(repositoryService, processKey);
        if (inputStream == null) {
            return ResponseStatusVO.dataError(processKey + "流程图片不存在", null);
        }
        response.setContentType(ContentTypeEnum.PNG.getValue());
        try {
            OutputStream outputStream = response.getOutputStream();
            ImageIO.write(ImageIO.read(inputStream), MIMETypeEnum.PNG.getValue(), outputStream);
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            logger.error("get bpmn png error： {}", e.getMessage());
        }
        return null;
    }

    /**
     * 获取流程静态图
     * @param response
     * @param processKey
     * @return
     */
    @PostMapping("user/query/bpmn-png")
    public ResponseStatusVO userBpmnPng(HttpServletResponse response, String processKey) {
        return bpmnPng(response, processKey);
    }

    /**
     * 生成动态流程图
     * @param response
     * @param processInstanceId
     * @param processKey
     * @return
     */
    @PostMapping("admin/query/bpmn-activity-png")
    public ResponseStatusVO bpmnActivityPng(HttpServletResponse response, String processInstanceId, String processKey) {
        InputStream inputStream = ActivitiUtils.generateDiagramPNG(processEngine, runtimeService, repositoryService, processInstanceId, processKey);
        if (inputStream == null) {
            return ResponseStatusVO.dataError(processKey + "流程节点图片未能生成，流程实例id或processKey错误", null);
        }
        BufferedImage bufferedImage = ImageUtils.getBufferedImage(inputStream);
        response.setContentType(ContentTypeEnum.PNG.getValue());
        if (bufferedImage != null) {
            try {
                OutputStream outputStream = response.getOutputStream();
                ImageIO.write(bufferedImage, MIMETypeEnum.PNG.getValue(), outputStream);
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                logger.error("get bpmn activity png error： {}", e.getMessage());
            }
        }
        return null;
    }

    /**
     * 生成动态流程图
     * @param response
     * @param processInstanceId
     * @param processKey
     * @return
     */
    @PostMapping("user/query/bpmn-activity-png")
    public ResponseStatusVO userBpmnActivityPng(HttpServletResponse response, String processInstanceId, String processKey) {
        return bpmnActivityPng(response, processInstanceId, processKey);
    }

    @Autowired
    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @Autowired
    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @Autowired
    public void setIdentityService(IdentityService identityService) {
        this.identityService = identityService;
    }

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @Autowired
    public void setHistoryService(HistoryService historyService) {
        this.historyService = historyService;
    }

    @Autowired
    public void setProcessEngine(ProcessEngine processEngine) {
        this.processEngine = processEngine;
    }

    @Autowired
    public void setProcessService(ProcessService processService) {
        this.processService = processService;
    }
}
