package com.personal.crm.workbench.dao;

public interface ActivityRemarkDao {
    Integer getCountByIds(String[] idStr);

    Integer deleteRemarksByIds(String[] idStr);
}
