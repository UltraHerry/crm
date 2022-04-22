package com.personal.crm.web.config;

import com.personal.crm.web.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * packageName: com.personal.crm.web.config
 * className: ApplicationConfig
 * description:
 *
 * @Author: UltraHerry
 * @Date: 2022/4/22 12:22
 */

//加此标签表示该类作为配置文件使用
@Configuration
public class ApplicationConfig implements WebMvcConfigurer {
    //WebmvcConfigurer接口表示该类作为SpringMVC的配置文件
    //该接口中封装了很多SpringMVC的相关配置项


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //定义需要拦截的路径
        String[] paths = {"/page/**","/workbench/**" , "/setting/**"};
        //定义不需要拦截的路径
        String[] exceptPath = {"/page/settings/login","/setting/user/login"};
        //创建拦截器对象
        HandlerInterceptor interceptor = new LoginInterceptor();
        registry.addInterceptor(interceptor)
                .addPathPatterns(paths)
                .excludePathPatterns(exceptPath);
    }
}
