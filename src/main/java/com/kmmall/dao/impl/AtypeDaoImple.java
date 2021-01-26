package com.kmmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kmmall.bean.Atype;
import com.kmmall.dao.AtypeDao;
import com.kmmall.util.JDBCUtil;

public class AtypeDaoImple implements AtypeDao{

	public boolean insert(Atype atype) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		try {
			String sql = "insert into Atype values(null,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, atype.getName());
			ps.setInt(2, atype.getAid());
			boolean res = ps.execute();
			return res;
		} finally {
			conn.close();
		}
	}

	public boolean delete(int id) {
		return false;
	}

	public List<Atype> select() throws SQLException {
		ArrayList<Atype> list = new ArrayList<Atype>();
		Connection conn = JDBCUtil.getConnection();
		String sql="select * from Atype";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet res = ps.executeQuery();
		while(res.next()) {
			int id = res.getInt("id");
			String name = res.getString("name");
			int aid = res.getInt("aid");
			Atype atype = new Atype(id, name, aid);
			list.add(atype);
		}
		
		return list;
	}

}
