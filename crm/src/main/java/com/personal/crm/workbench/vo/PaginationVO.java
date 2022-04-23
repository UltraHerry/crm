package com.personal.crm.workbench.vo;

import java.util.List;

/**
 * packageName: com.personal.crm.workbench.vo
 * className: PaginationVO
 * description:
 *
 * @Author: UltraHerry
 * @Date: 2022/4/23 14:01
 */
public class PaginationVO<T> {
    private Integer total;//记录总条数
    private List<T> dataList;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
