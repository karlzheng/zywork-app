package top.zywork.controller;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zywork.common.ActivitiUtils;
import top.zywork.common.BeanUtils;
import top.zywork.common.ImageUtils;
import top.zywork.enums.ContentTypeEnum;
import top.zywork.enums.MIMETypeEnum;
import top.zywork.query.PageQuery;
import top.zywork.query.activiti.ActivitiDeploymentQuery;
import top.zywork.query.activiti.ActivitiProcessDefinitionQuery;
import top.zywork.query.activiti.ActivitiProcessInstanceQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.activiti.ActivitiDeploymentVO;
import top.zywork.vo.activiti.ActivitiProcessDefinitionVO;
import top.zywork.vo.activiti.ActivitiProcessInstanceVO;
import top.zywork.vo.activiti.ActivitiTaskVO;

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

    private ProcessEngine processEngine;

    /**
     * 根据流程名来部署流程
     * @param processPath
     * @param processName
     * @param processKey
     * @return
     */
    @PostMapping("admin/deploy")
    public ResponseStatusVO deploy(String processPath, String processName, String processKey) {
        Deployment deployment = ActivitiUtils.deployByPath(repositoryService, processPath, processName, processKey);
        if (deployment == null) {
            return ResponseStatusVO.dataError("流程文件路径错误", null);
        }
        return ResponseStatusVO.ok(processName + "流程已成功部署", BeanUtils.copy(deployment, ActivitiDeploymentVO.class));
    }

    /**
     * 查询所有流程部署
     * @param pageQuery
     * @return
     */
    @PostMapping("admin/all-deploy")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listDeployments(@RequestBody PageQuery pageQuery) {
        PagerVO pagerVO = ActivitiUtils.listDeployments(repositoryService, pageQuery.getBeginIndex(), pageQuery.getPageSize());
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiDeploymentVO.class));
        }
        return ResponseStatusVO.ok("所有流程部署", pagerVO);
    }

    /**
     * 查询指定流程的所有部署
     * @param activitiDeploymentQuery
     * @return
     */
    @PostMapping("admin/all-deploy-name")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listDeploymentsByName(@RequestBody ActivitiDeploymentQuery activitiDeploymentQuery) {
        PagerVO pagerVO = ActivitiUtils.listDeployments(repositoryService, activitiDeploymentQuery.getName(), activitiDeploymentQuery.getBeginIndex(), activitiDeploymentQuery.getPageSize());
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiDeploymentVO.class));
        }
        return ResponseStatusVO.ok(activitiDeploymentQuery.getName() + "的所有流程部署", pagerVO);
    }

    /**
     * 查询指定流程的最新版本部署
     * @param processKey
     * @return
     */
    @PostMapping("admin/latest-deploy")
    public ResponseStatusVO getLatestDeployments(String processKey) {
        Deployment deployment = ActivitiUtils.getLatestDeployment(repositoryService, processKey);
        return ResponseStatusVO.ok(processKey + "的最新流程部署", deployment == null ? null : BeanUtils.copy(deployment, ActivitiDeploymentVO.class));
    }

    /**
     * 根据流程名删除所有部署
     * @param processKey
     * @return
     */
    @PostMapping("admin/remove-all")
    public ResponseStatusVO removeAllDeployment(String processKey) {
        int count = ActivitiUtils.removeAllDeployment(repositoryService, processKey);
        return ResponseStatusVO.ok("删除" + processKey + "流程的" + count + "个部署", null);
    }

    /**
     * 根据流程名删除所有旧部署
     * @param processKey
     * @return
     */
    @PostMapping("admin/remove-old")
    public ResponseStatusVO removeOldDeployment(String processKey) {
        int count = ActivitiUtils.removeOldDeployment(repositoryService, processKey);
        return ResponseStatusVO.ok("删除" + processKey + "流程的" + count + "个非最新部署", null);
    }

    /**
     * 获取所有流程定义
     * @param pageQuery
     * @return
     */
    @PostMapping("admin/all-definitions")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listProcessDefinitions(@RequestBody PageQuery pageQuery) {
        PagerVO pagerVO = ActivitiUtils.listProcessDefinitions(repositoryService, pageQuery.getBeginIndex(), pageQuery.getPageSize());
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiProcessDefinitionVO.class));
        }
        return ResponseStatusVO.ok("所有流程定义", pagerVO);
    }

    /**
     * 获取指定名称的所有流程定义
     * @param activitiProcessDefinitionQuery
     * @return
     */
    @PostMapping("admin/all-definitions-name")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listProcessDefinitions(@RequestBody ActivitiProcessDefinitionQuery activitiProcessDefinitionQuery) {
        PagerVO pagerVO = ActivitiUtils.listProcessDefinitions(repositoryService, activitiProcessDefinitionQuery.getName(), activitiProcessDefinitionQuery.getBeginIndex(), activitiProcessDefinitionQuery.getPageSize());
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiProcessDefinitionVO.class));
        }
        return ResponseStatusVO.ok(activitiProcessDefinitionQuery.getName() + "的所有流程定义", pagerVO);
    }

    /**
     * 获取指定名称的最新流程定义
     * @param processKey
     * @return
     */
    @PostMapping("admin/latest-definition")
    public ResponseStatusVO getLatestProcessDefinition(String processKey) {
        ProcessDefinition processDefinition = ActivitiUtils.getLatestProcessDefinition(repositoryService, processKey);
        return ResponseStatusVO.ok(processKey + "的最新流程定义", processDefinition == null ? null : BeanUtils.copy(processDefinition, ActivitiProcessDefinitionVO.class));
    }

    /**
     * 启动流程
     * @param processKey
     * @return
     */
    @PostMapping("admin/start-one")
    public ResponseStatusVO startOneProcess(String processKey) {
        ProcessDefinition processDefinition = ActivitiUtils.getLatestProcessDefinition(repositoryService, processKey);
        if (processDefinition == null) {
            return ResponseStatusVO.dataError(processKey + "流程定义不存在", null);
        }
        ProcessInstance processInstance = ActivitiUtils.startOneProcess(runtimeService, processKey);
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
    @PostMapping("admin/start-one-var")
    public ResponseStatusVO startOneProcessVar(String processKey, Map<String, Object> variables) {
        ProcessDefinition processDefinition = ActivitiUtils.getLatestProcessDefinition(repositoryService, processKey);
        if (processDefinition == null) {
            return ResponseStatusVO.dataError(processKey + "流程定义不存在", null);
        }
        ProcessInstance processInstance = ActivitiUtils.startOneProcess(runtimeService, processKey, variables);
        if (processInstance == null) {
            return ResponseStatusVO.dataError(processKey+ "流程只能同时启动一个或流程启动失败", null);
        }
        return ResponseStatusVO.ok("成功启动流程：" + processKey, BeanUtils.copy(processInstance, ActivitiProcessInstanceVO.class));
    }

    /**
     * 启动流程
     * @param processKey
     * @return
     */
    @PostMapping("admin/start-one-user")
    public ResponseStatusVO startOneProcessByUser(String processKey) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        ProcessDefinition processDefinition = ActivitiUtils.getLatestProcessDefinition(repositoryService, processKey);
        if (processDefinition == null) {
            return ResponseStatusVO.dataError(processKey + "流程定义不存在", null);
        }
        ProcessInstance processInstance = ActivitiUtils.startOneProcess(identityService, runtimeService, jwtUser.getUserId() + "", processKey);
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
    @PostMapping("admin/start-one-var-user")
    public ResponseStatusVO startOneProcessVarByUser(String processKey, Map<String, Object> variables) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        ProcessDefinition processDefinition = ActivitiUtils.getLatestProcessDefinition(repositoryService, processKey);
        if (processDefinition == null) {
            return ResponseStatusVO.dataError(processKey + "流程定义不存在", null);
        }
        ProcessInstance processInstance = ActivitiUtils.startOneProcess(identityService, runtimeService, jwtUser.getUserId() + "", processKey, variables);
        if (processInstance == null) {
            return ResponseStatusVO.dataError(processKey+ "流程只能同时启动一个或流程启动失败", null);
        }
        return ResponseStatusVO.ok("成功启动流程：" + processKey, BeanUtils.copy(processInstance, ActivitiProcessInstanceVO.class));
    }

    /**
     * 启动流程
     * @param processKey
     * @return
     */
    @PostMapping("admin/start")
    public ResponseStatusVO startProcess(String processKey) {
        ProcessDefinition processDefinition = ActivitiUtils.getLatestProcessDefinition(repositoryService, processKey);
        if (processDefinition == null) {
            return ResponseStatusVO.dataError(processKey + "流程定义不存在", null);
        }
        ProcessInstance processInstance = ActivitiUtils.startProcess(runtimeService, processKey);
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
    @PostMapping("admin/start-var")
    public ResponseStatusVO startProcessVar(String processKey, Map<String, Object> variables) {
        ProcessDefinition processDefinition = ActivitiUtils.getLatestProcessDefinition(repositoryService, processKey);
        if (processDefinition == null) {
            return ResponseStatusVO.dataError(processKey + "流程定义不存在", null);
        }
        ProcessInstance processInstance = ActivitiUtils.startProcess(runtimeService, processKey, variables);
        if (processInstance == null) {
            return ResponseStatusVO.dataError(processKey+ "流程启动失败", null);
        }
        return ResponseStatusVO.ok("成功启动流程：" + processKey, BeanUtils.copy(processInstance, ActivitiProcessInstanceVO.class));
    }

    /**
     * 启动流程
     * @param processKey
     * @return
     */
    @PostMapping("admin/start-user")
    public ResponseStatusVO startProcessByUser(String processKey) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        ProcessDefinition processDefinition = ActivitiUtils.getLatestProcessDefinition(repositoryService, processKey);
        if (processDefinition == null) {
            return ResponseStatusVO.dataError(processKey + "流程定义不存在", null);
        }
        ProcessInstance processInstance = ActivitiUtils.startProcess(identityService, runtimeService, jwtUser.getUserId() + "", processKey);
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
    @PostMapping("admin/start-var-user")
    public ResponseStatusVO startProcessVarByUser(String processKey, Map<String, Object> variables) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        ProcessDefinition processDefinition = ActivitiUtils.getLatestProcessDefinition(repositoryService, processKey);
        if (processDefinition == null) {
            return ResponseStatusVO.dataError(processKey + "流程定义不存在", null);
        }
        ProcessInstance processInstance = ActivitiUtils.startProcess(identityService, runtimeService, jwtUser.getUserId() + "", processKey, variables);
        if (processInstance == null) {
            return ResponseStatusVO.dataError(processKey+ "流程启动失败", null);
        }
        return ResponseStatusVO.ok("成功启动流程：" + processKey, BeanUtils.copy(processInstance, ActivitiProcessInstanceVO.class));
    }

    /**
     * 列出指定流程的所有流程实例
     * @param pageQuery
     * @return
     */
    @PostMapping("admin/all-process-instance")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listProcessInstance(@RequestBody PageQuery pageQuery) {
        PagerVO pagerVO = ActivitiUtils.listProcessInstances(runtimeService, pageQuery.getBeginIndex(), pageQuery.getPageSize());
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiProcessInstanceVO.class));
        }
        return ResponseStatusVO.ok("所有流程实例", pagerVO);
    }

    /**
     * 列出指定流程的所有流程实例
     * @param activitiProcessInstanceQuery
     * @return
     */
    @PostMapping("admin/process-instance-by-name")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listProcessInstance(@RequestBody ActivitiProcessInstanceQuery activitiProcessInstanceQuery) {
        PagerVO pagerVO = ActivitiUtils.listProcessInstances(runtimeService, activitiProcessInstanceQuery.getProcessDefinitionKey(),  activitiProcessInstanceQuery.getBeginIndex(), activitiProcessInstanceQuery.getPageSize());
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiProcessInstanceVO.class));
        }
        return ResponseStatusVO.ok(activitiProcessInstanceQuery.getProcessDefinitionKey() + "的所有流程实例", pagerVO);
    }

    /**
     * 列出指定用户的指定流程的所有流程实例
     * @param pageQuery
     * @return
     */
    @PostMapping("admin/process-instance-user")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listProcessInstanceUser(@RequestBody PageQuery pageQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        PagerVO pagerVO = ActivitiUtils.listUserProcessInstances(runtimeService, jwtUser.getUserId() + "", pageQuery.getBeginIndex(), pageQuery.getPageSize());
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiProcessInstanceVO.class));
        }
        return ResponseStatusVO.ok("所有流程实例", pagerVO);
    }

    /**
     * 列出指定用户的指定流程的所有流程实例
     * @param activitiProcessInstanceQuery
     * @return
     */
    @PostMapping("admin/process-instance-name-user")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listProcessInstanceUser(@RequestBody ActivitiProcessInstanceQuery activitiProcessInstanceQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        PagerVO pagerVO = ActivitiUtils.listUserProcessInstances(runtimeService, jwtUser.getUserId() + "", activitiProcessInstanceQuery.getProcessDefinitionKey(),  activitiProcessInstanceQuery.getBeginIndex(), activitiProcessInstanceQuery.getPageSize());
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiProcessInstanceVO.class));
        }
        return ResponseStatusVO.ok(activitiProcessInstanceQuery.getProcessDefinitionKey() + "的所有流程实例", pagerVO);
    }

    /**
     * 所有待办任务
     * @param pageQuery
     * @return
     */
    @PostMapping("admin/tasks")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listTasks(@RequestBody PageQuery pageQuery) {
        PagerVO pagerVO = ActivitiUtils.listTasks(taskService, pageQuery.getBeginIndex(), pageQuery.getPageSize());
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiTaskVO.class));
        }
        return ResponseStatusVO.ok("所有待办任务", pagerVO);
    }

    /**
     * 指派人任务
     * @param pageQuery
     * @return
     */
    @PostMapping("admin/assignee-tasks")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listAssigneeTasks(@RequestBody PageQuery pageQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        PagerVO pagerVO = ActivitiUtils.listAssigneeTasks(taskService, jwtUser.getUserId() + "", pageQuery.getBeginIndex(), pageQuery.getPageSize());
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiTaskVO.class));
        }
        return ResponseStatusVO.ok("所有待办任务", pagerVO);
    }

    /**
     * 候选人任务
     * @param pageQuery
     * @return
     */
    @PostMapping("admin/candidate-tasks")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listCandidateUserTasks(@RequestBody PageQuery pageQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        PagerVO pagerVO = ActivitiUtils.listCandidateUserTasks(taskService, jwtUser.getUserId() + "", pageQuery.getBeginIndex(), pageQuery.getPageSize());
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiTaskVO.class));
        }
        return ResponseStatusVO.ok("所有待办任务", pagerVO);
    }

    /**
     * 候选组任务
     * @param pageQuery
     * @return
     */
    @PostMapping("admin/group-tasks")
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO listCandidateGroupTasks(@RequestBody PageQuery pageQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        Collection<SimpleGrantedAuthority> authorityCollection = jwtUser.getAuthorities();
        List<String> roles = new ArrayList<>();
        for (SimpleGrantedAuthority simpleGrantedAuthority : authorityCollection) {
            roles.add(simpleGrantedAuthority.getAuthority());
        }
        PagerVO pagerVO = ActivitiUtils.listCandidateGroupTasks(taskService, roles, pageQuery.getBeginIndex(), pageQuery.getPageSize());
        if (pagerVO.getRows() != null) {
            pagerVO.setRows((List) BeanUtils.copy(pagerVO.getRows(), ActivitiTaskVO.class));
        }
        return ResponseStatusVO.ok("所有待办任务", pagerVO);
    }

    /**
     * 获取任务参数
     * @param taskId
     * @return
     */
    @PostMapping("admin/task-vars")
    public ResponseStatusVO taskData(String taskId) {
        return ResponseStatusVO.ok("任务参数", taskService.getVariables(taskId));
    }

    /**
     * 完成任务
     * @param taskId
     * @return
     */
    @PostMapping("admin/complete")
    public ResponseStatusVO completeTask(String taskId) {
        ActivitiUtils.executeTask(taskService, taskId);
        return ResponseStatusVO.ok("完成任务", null);
    }

    /**
     * 完成任务
     * @param taskId
     * @param variables
     * @return
     */
    @PostMapping("admin/complete-vars")
    public ResponseStatusVO completeTask(String taskId, Map<String, Object> variables) {
        ActivitiUtils.executeTask(taskService, taskId, variables);
        return ResponseStatusVO.ok("完成任务", null);
    }

    /**
     * 获取流程静态图
     * @param response
     * @param processKey
     * @return
     */
    @PostMapping("bpmn-png")
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
     * 生成动态流程图
     * @param response
     * @param processInstanceId
     * @param processKey
     * @return
     */
    @PostMapping("bpmn-activity-png")
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
    public void setProcessEngine(ProcessEngine processEngine) {
        this.processEngine = processEngine;
    }
}
