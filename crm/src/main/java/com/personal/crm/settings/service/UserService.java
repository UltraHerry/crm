package com.personal.crm.settings.service;

import com.personal.crm.exception.LoginException;
import com.personal.crm.settings.domain.User;

import java.util.List;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<User> getUserList();
}
