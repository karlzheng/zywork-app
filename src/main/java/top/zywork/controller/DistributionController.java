package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zywork.common.BeanUtils;
import top.zywork.common.PageQueryUtils;
import top.zywork.dos.DefaultDistributionConfig;
import top.zywork.dto.PagerDTO;
import top.zywork.enums.SysConfigEnum;
import top.zywork.query.DistributionUserHierarchyQuery;
import top.zywork.query.DistributionUserQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.DistributionService;
import top.zywork.service.SysConfigService;
import top.zywork.vo.*;

import java.util.List;

/**
 * 分销数据查询控制器<br/>
 *
 * 创建于2018-12-28<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/distribution")
public class DistributionController {

    private static final Logger logger = LoggerFactory.getLogger(DistributionController.class);

    private DistributionService distributionService;

    private SysConfigService sysConfigService;

    /**
     * 查询顶级分销商
     *
     * @return
     */
    @PostMapping("admin/all-top")
    public ResponseStatusVO listAllTop(@RequestBody DistributionUserQuery distributionUserQuery) {
        PagerDTO pagerDTO = distributionService.listAllTop(distributionUserQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), DistributionUserVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 分页查询指定用户上面的几级经销商
     *
     * @param levels
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("user/above")
    public ResponseStatusVO listAboveUsers(Long[] levels, Integer pageNo, Integer pageSize) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        return listAboveUsers(jwtUser.getUserId(), levels, pageNo, pageSize);
    }

    /**
     * 分页查询指定用户上面的几级经销商
     *
     * @param userId
     * @param levels
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("admin/above")
    public ResponseStatusVO listAboveUsers(Long userId, Long[] levels, Integer pageNo, Integer pageSize) {
        DefaultDistributionConfig defaultDistributionConfig = sysConfigService.getByName(SysConfigEnum.DEFAULT_DISTRIBUTION_CONFIG.getValue(), DefaultDistributionConfig.class);
        PagerDTO pagerDTO = distributionService.listAboveUsers(userId, defaultDistributionConfig.getDistributionLevel(), levels, PageQueryUtils.getPageQuery(pageNo, pageSize));
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), DistributionUserVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 分页查询指定用户的直接上级经销商
     *
     * @param userId
     * @return
     */
    @PostMapping("admin/direct-above")
    public ResponseStatusVO listDirectAboveUsers(Long userId) {
        DefaultDistributionConfig defaultDistributionConfig = sysConfigService.getByName(SysConfigEnum.DEFAULT_DISTRIBUTION_CONFIG.getValue(), DefaultDistributionConfig.class);
        PagerDTO pagerDTO = distributionService.allDirectAboveUsers(userId, defaultDistributionConfig.getDistributionLevel(), (long) (defaultDistributionConfig.getDistributionLevel() - 1));
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), DistributionUserVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 分页查询指定用户的直接上级经销商
     *
     * @return
     */
    @PostMapping("user/direct-above")
    public ResponseStatusVO userListDirectAboveUsers() {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        return listDirectAboveUsers(jwtUser.getUserId());
    }

    /**
     * 分页查询指定用户下面的几级经销商
     *
     * @param levels
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("user/below")
    public ResponseStatusVO listBelowUsers(Long[] levels, Integer pageNo, Integer pageSize) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        return listBelowUsers(jwtUser.getUserId(), levels, pageNo, pageSize);
    }

    /**
     * 分页查询指定用户下面的几级经销商
     *
     * @param userId
     * @param levels
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("admin/below")
    public ResponseStatusVO listBelowUsers(Long userId, Long[] levels, Integer pageNo, Integer pageSize) {
        DefaultDistributionConfig defaultDistributionConfig = sysConfigService.getByName(SysConfigEnum.DEFAULT_DISTRIBUTION_CONFIG.getValue(), DefaultDistributionConfig.class);
        PagerDTO pagerDTO = distributionService.listBelowUsers(userId, defaultDistributionConfig.getDistributionLevel(), levels, PageQueryUtils.getPageQuery(pageNo, pageSize));
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), DistributionUserVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 分页查询指定用户的直接下级经销商
     *
     * @param userId
     * @return
     */
    @PostMapping("admin/direct-below")
    public ResponseStatusVO listDirectBelowUsers(Long userId) {
        DefaultDistributionConfig defaultDistributionConfig = sysConfigService.getByName(SysConfigEnum.DEFAULT_DISTRIBUTION_CONFIG.getValue(), DefaultDistributionConfig.class);
        PagerDTO pagerDTO = distributionService.allDirectBelowUsers(userId, defaultDistributionConfig.getDistributionLevel(), 2L);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), DistributionUserVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 分页查询指定用户的直接下级经销商
     *
     * @return
     */
    @PostMapping("user/direct-below")
    public ResponseStatusVO userListDirectBelowUsers() {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        return listDirectBelowUsers(jwtUser.getUserId());
    }

    /**
     * 获取用户路径
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("user/user-path")
    public ResponseStatusVO listUserPaths(Integer pageNo, Integer pageSize) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        return listUserPaths(jwtUser.getUserId(), pageNo, pageSize);
    }

    /**
     * 获取用户路径
     *
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("admin/user-path")
    public ResponseStatusVO listUserPaths(Long userId, Integer pageNo, Integer pageSize) {
        PagerDTO pagerDTO = distributionService.listUserPathsByUserId(userId, PageQueryUtils.getPageQuery(pageNo, pageSize));
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), DistributionUserPathVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 查询用户层级关系
     *
     * @return
     */
    @PostMapping("admin/user-hierarchy")
    public ResponseStatusVO listUserHierarchy(@RequestBody DistributionUserHierarchyQuery distributionUserHierarchyQuery) {
        PagerDTO pagerDTO = distributionService.listUserHierarchy(distributionUserHierarchyQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), DistributionUserHierarchyVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setDistributionService(DistributionService distributionService) {
        this.distributionService = distributionService;
    }

    @Autowired
    public void setSysConfigService(SysConfigService sysConfigService) {
        this.sysConfigService = sysConfigService;
    }
}
