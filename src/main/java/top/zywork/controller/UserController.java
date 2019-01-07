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
import top.zywork.dto.UserDTO;
import top.zywork.exception.ServiceException;
import top.zywork.query.UserQuery;
import top.zywork.service.UserService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserVO;

import java.util.List;

/**
 * UserController控制器类<br/>
 *
 * 创建于2018-12-25<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated UserVO userVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        try {
            userService.save(BeanUtils.copy(userVO, UserDTO.class));
            return ResponseStatusVO.ok("添加成功", null);
        } catch (ServiceException e) {
            logger.error("添加失败：{}", e.getMessage());
            return ResponseStatusVO.error("添加失败", null);
        }
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<UserVO> userVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        try {
            userService.saveBatch(BeanUtils.copyListObj(userVOList, UserDTO.class));
            return ResponseStatusVO.ok("批量添加成功", null);
        } catch (ServiceException e) {
            logger.error("添加失败：{}", e.getMessage());
            return ResponseStatusVO.error("批量添加失败", null);
        }
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        try {
            userService.removeById(id);
            return ResponseStatusVO.ok("删除成功", null);
        } catch (ServiceException e) {
            logger.error("删除失败：{}", e.getMessage());
            return ResponseStatusVO.error("删除失败", null);
        }
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        try {
            userService.removeByIds(StringUtils.strArrayToLongArray(ids));
            return ResponseStatusVO.ok("批量删除成功", null);
        } catch (ServiceException e) {
            logger.error("批量删除失败：{}", e.getMessage());
            return ResponseStatusVO.error("批量删除失败", null);
        }
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated UserVO userVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        try {
            int updateRows = userService.update(BeanUtils.copy(userVO, UserDTO.class));
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
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<UserVO> userVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        try {
            userService.updateBatch(BeanUtils.copyListObj(userVOList, UserDTO.class));
            return ResponseStatusVO.ok("批量更新成功", null);
        } catch (ServiceException e) {
            logger.error("批量更新失败：{}", e.getMessage());
            return ResponseStatusVO.error("批量更新失败", null);
        }
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody UserVO userVO) {
        try {
            userService.update(BeanUtils.copy(userVO, UserDTO.class));
            return ResponseStatusVO.ok("激活或冻结成功", null);
        } catch (ServiceException e) {
            logger.error("激活或冻结失败：{}", e.getMessage());
            return ResponseStatusVO.error("激活或冻结失败", null);
        }
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<UserVO> userVOList) {
        try {
            userService.updateBatch(BeanUtils.copyListObj(userVOList, UserDTO.class));
            return ResponseStatusVO.ok("批量激活或冻结成功", null);
        } catch (ServiceException e) {
            logger.error("批量激活或冻结失败：{}", e.getMessage());
            return ResponseStatusVO.error("批量激活或冻结失败", null);
        }
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        UserVO userVO = new UserVO();
        try {
            Object obj = userService.getById(id);
            if (obj != null) {
                userVO = BeanUtils.copy(obj, UserVO.class);
            }
            return ResponseStatusVO.ok("查询成功", userVO);
        } catch (ServiceException e) {
            logger.error("返回单个对象JSON数据失败：{}", e.getMessage());
            return ResponseStatusVO.error("查询失败", null);
        }
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        try {
            PagerDTO pagerDTO = userService.listAll();
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserVO.class));
            return ResponseStatusVO.ok("查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回所有对象JSON数据失败：{}", e.getMessage());
            return ResponseStatusVO.error("查询失败", null);
        }
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserQuery userQuery) {
        try {
            PagerDTO pagerDTO = userService.listPageByCondition(userQuery);
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserVO.class));
            return ResponseStatusVO.ok("查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回指定条件的分页对象JSON数据失败：{}", e.getMessage());
            return ResponseStatusVO.error("查询失败", null);
        }
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
