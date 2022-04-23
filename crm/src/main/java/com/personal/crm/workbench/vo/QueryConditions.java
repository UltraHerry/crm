package com.personal.crm.workbench.vo;

/**
 * packageName: com.personal.crm.workbench.vo
 * className: QueryConditions
 * description:
 *
 * @Author: UltraHerry
 * @Date: 2022/4/23 13:45
 */
public class QueryConditions {
    private Integer pageNo;//页号
    private Integer pageSize;//没页数据数目

    private String name;
    private String owner;
    private String startDate;
    private String endDate;
    private Integer SkipCount;//掠过的记录数，填充到limit的第一个参数，表示从该参数的下一个开始查询
    private String order;
    private String limit;


    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public Integer getSkipCount() {
        return SkipCount;
    }

    public void setSkipCount(Integer skipCount) {
        SkipCount = skipCount;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
}
