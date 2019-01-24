package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.MessageDAO;
import top.zywork.dos.MessageDO;
import top.zywork.dto.MessageDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.MessageService;

import javax.annotation.PostConstruct;

/**
 * MessageServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-01-24<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "messageService")
public class MessageServiceImpl extends AbstractBaseService implements MessageService {

    private MessageDAO messageDAO;

    @Autowired
    public void setMessageDAO(MessageDAO messageDAO) {
        super.setBaseDAO(messageDAO);
        this.messageDAO = messageDAO;
    }

    @PostConstruct
    public void init() {
        super.init(MessageDO.class, MessageDTO.class);
    }
}
