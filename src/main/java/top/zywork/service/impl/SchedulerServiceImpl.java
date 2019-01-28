package top.zywork.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import top.zywork.common.DateUtils;
import top.zywork.common.SchedulerUtils;
import top.zywork.dao.SchedulerDAO;
import top.zywork.dos.SchedulerDO;
import top.zywork.dto.SchedulerDTO;
import top.zywork.enums.SchedulerJobStatusEnum;
import top.zywork.query.SchedulerQuery;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.SchedulerService;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * SchedulerServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-01-18<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "schedulerService")
public class SchedulerServiceImpl extends AbstractBaseService implements SchedulerService {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerServiceImpl.class);

    private SchedulerDAO schedulerDAO;

    private SchedulerFactoryBean schedulerFactoryBean;

    @Override
    @SuppressWarnings({"unchecked"})
    public void startAutoJobs() {
        SchedulerQuery schedulerQuery = new SchedulerQuery();
        schedulerQuery.setAutoStart((byte) 1);
        List<SchedulerDO> schedulerDOList = (List) schedulerDAO.listAllByCondition(schedulerQuery);
        if (schedulerDOList != null && schedulerDOList.size() > 0) {
            SchedulerUtils.initScheduler(schedulerFactoryBean);
            for (SchedulerDO schedulerDO : schedulerDOList) {
                if (SchedulerUtils.startJob(schedulerDO.getClassName(), schedulerDO.getName(), schedulerDO.getGroupName(),
                        schedulerDO.getTriggerName(), schedulerDO.getTriggerGroup(), schedulerDO.getCronExpression())) {
                    SchedulerDO updateSchedulerDO = new SchedulerDO();
                    updateSchedulerDO.setId(schedulerDO.getId());
                    updateSchedulerDO.setJobStatus(SchedulerJobStatusEnum.RUNNING.getValue().byteValue());
                    updateSchedulerDO.setJobStatusTime(DateUtils.currentDate());
                    updateSchedulerDO.setVersion(schedulerDO.getVersion() + 1);
                    schedulerDAO.update(updateSchedulerDO);
                    logger.info("started job: {}", schedulerDO.toString());
                }
            }
        }
    }

    @Autowired
    public void setSchedulerDAO(SchedulerDAO schedulerDAO) {
        super.setBaseDAO(schedulerDAO);
        this.schedulerDAO = schedulerDAO;
    }

    @Autowired
    public void setSchedulerFactoryBean(SchedulerFactoryBean schedulerFactoryBean) {
        this.schedulerFactoryBean = schedulerFactoryBean;
    }

    @PostConstruct
    public void init() {
        super.init(SchedulerDO.class, SchedulerDTO.class);
    }
}
