package com.personal.crm.web.interceptor;

import com.personal.crm.settings.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * packageName: com.personal.crm.web.interceptor
 * className: LoginInterceptor
 * description:
 *
 * @Author: UltraHerry
 * @Date: 2022/4/22 12:07
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("through the interceptor");

        //验证是否登陆过，验证session.user是否存在
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        boolean ifPass = false;
        if (user != null){
            ifPass = true;
        }else {
            //user为空说明没有登陆过
            //重定向回登陆页面
            /*
                重定向的路径：
                    实际开发中，对于路径，不论前后端一律使用绝对路径
                    转发路径：使用特殊的绝对路径，不加/和项目名，但也是绝对路径
                    重定向路径：使用的是传统绝对路径，需要加上/和项目名
                为何使用重定向
                    转发是一次请求，不会改变请求路径，
                        即如果使用转发，浏览器的顶端路径会停留在“http://127.0.0.1:8080/crm/page/workbench/index”
             */

            response.sendRedirect(request.getContextPath() + "/page/settings/login");
        }


        return ifPass;
    }
}
