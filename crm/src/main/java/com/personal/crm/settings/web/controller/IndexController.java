package com.personal.crm.settings.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * packageName: com.personal.crm.controller
 * className: IndexController
 * description:
 *
 * @Author: UltraHerry
 * @Date: 2022/4/21 18:55
 */

@Controller
public class IndexController {

    @RequestMapping("/login")
    public String goLogin(){
        return "login";
    }
}
