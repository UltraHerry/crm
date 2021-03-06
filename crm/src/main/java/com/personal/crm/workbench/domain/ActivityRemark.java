package com.personal.crm.workbench.domain;

/**
 * packageName: com.personal.crm.workbench.domain
 * className: ActivityRemark
 * description:
 *
 * @Author: UltraHerry
 * @Date: 2022/4/22 15:46
 */
public class ActivityRemark {
    private String id;//
    private String noteContent;//备注信息
    private String createTime;//
    private String createBy;//
    private String editTime;//
    private String editBy;//
    private String editFlag;//是否修改过
    private String activityId;//

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
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

    public String getEditFlag() {
        return editFlag;
    }

    public void setEditFlag(String editFlag) {
        this.editFlag = editFlag;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }
}
