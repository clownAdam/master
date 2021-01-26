package com.kmmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kmmall.bean.OrderMaster;
import com.kmmall.bean.ProductCategory;
import com.kmmall.dao.ProductCategoryDao;
import com.kmmall.util.JDBCUtil;

public class ProductCategoryDaoImpl implements ProductCategoryDao {

	public List<ProductCategory> selectCategory() throws SQLException {

		Connection connection = JDBCUtil.getConnection();
		try {
			String sql = "select * from product_category";
			PreparedStatement ppst = connection.prepareStatement(sql);
			ResultSet rs = ppst.executeQuery();// 查询结果
			ArrayList<ProductCategory> categorys = new ArrayList();
			// 取每一行的数据
			while (rs.next()) {
				
				String category_id= rs.getString("category_id");
				String category_name= rs.getString("category_name");
				int category_type= rs.getInt("category_type");
				String create_time= rs.getString("create_time");
				String update_time= rs.getString("update_time");
				
				ProductCategory category = new ProductCategory();
				category.setCategory_id(category_id);
				category.setCategory_name(category_name);
				category.setCategory_type(category_type);
				category.setCreate_time(create_time);
				category.setUpdate_time(update_time);
				categorys.add(category);
				
			}
			return categorys;
		} finally {
			connection.close();
		}
	}

}
