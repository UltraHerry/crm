package com.personal.crm.workbench.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * packageName: com.personal.crm.workbench.controller
 * className: LocationController
 * description:
 *
 * @Author: UltraHerry
 * @Date: 2022/4/22 0:01
 */

@Controller("wbLocationController")
@RequestMapping("/page/workbench")
public class WorkbenchController {

    @RequestMapping("/index")
    public String goWorkbench(){
        return "index";
    }


    @RequestMapping("/{directory}/{page}")
    public String goTwoLevelPage(@PathVariable String directory, @PathVariable String page){
        return "workbench/" + directory + "/" + page;
    }

    @RequestMapping("/{directory01}/{directory02}/{page}")
    public String goThreeLevelPage(@PathVariable String directory01, @PathVariable String directory02,
                                   @PathVariable String page){
        return "workbench/" + directory01 + "/" + directory02 + "/" + page;
    }
}
