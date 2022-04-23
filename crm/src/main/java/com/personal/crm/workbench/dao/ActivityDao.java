package com.personal.crm.workbench.dao;

import com.personal.crm.workbench.domain.Activity;
import com.personal.crm.workbench.vo.QueryConditions;

import java.util.List;
import java.util.Map;

public interface ActivityDao {
    int addActivity(Activity activity);

    Integer getActivityTotal(QueryConditions conditions);

    List<Activity> getActivity(QueryConditions conditions);

    Integer deleteActivitiesByIds(String[] idStr);
}
