package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.query.UserGoodsOrderLogisticsQuery;
import top.zywork.service.UserGoodsOrderLogisticsService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.UserGoodsOrderLogisticsVO;

/**
 * UserGoodsOrderLogisticsController控制器类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/user-goods-order-logistics")
public class UserGoodsOrderLogisticsController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserGoodsOrderLogisticsController.class);

    private UserGoodsOrderLogisticsService userGoodsOrderLogisticsService;

    @GetMapping("admin/multi/{id}")
    public ResponseStatusVO listById(@PathVariable("id") Long id) {
        PagerDTO pagerDTO = userGoodsOrderLogisticsService.listById(id);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserGoodsOrderLogisticsVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = userGoodsOrderLogisticsService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserGoodsOrderLogisticsVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody UserGoodsOrderLogisticsQuery userGoodsOrderLogisticsQuery) {
        PagerDTO pagerDTO = userGoodsOrderLogisticsService.listAllByCondition(userGoodsOrderLogisticsQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserGoodsOrderLogisticsVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody UserGoodsOrderLogisticsQuery userGoodsOrderLogisticsQuery) {
        PagerDTO pagerDTO = userGoodsOrderLogisticsService.listPageByCondition(userGoodsOrderLogisticsQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), UserGoodsOrderLogisticsVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setUserGoodsOrderLogisticsService(UserGoodsOrderLogisticsService userGoodsOrderLogisticsService) {
        this.userGoodsOrderLogisticsService = userGoodsOrderLogisticsService;
    }
}
