package com.personal.crm.settings.dao;


import com.personal.crm.settings.domain.User;

import java.util.Map;

public interface UserDao {
    User login(Map<String, String> userMes);
}
