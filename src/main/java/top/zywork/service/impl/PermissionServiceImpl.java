package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.common.BeanUtils;
import top.zywork.common.ExceptionUtils;
import top.zywork.dao.PermissionDAO;
import top.zywork.dos.PermissionDO;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.PermissionDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.PermissionService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * PermissionServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "permissionService")
public class PermissionServiceImpl extends AbstractBaseService implements PermissionService {

    private PermissionDAO permissionDAO;

    @Override
    @SuppressWarnings({"unchecked"})
    public PagerDTO listByUserId(Long userId) {
        PagerDTO pagerDTO = new PagerDTO();
        try {
            List<Object> permissionDOList = permissionDAO.listByUserId(userId);
            List<Object> permissionDTOList = new ArrayList<>();
            if (permissionDOList != null && permissionDOList.size() > 0) {
                permissionDTOList = BeanUtils.copyList(permissionDOList, PermissionDTO.class);
            }
            pagerDTO.setRows(permissionDTOList);
            pagerDTO.setTotal((long)(permissionDTOList.size()));
            return pagerDTO;
        } catch (RuntimeException e) {
            throw ExceptionUtils.serviceException(e);
        }
    }

    @Autowired
    public void setPermissionDAO(PermissionDAO permissionDAO) {
        super.setBaseDAO(permissionDAO);
        this.permissionDAO = permissionDAO;
    }

    @PostConstruct
    public void init() {
        super.init(PermissionDO.class, PermissionDTO.class);
    }
}
