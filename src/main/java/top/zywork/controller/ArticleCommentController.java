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
import top.zywork.dto.ArticleCommentDTO;
import top.zywork.query.ArticleCommentQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.ArticleCommentService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ArticleCommentVO;

import java.security.Security;
import java.util.List;

/**
 * ArticleCommentController控制器类<br/>
 *
 * 创建于2019-02-13<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/article-comment")
public class ArticleCommentController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleCommentController.class);

    private ArticleCommentService articleCommentService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated ArticleCommentVO articleCommentVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        articleCommentService.save(BeanUtils.copy(articleCommentVO, ArticleCommentDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    /**
     * 用户添加评论
     * @param articleCommentVO
     * @param bindingResult
     * @return
     */
    @PostMapping("user/save")
    public ResponseStatusVO userSave(@RequestBody @Validated ArticleCommentVO articleCommentVO, BindingResult bindingResult) {
        return save(articleCommentVO, bindingResult);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<ArticleCommentVO> articleCommentVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        articleCommentService.saveBatch(BeanUtils.copyListObj(articleCommentVOList, ArticleCommentDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        articleCommentService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    /**
     * 用户删除指定评论
     * @param id
     * @return
     */
    @GetMapping("user/remove/{id}")
    public ResponseStatusVO userRemoveById(@PathVariable("id") Long id) {
        return removeById(id);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        articleCommentService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    /**
     * 用户批量删除评论
     * @param ids
     * @return
     */
    @PostMapping("user/batch-remove")
    public ResponseStatusVO userRemoveByIds(@RequestBody String[] ids) {
        return removeByIds(ids);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated ArticleCommentVO articleCommentVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = articleCommentService.update(BeanUtils.copy(articleCommentVO, ArticleCommentDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    /**
     * 用户更新评论
     * @param articleCommentVO
     * @param bindingResult
     * @return
     */
    @PostMapping("user/update")
    public ResponseStatusVO userUpdate(@RequestBody @Validated ArticleCommentVO articleCommentVO, BindingResult bindingResult) {
        return update(articleCommentVO, bindingResult);
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<ArticleCommentVO> articleCommentVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        articleCommentService.updateBatch(BeanUtils.copyListObj(articleCommentVOList, ArticleCommentDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody ArticleCommentVO articleCommentVO) {
        articleCommentService.update(BeanUtils.copy(articleCommentVO, ArticleCommentDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<ArticleCommentVO> articleCommentVOList) {
        articleCommentService.updateBatch(BeanUtils.copyListObj(articleCommentVOList, ArticleCommentDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        ArticleCommentVO articleCommentVO = new ArticleCommentVO();
        Object obj = articleCommentService.getById(id);
        if (obj != null) {
            articleCommentVO = BeanUtils.copy(obj, ArticleCommentVO.class);
        }
        return ResponseStatusVO.ok("查询成功", articleCommentVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = articleCommentService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ArticleCommentVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody ArticleCommentQuery articleCommentQuery) {
        PagerDTO pagerDTO = articleCommentService.listAllByCondition(articleCommentQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ArticleCommentVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody ArticleCommentQuery articleCommentQuery) {
        PagerDTO pagerDTO = articleCommentService.listPageByCondition(articleCommentQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ArticleCommentVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 用户条件搜索文章评论
     * @param articleCommentQuery
     * @return
     */
    @PostMapping("user/pager-cond")
    public ResponseStatusVO userListPageByCondition(@RequestBody ArticleCommentQuery articleCommentQuery) {
        return listPageByCondition(articleCommentQuery);
    }

    @Autowired
    public void setArticleCommentService(ArticleCommentService articleCommentService) {
        this.articleCommentService = articleCommentService;
    }
}
