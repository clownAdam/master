package com.kmmall.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.kmmall.bean.AD;
import com.kmmall.dao.ADDao;
import com.kmmall.dao.impl.ADDaoImpl;
import com.kmmall.service.ADService;

public class ADServiceImpl implements ADService {
	
	ADDao adDao = new ADDaoImpl();
	public List<AD> selectAD() throws SQLException {
		return adDao.selectAD();
	}

}
