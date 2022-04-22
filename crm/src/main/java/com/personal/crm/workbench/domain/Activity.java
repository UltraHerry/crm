package com.personal.crm.workbench.domain;

/**
 * packageName: com.personal.crm.workbench.domain
 * className: Activity
 * description:
 *
 * @Author: UltraHerry
 * @Date: 2022/4/22 15:46
 */
public class Activity {
    private String id;//主键
    private String owner;//市场活动所有者，用户id，外键，关联t_user表的id字段【uuid】
    private String name;//市场活动名称
    private String startDate;//开始日期
    private String endDate;//结束日期
    private String cost;//花销
    private String description;//描述
    private String createTime;//创建时间 yyyy-MM-dd HH-mm-ss
    private String createBy;//创建者
    private String editTime;//编辑时间
    private String editBy;//编辑者

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getEditBy() {
        return editBy;
    }

    public void setEditBy(String editBy) {
        this.editBy = editBy;
    }
}