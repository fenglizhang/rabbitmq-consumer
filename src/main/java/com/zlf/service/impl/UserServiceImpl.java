package com.zlf.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zlf.bo.UserBo;
import com.zlf.dao.UserDao;
import com.zlf.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	@Resource
	private UserDao ud;
	
	@Override
	public int deleteByPrimaryKey(String userid) {
		// TODO Auto-generated method stub
		return ud.deleteByPrimaryKey(userid);
	}

	@Override
	public int insert(UserBo record) {
		// TODO Auto-generated method stub
		return ud.insert(record);
	}

	@Override
	public int insertSelective(UserBo record) {
		// TODO Auto-generated method stub
		return ud.insertSelective(record);
	}

	@Override
	public UserBo selectByPrimaryKey(String userid) {
		// TODO Auto-generated method stub
		return ud.selectByPrimaryKey(userid);
	}

	@Override
	public int updateByPrimaryKeySelective(UserBo record) {
		// TODO Auto-generated method stub
		return ud.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(UserBo record) {
		// TODO Auto-generated method stub
		return ud.updateByPrimaryKey(record);
	}

	@Override
	public UserBo queryByPwdAndUsername(UserBo ub) {
		// TODO Auto-generated method stub
		return ud.queryByPwdAndUsername(ub);
	}

}
