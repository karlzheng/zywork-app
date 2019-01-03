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
import top.zywork.dto.UserWalletDTO;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.exception.ServiceException;
import top.zywork.query.UserWalletQuery;
import top.zywork.service.UserWalletService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserWalletVO;

import java.util.List;

/**
 * UserWalletController控制器类<br/>
 *
 * 创建于2018-12-23<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/user-wallet")
public class UserWalletController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserWalletController.class);

    private UserWalletService userWalletService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated UserWalletVO userWalletVO, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                userWalletService.save(BeanUtils.copy(userWalletVO, UserWalletDTO.class));
                statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "添加成功", null);
            } catch (ServiceException e) {
                logger.error("添加失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "添加失败", null);
            }
        }
        return statusVO;
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<UserWalletVO> userWalletVOList, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                userWalletService.saveBatch(BeanUtils.copyListObj(userWalletVOList, UserWalletDTO.class));
                statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "批量添加成功", null);
            } catch (ServiceException e) {
                logger.error("添加失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "批量添加失败", null);
            }
        }
        return statusVO;
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            userWalletService.removeById(id);
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "删除成功", null);
        } catch (ServiceException e) {
            logger.error("删除失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "删除失败", null);
        }
        return statusVO;
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            userWalletService.removeByIds(StringUtils.strArrayToLongArray(ids));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "批量删除成功", null);
        } catch (ServiceException e) {
            logger.error("批量删除失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "批量删除失败", null);
        }
        return statusVO;
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated UserWalletVO userWalletVO, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                int updateRows = userWalletService.update(BeanUtils.copy(userWalletVO, UserWalletDTO.class));
                if (updateRows == 1) {
                    statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "更新成功", null);
                } else {
                    statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "数据版本号有问题，在此更新前数据已被更新", null);
                }
            } catch (ServiceException e) {
                logger.error("更新失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "更新失败", null);
            }
        }
        return statusVO;
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<UserWalletVO> userWalletVOList, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                userWalletService.updateBatch(BeanUtils.copyListObj(userWalletVOList, UserWalletDTO.class));
                statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "批量更新成功", null);
            } catch (ServiceException e) {
                logger.error("批量更新失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "批量更新失败", null);
            }
        }
        return statusVO;
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody UserWalletVO userWalletVO) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            userWalletService.update(BeanUtils.copy(userWalletVO, UserWalletDTO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "激活或冻结成功", null);
        } catch (ServiceException e) {
            logger.error("激活或冻结失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "激活或冻结失败", null);
        }
        return statusVO;
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<UserWalletVO> userWalletVOList) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            userWalletService.updateBatch(BeanUtils.copyListObj(userWalletVOList, UserWalletDTO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "批量激活或冻结成功", null);
        } catch (ServiceException e) {
            logger.error("批量激活或冻结失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "批量激活或冻结失败", null);
        }
        return statusVO;
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        UserWalletVO userWalletVO = new UserWalletVO();
        try {
            Object obj = userWalletService.getById(id);
            if (obj != null) {
                userWalletVO = BeanUtils.copy(obj, UserWalletVO.class);
            }
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", userWalletVO);
        } catch (ServiceException e) {
            logger.error("返回单个对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            PagerDTO pagerDTO = userWalletService.listAll();
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserWalletVO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回所有对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserWalletQuery userWalletQuery) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            PagerDTO pagerDTO = userWalletService.listPageByCondition(userWalletQuery);
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserWalletVO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回指定条件的分页对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    @Autowired
    public void setUserWalletService(UserWalletService userWalletService) {
        this.userWalletService = userWalletService;
    }
}
