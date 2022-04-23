package com.personal.crm.workbench.service;

import com.personal.crm.exception.ActivityException;
import com.personal.crm.workbench.domain.Activity;
import com.personal.crm.workbench.vo.PaginationVO;
import com.personal.crm.workbench.vo.QueryConditions;

import java.util.Map;

public interface ActivityService {
    boolean addActivity(Activity activity) throws ActivityException;

    PaginationVO<Activity> getActivityList(QueryConditions conditions);

    boolean deleteActivities(String[] idStr);
}
