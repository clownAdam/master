package com.kmmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kmmall.bean.AD;
import com.kmmall.dao.ADDao;
import com.kmmall.util.JDBCUtil;

public class ADDaoImpl implements ADDao {
	public static void main(String[] args) throws SQLException {
		ADDaoImpl adDaoImpl = new ADDaoImpl();
		List<AD> selectAD = adDaoImpl.selectAD();
		System.out.println(selectAD);
	}
	

	public List<AD> selectAD() throws SQLException {
		Connection connection = JDBCUtil.getConnection();
		try {
			String sql = "select * from ad";
			PreparedStatement ppst = connection.prepareStatement(sql);
			ResultSet rs = ppst.executeQuery();//查询结果
			ArrayList<AD> ads = new ArrayList();
			//取每一行的数据
			while (rs.next()) {
				String ad_id = rs.getString("ad_id");
				String ad_lv = rs.getString("ad_lv");
				String ad_pic = rs.getString("ad_pic");
				String ad_product_id = rs.getString("ad_product_id");

				AD ad = new AD();
				ad.setAd_id(ad_id);
				ad.setAd_lv(ad_lv);
				ad.setAd_pic(ad_pic);
				ad.setAd_product_id(ad_product_id);

				ads.add(ad);
			}
			return ads;
		} finally {
			connection.close();
		}
	}

}
