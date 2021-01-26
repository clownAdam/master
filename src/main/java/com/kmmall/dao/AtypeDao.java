package com.kmmall.dao;

import java.sql.SQLException;
import java.util.List;

import com.kmmall.bean.Atype;

public interface AtypeDao {
	public boolean insert(Atype atype) throws SQLException;

	public List<Atype> select() throws SQLException;

	public boolean delete(int id) throws SQLException;
}
