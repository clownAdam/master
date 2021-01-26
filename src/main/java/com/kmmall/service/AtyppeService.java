package com.kmmall.service;

import java.sql.SQLException;
import java.util.List;

import com.kmmall.bean.Atype;

public interface AtyppeService {
	public List<Atype> select() throws SQLException; 
}
