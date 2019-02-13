package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.ArticleCategoryDAO;
import top.zywork.dos.ArticleCategoryDO;
import top.zywork.dto.ArticleCategoryDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ArticleCategoryService;

import javax.annotation.PostConstruct;

/**
 * ArticleCategoryServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-02-13<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "articleCategoryService")
public class ArticleCategoryServiceImpl extends AbstractBaseService implements ArticleCategoryService {

    private ArticleCategoryDAO articleCategoryDAO;

    @Autowired
    public void setArticleCategoryDAO(ArticleCategoryDAO articleCategoryDAO) {
        super.setBaseDAO(articleCategoryDAO);
        this.articleCategoryDAO = articleCategoryDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ArticleCategoryDO.class, ArticleCategoryDTO.class);
    }
}
