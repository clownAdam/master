package com.kmmall.service;

import java.sql.SQLException;
import java.util.List;

import com.kmmall.bean.AD;

public interface ADService {
	//查询首页的广告
	public List<AD> selectAD() throws SQLException ;
}
