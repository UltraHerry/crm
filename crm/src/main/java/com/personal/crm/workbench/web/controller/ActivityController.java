package com.personal.crm.workbench.web.controller;

import com.personal.crm.exception.ActivityException;
import com.personal.crm.settings.domain.User;
import com.personal.crm.settings.service.UserService;
import com.personal.crm.utils.DateTimeUtil;
import com.personal.crm.utils.UUIDUtil;
import com.personal.crm.workbench.domain.Activity;
import com.personal.crm.workbench.service.ActivityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName: com.personal.crm.workbench.web.controller
 * className: ActivityController
 * description:
 *
 * @Author: UltraHerry
 * @Date: 2022/4/22 16:04
 */

@RestController
@RequestMapping("workbench/activity")
public class ActivityController {

    @Resource
    UserService userService;

    @Resource
    ActivityService activityService;

    @GetMapping("/userList")
    public Object getUserList(){
        List<User> userList = userService.getUserList();

        return userList;
    }

    @PostMapping("/info")
    public Object addActivity(Activity activity , HttpSession session){
        activity.setId(UUIDUtil.getUUID());
        activity.setCreateBy(((User)session.getAttribute("user")).getName());
        activity.setCreateTime(DateTimeUtil.getSysTime());
        Map<String , Object> res = new HashMap<>();

        boolean success = false;
        try {
            success = activityService.addActivity(activity);
        } catch (ActivityException e) {
            e.printStackTrace();
            res.put("error", e.getMessage());
        }

        res.put("success", success);
        return res;
    }
}
