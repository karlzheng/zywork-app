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
import top.zywork.dto.NoticeDTO;
import top.zywork.dto.PagerDTO;
import top.zywork.query.NoticeQuery;
import top.zywork.service.NoticeService;
import top.zywork.vo.NoticeVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ResponseStatusVO;

import java.util.List;

/**
 * NoticeController控制器类<br/>
 *
 * 创建于2019-01-02<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/notice")
public class NoticeController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

    private NoticeService noticeService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated NoticeVO noticeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        noticeService.save(BeanUtils.copy(noticeVO, NoticeDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<NoticeVO> noticeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        noticeService.saveBatch(BeanUtils.copyListObj(noticeVOList, NoticeDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        noticeService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        noticeService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated NoticeVO noticeVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = noticeService.update(BeanUtils.copy(noticeVO, NoticeDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<NoticeVO> noticeVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        noticeService.updateBatch(BeanUtils.copyListObj(noticeVOList, NoticeDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody NoticeVO noticeVO) {
        noticeService.update(BeanUtils.copy(noticeVO, NoticeDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<NoticeVO> noticeVOList) {
        noticeService.updateBatch(BeanUtils.copyListObj(noticeVOList, NoticeDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        NoticeVO noticeVO = new NoticeVO();
        Object obj = noticeService.getById(id);
        if (obj != null) {
            noticeVO = BeanUtils.copy(obj, NoticeVO.class);
        }
        return ResponseStatusVO.ok("查询成功", noticeVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = noticeService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), NoticeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody NoticeQuery noticeQuery) {
        PagerDTO pagerDTO = noticeService.listAllByCondition(noticeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), NoticeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody NoticeQuery noticeQuery) {
        PagerDTO pagerDTO = noticeService.listPageByCondition(noticeQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), NoticeVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 用户获取公告，可指定按照stickStatus排序，并指定endTime大于等于今日日期的公告才返回
     *
     * @param noticeQuery
     * @return
     */
    @PostMapping("user/pager-cond")
    public ResponseStatusVO userListPageByCondition(@RequestBody NoticeQuery noticeQuery) {
        return listPageByCondition(noticeQuery);
    }

    @Autowired
    public void setNoticeService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }
}
