package com.personal.crm.settings.service.impl;

import com.personal.crm.exception.LoginException;
import com.personal.crm.settings.dao.UserDao;
import com.personal.crm.settings.domain.User;
import com.personal.crm.settings.service.UserService;
import com.personal.crm.utils.DateTimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * packageName: com.personal.crm.settings.service.impl
 * className: UserServiceImpl
 * description:
 *
 * @Author: UltraHerry
 * @Date: 2022/4/21 20:17
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User login(String loginAct, String loginPwd, String ip) throws LoginException{
        Map<String , String> userMes = new HashMap<String , String>();
        userMes.put("loginAct" , loginAct);
        userMes.put("loginPwd" , loginPwd);
        User user = userDao.login(userMes);

        if (user == null){
            throw new LoginException("账户不存在或密码不正确");
        }
        //程序执行到此处说明账号密码正确，继续检测其他信息
        String expireTime = user.getExpireTime();//获取失效时间
        String nowTime = DateTimeUtil.getSysTime();//获取系统时间
        if (nowTime.compareTo(expireTime) < 0){
            /*
             *  a.compareTo(b)原理
             *      若a = “beiJean” ， b = "beiGong"
             *      则会根据a和b中对应字符的字典顺序【即ACILL码】依次对比
             *      如上例，会先对比a中的’b‘字符和b中的’b‘字符
             *      两者相等，于是下一步对比a中的’e‘字符和b中的’e‘字符
             *      两者相等，于是下一步对比a中的’i‘字符和b中的’i‘字符
             *      两者相等，于是下一步对比a中的’J‘字符和b中的’G‘字符
             *      J位于G之后，所以a<b，返回一个负数
             *      因此根据日期大小的规律，可以使用这种方式进行比较大小
             *      如果返回负数说明前者较小，反之较大
             */
            throw new LoginException("账号已失效");
        }
        //程序执行到此处说明账号有效，继续检测其他信息
        if("0".equals(user.getLockState())){
            throw new LoginException("账号被锁定");
        }
        //程序执行到此处说明账号未被锁定，继续检测其他信息
        if (user.getAllowIps() != null && !user.getAllowIps().contains(ip)){
            //allowIps字段的存储格式为”ip1,ip2,...“
            //如果当前ip是该字段的子串，说明允许访问，否则不允许
            throw new LoginException("该ip不允许访问");
        }
        return null;
    }
}
