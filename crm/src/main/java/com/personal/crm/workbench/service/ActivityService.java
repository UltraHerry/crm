package com.personal.crm.workbench.service;

import com.personal.crm.exception.ActivityException;
import com.personal.crm.workbench.domain.Activity;

public interface ActivityService {
    boolean addActivity(Activity activity) throws ActivityException;
}
