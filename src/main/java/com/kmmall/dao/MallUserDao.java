package com.kmmall.dao;

import java.sql.SQLException;

import com.kmmall.bean.MallUser;

public interface MallUserDao {
	 //查询，根据帐号密码查询
	public MallUser selectByAP(String account, String password) throws SQLException;
	//注册，新增
	public int insertUser(MallUser user)throws SQLException ;
	//根据id查用户信息
	public MallUser selectById(int id)throws SQLException ;
}
