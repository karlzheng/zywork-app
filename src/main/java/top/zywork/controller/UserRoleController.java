package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.exception.ServiceException;
import top.zywork.query.UserRoleQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserRoleService;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.UserRoleVO;

/**
 * UserRoleController控制器类<br/>
 *
 * 创建于2018-12-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/user-role")
public class UserRoleController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserRoleController.class);

    private UserRoleService userRoleService;

    @GetMapping("multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            PagerDTO pagerDTO = userRoleService.listById(id);
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserRoleVO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回单个对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    /**
     * 查询登录用户自己的所有角色
     * @return
     */
    @GetMapping("list")
    public ResponseStatusVO listUserRoles() {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (jwtUser == null) {
            statusVO.errorStatus(ResponseStatusEnum.AUTHENTICATION_ERROR.getCode(), ResponseStatusEnum.AUTHENTICATION_ERROR.getMessage(), null);
            return statusVO;
        } else {
            return listById(jwtUser.getUserId());
        }
    }

    @GetMapping("all")
    public ResponseStatusVO listAll() {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            PagerDTO pagerDTO = userRoleService.listAll();
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserRoleVO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回所有对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    @PostMapping("pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserRoleQuery userRoleQuery) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            PagerDTO pagerDTO = userRoleService.listPageByCondition(userRoleQuery);
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserRoleVO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回指定条件的分页对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }
}
