package com.zlf.dao;

import com.zlf.bo.StaffBo;

public interface StaffDao {
    int deleteByPrimaryKey(String id);

    int insert(StaffBo record);

    int insertSelective(StaffBo record);

    StaffBo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StaffBo record);

    int updateByPrimaryKey(StaffBo record);
    
    StaffBo queryOneStaff(StaffBo record);
}