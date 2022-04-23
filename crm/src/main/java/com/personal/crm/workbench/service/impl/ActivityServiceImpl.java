package com.personal.crm.workbench.service.impl;

import com.personal.crm.exception.ActivityException;
import com.personal.crm.workbench.dao.ActivityDao;
import com.personal.crm.workbench.dao.ActivityRemarkDao;
import com.personal.crm.workbench.domain.Activity;
import com.personal.crm.workbench.service.ActivityService;
import com.personal.crm.workbench.vo.PaginationVO;
import com.personal.crm.workbench.vo.QueryConditions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * packageName: com.personal.crm.workbench.service.impl
 * className: ActivityServiceImpl
 * description:
 *
 * @Author: UltraHerry
 * @Date: 2022/4/22 16:01
 */

@Service
public class ActivityServiceImpl implements ActivityService {

    @Resource
    private ActivityDao activityDao;

    @Resource
    private ActivityRemarkDao activityRemarkDao;

    @Transactional(
            isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED
    )
    @Override
    public boolean addActivity(Activity activity) throws ActivityException{
        boolean flag = false;
        int count = activityDao.addActivity(activity);

        if (count == 1){
            flag = true;
        }else {
            throw new ActivityException("添加失败");
        }
        return flag;
    }

    @Transactional(
            isolation = Isolation.DEFAULT,
            propagation = Propagation.SUPPORTS
    )
    @Override
    public PaginationVO<Activity> getActivityList(QueryConditions conditions) {
        //获取total
        Integer total = activityDao.getActivityTotal(conditions);

        //获取datalist
        List<Activity> activities = activityDao.getActivity(conditions);

        //封装进vo
        PaginationVO<Activity> vo = new PaginationVO<>();
        vo.setTotal(total);
        vo.setDataList(activities);
        //返回vo
        return vo;
    }

    @Transactional(
            isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED
    )
    @Override
    public boolean deleteActivities(String[] idStr) {
        boolean flag = true;
        //难点在于备注信息activity_remark的连携删除
        //查询出需要删除的备注的数量
        Integer count = activityRemarkDao.getCountByIds(idStr);

        //删除备注，返回实际删除的备注数量
        Integer delRemarksCount = activityRemarkDao.deleteRemarksByIds(idStr);
        if (count != delRemarksCount){
            flag = false;
        }

        //删除市场活动
        Integer delActivitiyCount = activityDao.deleteActivitiesByIds(idStr);

        if (delActivitiyCount != idStr.length){
            flag = false;
        }
        return flag;
    }
}
