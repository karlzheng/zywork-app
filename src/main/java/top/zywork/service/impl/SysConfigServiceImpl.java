package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.SysConfigDAO;
import top.zywork.dos.SysConfigDO;
import top.zywork.dto.SysConfigDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.SysConfigService;

import javax.annotation.PostConstruct;

/**
 * SysConfigServiceImpl服务接口实现类<br/>
 *
 * 创建于2018-12-20<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "sysConfigService")
public class SysConfigServiceImpl extends AbstractBaseService implements SysConfigService {

    private SysConfigDAO sysConfigDAO;

    @Autowired
    public void setSysConfigDAO(SysConfigDAO sysConfigDAO) {
        super.setBaseDAO(sysConfigDAO);
        this.sysConfigDAO = sysConfigDAO;
    }

    @PostConstruct
    public void init() {
        super.init(SysConfigDO.class, SysConfigDTO.class);
    }
}
