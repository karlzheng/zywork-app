package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.DistributionDAO;
import top.zywork.dto.PagerDTO;
import top.zywork.query.DistributionUserHierarchyQuery;
import top.zywork.query.PageQuery;
import top.zywork.service.DistributionService;

import java.util.ArrayList;
import java.util.List;

/**
 * 分销Service接口实现类<br/>
 *
 * 创建于2018-12-28<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Service
public class DistributionServiceImpl implements DistributionService {

    private DistributionDAO distributionDAO;

    @Override
    public PagerDTO listAllTop(Object queryObj) {
        PagerDTO pagerDTO = new PagerDTO();
        Long count = distributionDAO.countAllTop();
        if (count > 0) {
            pagerDTO.setTotal(count);
            pagerDTO.setRows(distributionDAO.listAllTop(queryObj));
        } else {
            pagerDTO.setRows(new ArrayList<>());
        }
        return pagerDTO;
    }

    @Override
    public PagerDTO listAboveUsers(Long userId, Integer distributionLevel, Long[] levels, PageQuery pageQuery) {
        PagerDTO pagerDTO = new PagerDTO();
        Long count = distributionDAO.countAboveUsers(userId, distributionLevel, levels);
        if (count > 0) {
            pagerDTO.setTotal(count);
            pagerDTO.setRows(distributionDAO.listAboveUsers(userId, distributionLevel, levels, pageQuery));
        } else {
            pagerDTO.setRows(new ArrayList<>());
        }
        return pagerDTO;
    }

    @Override
    public PagerDTO allDirectAboveUsers(Long userId, Integer distributionLevel, Long level) {
        PagerDTO pagerDTO = new PagerDTO();
        List<Object> objectList = distributionDAO.allDirectAboveUsers(userId, distributionLevel, level);
        pagerDTO.setTotal(objectList == null ? 0 : (long) objectList.size());
        pagerDTO.setRows(objectList == null ? new ArrayList<>() : objectList);
        return pagerDTO;
    }

    @Override
    public PagerDTO listBelowUsers(Long userId, Integer distributionLevel, Long[] levels, PageQuery pageQuery) {
        PagerDTO pagerDTO = new PagerDTO();
        Long count = distributionDAO.countBelowUsers(userId, distributionLevel, levels);
        if (count > 0) {
            pagerDTO.setTotal(count);
            pagerDTO.setRows(distributionDAO.listBelowUsers(userId, distributionLevel, levels, pageQuery));
        } else {
            pagerDTO.setRows(new ArrayList<>());
        }
        return pagerDTO;
    }

    @Override
    public PagerDTO allDirectBelowUsers(Long userId, Integer distributionLevel, Long level) {
        PagerDTO pagerDTO = new PagerDTO();
        List<Object> objectList = distributionDAO.allDirectBelowUsers(userId, distributionLevel, level);
        pagerDTO.setTotal(objectList == null ? 0 : (long) objectList.size());
        pagerDTO.setRows(objectList == null ? new ArrayList<>() : objectList);
        return pagerDTO;
    }

    @Override
    public PagerDTO listUserPathsByUserId(Long userId, PageQuery pageQuery) {
        PagerDTO pagerDTO = new PagerDTO();
        Long count = distributionDAO.countUserPathsByUserId(userId);
        if (count > 0) {
            pagerDTO.setTotal(count);
            pagerDTO.setRows(distributionDAO.listUserPathsByUserId(userId, pageQuery));
        } else {
            pagerDTO.setRows(new ArrayList<>());
        }
        return pagerDTO;
    }

    @Override
    public PagerDTO listUserHierarchy(DistributionUserHierarchyQuery distributionUserHierarchyQuery) {
        PagerDTO pagerDTO = new PagerDTO();
        Long count = distributionDAO.countUserHierarchy(distributionUserHierarchyQuery);
        if (count > 0) {
            pagerDTO.setTotal(count);
            pagerDTO.setRows(distributionDAO.listUserHierarchy(distributionUserHierarchyQuery));
        } else {
            pagerDTO.setRows(new ArrayList<>());
        }
        return pagerDTO;
    }

    @Autowired
    public void setDistributionDAO(DistributionDAO distributionDAO) {
        this.distributionDAO = distributionDAO;
    }
}
