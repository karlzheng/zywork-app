package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.UserGoodsOrderItemQuery;
import top.zywork.service.UserGoodsOrderItemService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserGoodsOrderItemVO;

/**
 * UserGoodsOrderItemController控制器类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/user-goods-order-item")
public class UserGoodsOrderItemController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserGoodsOrderItemController.class);

    private UserGoodsOrderItemService userGoodsOrderItemService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = userGoodsOrderItemService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserGoodsOrderItemVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userGoodsOrderItemService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserGoodsOrderItemVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserGoodsOrderItemQuery userGoodsOrderItemQuery) {
        PagerDTO pagerDTO = userGoodsOrderItemService.listAllByCondition(userGoodsOrderItemQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserGoodsOrderItemVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserGoodsOrderItemQuery userGoodsOrderItemQuery) {
        PagerDTO pagerDTO = userGoodsOrderItemService.listPageByCondition(userGoodsOrderItemQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserGoodsOrderItemVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setUserGoodsOrderItemService(UserGoodsOrderItemService userGoodsOrderItemService) {
        this.userGoodsOrderItemService = userGoodsOrderItemService;
    }
}
