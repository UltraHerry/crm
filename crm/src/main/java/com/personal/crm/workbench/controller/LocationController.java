package com.personal.crm.workbench.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * packageName: com.personal.crm.workbench.controller
 * className: LocationController
 * description:
 *
 * @Author: UltraHerry
 * @Date: 2022/4/22 0:01
 */

@Controller
public class LocationController {

    @RequestMapping("/workbench/index")
    public String goWorkbench(){
        return "/workbench/index";
    }
}
