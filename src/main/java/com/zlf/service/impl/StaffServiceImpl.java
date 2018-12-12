package com.zlf.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zlf.bo.StaffBo;
import com.zlf.dao.StaffDao;
import com.zlf.service.IStaffService;
@Service
public class StaffServiceImpl implements IStaffService {

	@Resource
	private StaffDao staffDao;
	
	public int deleteByPrimaryKey(String id) {
		int i = staffDao.deleteByPrimaryKey(id);
		return i;
	}

	public int insert(StaffBo record) {
		// TODO Auto-generated method stub
		return staffDao.insert(record);
	}

	public int insertSelective(StaffBo record) {
		// TODO Auto-generated method stub
		return staffDao.insertSelective(record);
	}

	public StaffBo selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return staffDao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(StaffBo record) {
		// TODO Auto-generated method stub
		return staffDao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(StaffBo record) {
		// TODO Auto-generated method stub
		return staffDao.updateByPrimaryKey(record);
	}

	public StaffBo queryOneStaff(StaffBo record) {
		// TODO Auto-generated method stub
		return staffDao.queryOneStaff(record);
	}

}
