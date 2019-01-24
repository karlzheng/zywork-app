package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.UserOrganizationQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserOrganizationService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserOrganizationVO;

/**
 * UserOrganizationController控制器类<br/>
 *
 * 创建于2019-01-24<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/user-organization")
public class UserOrganizationController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserOrganizationController.class);

    private UserOrganizationService userOrganizationService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = userOrganizationService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserOrganizationVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userOrganizationService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserOrganizationVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserOrganizationQuery userOrganizationQuery) {
        PagerDTO pagerDTO = userOrganizationService.listPageByCondition(userOrganizationQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserOrganizationVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 用户查询组织部门
     * @param userOrganizationQuery
     * @return
     */
    @PostMapping("user/pager-cond")
    public ResponseStatusVO userListPageByCondition(@RequestBody UserOrganizationQuery userOrganizationQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        userOrganizationQuery.setUserId(jwtUser.getUserId());
        return listPageByCondition(userOrganizationQuery);
    }

    @Autowired
    public void setUserOrganizationService(UserOrganizationService userOrganizationService) {
        this.userOrganizationService = userOrganizationService;
    }
}
