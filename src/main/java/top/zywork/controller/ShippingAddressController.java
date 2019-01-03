package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.common.BindingResultUtils;
import top.zywork.common.StringUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.ShippingAddressDTO;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.exception.ServiceException;
import top.zywork.query.ShippingAddressQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.ShippingAddressService;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.ShippingAddressVO;

import java.util.List;

/**
 * ShippingAddressController控制器类<br/>
 *
 * 创建于2019-01-03<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/shipping-address")
public class ShippingAddressController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ShippingAddressController.class);

    private ShippingAddressService shippingAddressService;

    /**
     * 用户保存收货地址
     * @param shippingAddressVO
     * @param bindingResult
     * @return
     */
    @PostMapping("user/save")
    public ResponseStatusVO userSave(@RequestBody @Validated ShippingAddressVO shippingAddressVO, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser != null) {
            shippingAddressVO.setUserId(jwtUser.getUserId());
            return save(shippingAddressVO, bindingResult);
        } else {
            statusVO.okStatus(ResponseStatusEnum.AUTHENTICATION_ERROR.getCode(), ResponseStatusEnum.AUTHENTICATION_ERROR.getMessage(), null);
        }
        return statusVO;
    }

    @PostMapping("save")
    public ResponseStatusVO save(@RequestBody @Validated ShippingAddressVO shippingAddressVO, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                shippingAddressService.save(BeanUtils.copy(shippingAddressVO, ShippingAddressDTO.class));
                statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "添加成功", null);
            } catch (ServiceException e) {
                logger.error("添加失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "添加失败", null);
            }
        }
        return statusVO;
    }

    @PostMapping("batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<ShippingAddressVO> shippingAddressVOList, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                shippingAddressService.saveBatch(BeanUtils.copyListObj(shippingAddressVOList, ShippingAddressDTO.class));
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
            shippingAddressService.removeById(id);
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "删除成功", null);
        } catch (ServiceException e) {
            logger.error("删除失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "删除失败", null);
        }
        return statusVO;
    }

    /**
     * 用户删除收货地址
     * @param id
     * @return
     */
    @GetMapping("user/remove/{id}")
    public ResponseStatusVO userRemoveById(@PathVariable("id") Long id) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser != null) {
            if (hasShippingAddress(id, jwtUser.getUserId())) {
                return removeById(id);
            } else {
                statusVO.okStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "不存在的用户地址编号", null);
            }
        } else {
            statusVO.okStatus(ResponseStatusEnum.AUTHENTICATION_ERROR.getCode(), ResponseStatusEnum.AUTHENTICATION_ERROR.getMessage(), null);
        }
        return statusVO;
    }

    @PostMapping("batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            shippingAddressService.removeByIds(StringUtils.strArrayToLongArray(ids));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "批量删除成功", null);
        } catch (ServiceException e) {
            logger.error("批量删除失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "批量删除失败", null);
        }
        return statusVO;
    }

    @PostMapping("update")
    public ResponseStatusVO update(@RequestBody @Validated ShippingAddressVO shippingAddressVO, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                int updateRows = shippingAddressService.update(BeanUtils.copy(shippingAddressVO, ShippingAddressDTO.class));
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

    /**
     * 用户更新收货地址
     * @param shippingAddressVO
     * @param bindingResult
     * @return
     */
    @PostMapping("user/update")
    public ResponseStatusVO userUpdate(@RequestBody @Validated ShippingAddressVO shippingAddressVO, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            JwtUser jwtUser = SecurityUtils.getJwtUser();
            if (jwtUser != null) {
                if (hasShippingAddress(shippingAddressVO.getId(), jwtUser.getUserId())) {
                    try {
                        int updateRows = shippingAddressService.updateAddress(BeanUtils.copy(shippingAddressVO, ShippingAddressDTO.class));
                        if (updateRows == 1) {
                            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "更新成功", null);
                        } else {
                            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "数据版本号有问题，在此更新前数据已被更新", null);
                        }
                    } catch (ServiceException e) {
                        logger.error("更新失败：{}", e.getMessage());
                        statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "更新失败", null);
                    }
                } else {
                    statusVO.okStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "不正确的用户地址编号", null);
                }
            } else {
                statusVO.okStatus(ResponseStatusEnum.AUTHENTICATION_ERROR.getCode(), ResponseStatusEnum.AUTHENTICATION_ERROR.getMessage(), null);
            }

        }

        return statusVO;
    }

    @PostMapping("batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<ShippingAddressVO> shippingAddressVOList, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                shippingAddressService.updateBatch(BeanUtils.copyListObj(shippingAddressVOList, ShippingAddressDTO.class));
                statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "批量更新成功", null);
            } catch (ServiceException e) {
                logger.error("批量更新失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "批量更新失败", null);
            }
        }
        return statusVO;
    }

    @PostMapping("active")
    public ResponseStatusVO active(@RequestBody ShippingAddressVO shippingAddressVO) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            shippingAddressService.update(BeanUtils.copy(shippingAddressVO, ShippingAddressDTO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "激活或冻结成功", null);
        } catch (ServiceException e) {
            logger.error("激活或冻结失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "激活或冻结失败", null);
        }
        return statusVO;
    }

    @PostMapping("batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<ShippingAddressVO> shippingAddressVOList) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            shippingAddressService.updateBatch(BeanUtils.copyListObj(shippingAddressVOList, ShippingAddressDTO.class));
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
        ShippingAddressVO shippingAddressVO = new ShippingAddressVO();
        try {
            Object obj = shippingAddressService.getById(id);
            if (obj != null) {
                shippingAddressVO = BeanUtils.copy(obj, ShippingAddressVO.class);
            }
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", shippingAddressVO);
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
            PagerDTO pagerDTO = shippingAddressService.listAll();
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ShippingAddressVO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回所有对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    @PostMapping("pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody ShippingAddressQuery shippingAddressQuery) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            PagerDTO pagerDTO = shippingAddressService.listPageByCondition(shippingAddressQuery);
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ShippingAddressVO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回指定条件的分页对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    private boolean hasShippingAddress(Long addressId, Long userId) {
        ShippingAddressQuery shippingAddressQuery = new ShippingAddressQuery();
        shippingAddressQuery.setId(addressId);
        shippingAddressQuery.setUserId(userId);
        return shippingAddressService.countByCondition(shippingAddressQuery) > 0;
    }

    @Autowired
    public void setShippingAddressService(ShippingAddressService shippingAddressService) {
        this.shippingAddressService = shippingAddressService;
    }
}
