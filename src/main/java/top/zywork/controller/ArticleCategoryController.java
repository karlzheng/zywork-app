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
import top.zywork.dto.ArticleCategoryDTO;
import top.zywork.dto.PagerDTO;
import top.zywork.query.ArticleCategoryQuery;
import top.zywork.service.ArticleCategoryService;
import top.zywork.vo.ArticleCategoryVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ResponseStatusVO;

import java.util.List;

/**
 * ArticleCategoryController控制器类<br/>
 *
 * 创建于2019-02-13<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/article-category")
public class ArticleCategoryController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleCategoryController.class);

    private ArticleCategoryService articleCategoryService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated ArticleCategoryVO articleCategoryVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        articleCategoryService.save(BeanUtils.copy(articleCategoryVO, ArticleCategoryDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<ArticleCategoryVO> articleCategoryVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        articleCategoryService.saveBatch(BeanUtils.copyListObj(articleCategoryVOList, ArticleCategoryDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        articleCategoryService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        articleCategoryService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated ArticleCategoryVO articleCategoryVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = articleCategoryService.update(BeanUtils.copy(articleCategoryVO, ArticleCategoryDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<ArticleCategoryVO> articleCategoryVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        articleCategoryService.updateBatch(BeanUtils.copyListObj(articleCategoryVOList, ArticleCategoryDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody ArticleCategoryVO articleCategoryVO) {
        articleCategoryService.update(BeanUtils.copy(articleCategoryVO, ArticleCategoryDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<ArticleCategoryVO> articleCategoryVOList) {
        articleCategoryService.updateBatch(BeanUtils.copyListObj(articleCategoryVOList, ArticleCategoryDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        ArticleCategoryVO articleCategoryVO = new ArticleCategoryVO();
        Object obj = articleCategoryService.getById(id);
        if (obj != null) {
            articleCategoryVO = BeanUtils.copy(obj, ArticleCategoryVO.class);
        }
        return ResponseStatusVO.ok("查询成功", articleCategoryVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = articleCategoryService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ArticleCategoryVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 用户查询所有文章分类
     * @return
     */
    @GetMapping("user/all")
    public ResponseStatusVO userListAll() {
        return listAll();
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody ArticleCategoryQuery articleCategoryQuery) {
        PagerDTO pagerDTO = articleCategoryService.listAllByCondition(articleCategoryQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ArticleCategoryVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 用户条件查询所有文章分类
     * @param articleCategoryQuery
     * @return
     */
    @PostMapping("user/all-cond")
    public ResponseStatusVO userListAllByCondition(@RequestBody ArticleCategoryQuery articleCategoryQuery) {
        return listAllByCondition(articleCategoryQuery);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody ArticleCategoryQuery articleCategoryQuery) {
        PagerDTO pagerDTO = articleCategoryService.listPageByCondition(articleCategoryQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), ArticleCategoryVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    /**
     * 用户条件查询文章分类
     * @param articleCategoryQuery
     * @return
     */
    @PostMapping("user/pager-cond")
    public ResponseStatusVO userListPageByCondition(@RequestBody ArticleCategoryQuery articleCategoryQuery) {
        return listPageByCondition(articleCategoryQuery);
    }

    @Autowired
    public void setArticleCategoryService(ArticleCategoryService articleCategoryService) {
        this.articleCategoryService = articleCategoryService;
    }
}
