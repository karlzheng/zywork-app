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
     *
     * @param shippingAddressVO
     * @param bindingResult
     * @return
     */
    @PostMapping("user/save")
    public ResponseStatusVO userSave(@RequestBody @Validated ShippingAddressVO shippingAddressVO, BindingResult bindingResult) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        shippingAddressVO.setUserId(jwtUser.getUserId());
        return save(shippingAddressVO, bindingResult);
    }

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated ShippingAddressVO shippingAddressVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        shippingAddressService.save(BeanUtils.copy(shippingAddressVO, ShippingAddressDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<ShippingAddressVO> shippingAddressVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        shippingAddressService.saveBatch(BeanUtils.copyListObj(shippingAddressVOList, ShippingAddressDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        shippingAddressService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    /**
     * 用户删除收货地址
     *
     * @param id
     * @return
     */
    @GetMapping("user/remove/{id}")
    public ResponseStatusVO userRemoveById(@PathVariable("id") Long id) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        if (hasShippingAddress(id, jwtUser.getUserId())) {
            return removeById(id);
        } else {
            return ResponseStatusVO.dataError("不存在的用户地址编号", null);
        }
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        shippingAddressService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated ShippingAddressVO shippingAddressVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = shippingAddressService.update(BeanUtils.copy(shippingAddressVO, ShippingAddressDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    /**
     * 用户更新收货地址
     *
     * @param shippingAddressVO
     * @param bindingResult
     * @return
     */
    @PostMapping("user/update")
    public ResponseStatusVO userUpdate(@RequestBody @Validated ShippingAddressVO shippingAddressVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        if (!hasShippingAddress(shippingAddressVO.getId(), jwtUser.getUserId())) {
            return ResponseStatusVO.dataError("不正确的用户地址编号", null);
        }
        int updateRows = shippingAddressService.updateAddress(BeanUtils.copy(shippingAddressVO, ShippingAddressDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<ShippingAddressVO> shippingAddressVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        shippingAddressService.updateBatch(BeanUtils.copyListObj(shippingAddressVOList, ShippingAddressDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody ShippingAddressVO shippingAddressVO) {
        shippingAddressService.update(BeanUtils.copy(shippingAddressVO, ShippingAddressDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<ShippingAddressVO> shippingAddressVOList) {
        shippingAddressService.updateBatch(BeanUtils.copyListObj(shippingAddressVOList, ShippingAddressDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        ShippingAddressVO shippingAddressVO = new ShippingAddressVO();
        Object obj = shippingAddressService.getById(id);
        if (obj != null) {
            shippingAddressVO = BeanUtils.copy(obj, ShippingAddressVO.class);
        }
        return ResponseStatusVO.ok("查询成功", shippingAddressVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = shippingAddressService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ShippingAddressVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody ShippingAddressQuery shippingAddressQuery) {
        PagerDTO pagerDTO = shippingAddressService.listPageByCondition(shippingAddressQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ShippingAddressVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 根据条件查询用户的收货地址
     *
     * @param shippingAddressQuery
     * @return
     */
    @PostMapping("user/pager-cond")
    public ResponseStatusVO userListPageByCondition(@RequestBody ShippingAddressQuery shippingAddressQuery) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        shippingAddressQuery.setUserId(jwtUser.getUserId());
        return listPageByCondition(shippingAddressQuery);
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
