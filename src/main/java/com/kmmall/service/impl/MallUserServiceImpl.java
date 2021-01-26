package com.kmmall.service.impl;

import java.sql.SQLException;

import com.kmmall.bean.MallUser;
import com.kmmall.dao.MallUserDao;
import com.kmmall.dao.impl.MallUserDaoImpl;
import com.kmmall.service.MallUserService;

public class MallUserServiceImpl implements MallUserService {
	MallUserDao mallUserDao = new MallUserDaoImpl();
	public MallUser selectByAP(String account, String password) throws SQLException {
		// TODO Auto-generated method stub
		return mallUserDao.selectByAP(account, password);
	}

	public int insertUser(MallUser user) throws SQLException {
		// TODO Auto-generated method stub
		return mallUserDao.insertUser(user);
	}

	public MallUser selectById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return mallUserDao.selectById(id);
	}

}
