package com.personal.crm.settings.web.controller;

import com.personal.crm.settings.domain.User;
import com.personal.crm.settings.service.UserService;
import com.personal.crm.utils.MD5Util;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * packageName: com.personal.crm.settings.web.controller
 * className: UserController
 * description:
 *
 * @Author: UltraHerry
 * @Date: 2022/4/21 22:57
 */

@RestController
@RequestMapping(path = "/setting/user")
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/login")
    public Object login(String loginAct , String loginPwd ,
                        HttpServletRequest request ,HttpSession session){
        Map<String , Object> res = new HashMap<>();
        //密码加密
        loginPwd = MD5Util.getMD5(loginPwd);
        //获取登录方的ip
        String ip = request.getRemoteAddr();
        User user = null;
        try{
            user = userService.login(loginAct , loginPwd , ip);
            //业务层出错抛出自定义异常，程序执行到此处说明业务层运行正常没有异常发生，也就是user不可能为0
            //使用session保存用户信息，返回信息为{"success":true}
            session.setAttribute("user" , user);

            //System.out.println(session.getAttribute("user").toString());
            res.put("success" , true);
        }catch (Exception e){
            e.printStackTrace();

            //注意，如果使用了事务
            //出错，返回失败即错误消息
            res.put("success" , false);
            res.put("msg" , e.getMessage());
        }


        return res;
    }
}
