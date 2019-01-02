package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.NoticeDAO;
import top.zywork.dos.NoticeDO;
import top.zywork.dto.NoticeDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.NoticeService;

import javax.annotation.PostConstruct;

/**
 * NoticeServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-01-02<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "noticeService")
public class NoticeServiceImpl extends AbstractBaseService implements NoticeService {

    private NoticeDAO noticeDAO;

    @Autowired
    public void setNoticeDAO(NoticeDAO noticeDAO) {
        super.setBaseDAO(noticeDAO);
        this.noticeDAO = noticeDAO;
    }

    @PostConstruct
    public void init() {
        super.init(NoticeDO.class, NoticeDTO.class);
    }
}
