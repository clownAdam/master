package com.kmmall.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.kmmall.bean.Atype;
import com.kmmall.dao.AtypeDao;
import com.kmmall.dao.impl.AtypeDaoImple;
import com.kmmall.service.AtyppeService;

public class AtypeServiceImpl implements AtyppeService{
	private AtypeDao atypeDao=new AtypeDaoImple();
	public List<Atype> select() throws SQLException {
		return atypeDao.select();
	}

}
