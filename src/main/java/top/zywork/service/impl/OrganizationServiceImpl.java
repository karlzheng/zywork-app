package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.OrganizationDAO;
import top.zywork.dos.OrganizationDO;
import top.zywork.dto.OrganizationDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.OrganizationService;

import javax.annotation.PostConstruct;

/**
 * OrganizationServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-01-24<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "organizationService")
public class OrganizationServiceImpl extends AbstractBaseService implements OrganizationService {

    private OrganizationDAO organizationDAO;

    @Autowired
    public void setOrganizationDAO(OrganizationDAO organizationDAO) {
        super.setBaseDAO(organizationDAO);
        this.organizationDAO = organizationDAO;
    }

    @PostConstruct
    public void init() {
        super.init(OrganizationDO.class, OrganizationDTO.class);
    }
}
