package com.personal.crm.workbench.service.impl;

import com.personal.crm.exception.ActivityException;
import com.personal.crm.workbench.dao.ActivityDao;
import com.personal.crm.workbench.domain.Activity;
import com.personal.crm.workbench.service.ActivityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
}
