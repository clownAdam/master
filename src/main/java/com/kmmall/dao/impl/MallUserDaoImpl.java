package com.kmmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kmmall.bean.MallUser;
import com.kmmall.dao.MallUserDao;
import com.kmmall.util.JDBCUtil;

public class MallUserDaoImpl implements MallUserDao {

	public MallUser selectByAP(String account, String password) throws SQLException {
		Connection connection = JDBCUtil.getConnection();
		String sql = "select * from mall_user where user_account = ? and user_password=?";
		PreparedStatement ppst = connection.prepareStatement(sql);
		ppst.setString(1, account);
		ppst.setString(2, password);
		ResultSet rs = ppst.executeQuery();
		while (rs.next()) {
			int user_id = rs.getInt("user_id");
			String user_name = rs.getString("user_name");
			String user_pic = rs.getString("user_pic");
			String user_sex = rs.getString("user_sex");
			String user_account = rs.getString("user_account");
			String user_password = rs.getString("user_password");

			MallUser user = new MallUser();
			user.setUser_id(user_id);
			user.setUser_name(user_name);
			user.setUser_pic(user_pic);
			user.setUser_sex(user_sex);
			user.setUser_account(user_account);
			user.setUser_password(user_password);
			
			return user;
		}
		return null;
	}

	public int insertUser(MallUser user) throws SQLException {
		Connection connection = JDBCUtil.getConnection();
		String sql = "insert into mall_user(user_name,user_pic,user_sex,user_account,user_password) values(?,?,?,?,?)";
		PreparedStatement ppst = connection.prepareStatement(sql);
		ppst.setString(1, user.getUser_name());
		ppst.setString(2, user.getUser_pic());
		ppst.setString(3, user.getUser_sex());
		ppst.setString(4, user.getUser_account());
		ppst.setString(5, user.getUser_password());
		
		int executeUpdate = ppst.executeUpdate();
		return executeUpdate;
	}

	public MallUser selectById(int id) throws SQLException {
		Connection connection = JDBCUtil.getConnection();
		String sql = "select * from mall_user where user_id = ?";
		PreparedStatement ppst = connection.prepareStatement(sql);
		ResultSet rs = ppst.executeQuery();
		while (rs.next()) {
			int user_id = rs.getInt("user_id");
			String user_name = rs.getString("user_name");
			String user_pic = rs.getString("user_pic");
			String user_sex = rs.getString("user_sex");
			String user_account = rs.getString("user_account ");
			String user_password = rs.getString("user_password");

			MallUser user = new MallUser();
			user.setUser_id(user_id);
			user.setUser_name(user_name);
			user.setUser_pic(user_pic);
			user.setUser_sex(user_sex);
			user.setUser_account(user_account);
			user.setUser_password(user_password);
			
			return user;
		}
		return null;
	}

}
