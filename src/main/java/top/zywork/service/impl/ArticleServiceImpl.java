package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.ArticleDAO;
import top.zywork.dos.ArticleDO;
import top.zywork.dto.ArticleDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ArticleService;

import javax.annotation.PostConstruct;

/**
 * ArticleServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-02-13<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "articleService")
public class ArticleServiceImpl extends AbstractBaseService implements ArticleService {

    private ArticleDAO articleDAO;

    @Autowired
    public void setArticleDAO(ArticleDAO articleDAO) {
        super.setBaseDAO(articleDAO);
        this.articleDAO = articleDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ArticleDO.class, ArticleDTO.class);
    }
}
