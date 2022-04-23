package com.personal.crm.workbench.web.controller;

import com.personal.crm.exception.ActivityException;
import com.personal.crm.settings.domain.User;
import com.personal.crm.settings.service.UserService;
import com.personal.crm.utils.DateTimeUtil;
import com.personal.crm.utils.UUIDUtil;
import com.personal.crm.workbench.domain.Activity;
import com.personal.crm.workbench.service.ActivityService;
import com.personal.crm.workbench.vo.PaginationVO;
import com.personal.crm.workbench.vo.QueryConditions;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/info")
    public Object getActivity(QueryConditions conditions){
        Integer pageNO = conditions.getPageNo();
        Integer pageSize = conditions.getPageSize();
        //计算略过的记录数，即limit的第一个参数，填充到
        Integer skipCount = (pageNO-1)*pageSize;
        conditions.setSkipCount(skipCount);
        conditions.setOrder("desc");//设置降序
        conditions.setLimit("yes");
        /*
            前端需要两组数据
                记录总条数
                数据list
            由于分页查询用途广泛，我们可以使用VO类封装数据：PaginationVO<T>,T为泛型
         */
        PaginationVO<Activity> res = activityService.getActivityList(conditions);
        return res;
    }

    @DeleteMapping("/info")
    public Object deleteInfo(String ids){
        String[] idStr = ids.split(",");

        boolean success = activityService.deleteActivities(idStr);
        Map<String ,Boolean> res = new HashMap<>();
        res.put("success" , success);
        return res;
    }

    @GetMapping("/info/{id}")
    public Object getActivityById(@PathVariable String id){
        Activity activity = new Activity();

        return activity;
    }

    @PutMapping("/info")
    public  Object updateInfo(Activity activity){
        return new Activity();
    }
}
