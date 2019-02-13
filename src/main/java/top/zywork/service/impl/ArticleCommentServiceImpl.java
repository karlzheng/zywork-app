package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.ArticleCommentDAO;
import top.zywork.dos.ArticleCommentDO;
import top.zywork.dto.ArticleCommentDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ArticleCommentService;

import javax.annotation.PostConstruct;

/**
 * ArticleCommentServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-02-13<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "articleCommentService")
public class ArticleCommentServiceImpl extends AbstractBaseService implements ArticleCommentService {

    private ArticleCommentDAO articleCommentDAO;

    @Autowired
    public void setArticleCommentDAO(ArticleCommentDAO articleCommentDAO) {
        super.setBaseDAO(articleCommentDAO);
        this.articleCommentDAO = articleCommentDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ArticleCommentDO.class, ArticleCommentDTO.class);
    }
}
