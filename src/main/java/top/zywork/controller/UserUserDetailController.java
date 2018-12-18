package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.exception.ServiceException;
import top.zywork.query.UserUserDetailQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserUserDetailService;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.UserUserDetailVO;

import java.util.List;

/**
 * UserUserDetailController控制器类<br/>
 *
 * 创建于2018-12-18<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/user-userdetail")
public class UserUserDetailController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserUserDetailController.class);

    private UserUserDetailService userUserDetailService;

    @GetMapping("multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            List<Object> objectList = userUserDetailService.listById(id);
            List<UserUserDetailVO> userUserDetailVOList =  BeanUtils.copy(objectList, UserUserDetailVO.class);
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", userUserDetailVOList);
        } catch (ServiceException e) {
            logger.error("返回单个对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    /**
     * 根据用户id查询用户信息，只能查询自己的用户信息
     * @param id
     * @return
     */
    @GetMapping("user/multi/{id}")
    public ResponseStatusVO listByIdUser(@PathVariable("id") Long id) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (jwtUser == null) {
            statusVO.errorStatus(ResponseStatusEnum.AUTHENTICATION_ERROR.getCode(), ResponseStatusEnum.AUTHENTICATION_ERROR.getMessage(), null);
            return statusVO;
        } else {
            if (jwtUser.getUserId() != id) {
                statusVO.errorStatus(ResponseStatusEnum.AUTHORIZATION_ERROR.getCode(), ResponseStatusEnum.AUTHORIZATION_ERROR.getMessage(), null);
                return statusVO;
            } else {
                return listById(id);
            }
        }
    }

    @GetMapping("all")
    public ResponseStatusVO listAll() {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            List<Object> objectList = userUserDetailService.listAll();
            List<UserUserDetailVO> userUserDetailVOList =  BeanUtils.copy(objectList, UserUserDetailVO.class);
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", userUserDetailVOList);
        } catch (ServiceException e) {
            logger.error("返回所有对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    @PostMapping("pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserUserDetailQuery userUserDetailQuery) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            PagerDTO pagerDTO = userUserDetailService.listPageByCondition(userUserDetailQuery);
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserUserDetailVO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回指定条件的分页对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    @Autowired
    public void setUserUserDetailService(UserUserDetailService userUserDetailService) {
        this.userUserDetailService = userUserDetailService;
    }
}
