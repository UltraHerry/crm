package com.personal.crm.settings.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/page/settings")
public class SettingsController {

    @RequestMapping("/login")
    public String goLogin(){
        return "login";
    }
    @RequestMapping("/index")
    public String goSettingsIndex(){
        return "settings/index";
    }

    @RequestMapping("/{directory}/{page}")
    public String goTwoLevelPage(@PathVariable String directory, @PathVariable String page){
        return "settings/" + directory + "/" + page;
    }

    @RequestMapping("/{directory01}/{directory02}/{page}")
    public String goThreeLevelPage(@PathVariable String directory01, @PathVariable String directory02,
                                   @PathVariable String page){
        return "settings/" + directory01 + "/" + directory02 + "/" + page;
    }
}
