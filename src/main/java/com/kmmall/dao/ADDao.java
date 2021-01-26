package com.kmmall.dao;

import java.sql.SQLException;
import java.util.List;

import com.kmmall.bean.AD;

public interface ADDao {
	//查询首页的广告
	public List<AD> selectAD() throws SQLException ;
}
