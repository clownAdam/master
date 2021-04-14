package com.kmmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kmmall.bean.ProductInfo;
import com.kmmall.dao.ProductInfoDao;
import com.kmmall.util.JDBCUtil;

public class ProductInfoDaoImpl implements ProductInfoDao {

	public int insert(ProductInfo pi) throws SQLException {
		Connection connection = JDBCUtil.getConnection();
		try {
			String sql = "insert into product_info values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ppst = connection.prepareStatement(sql);
			ppst.setString(1, pi.getProduct_id());
			ppst.setString(2, pi.getProduct_name());
			ppst.setDouble(3, pi.getProduct_price());
			ppst.setInt(4, pi.getProduct_stock());
			ppst.setString(5, pi.getProduct_description());
			ppst.setString(6, pi.getProduct_icon());
			ppst.setString(7, pi.getCategory_type());
			ppst.setString(8, pi.getCreate_time());
			ppst.setString(9, pi.getUpdate_time());
			int executeUpdate = ppst.executeUpdate();
			return executeUpdate;
		} finally {
			connection.close();
		}
	}

	public ProductInfo selectById(String id) throws SQLException {
		Connection connection = JDBCUtil.getConnection();
		try {
			String sql = "select * from product_info where product_id = ?";
			PreparedStatement ppst = connection.prepareStatement(sql);
			ppst.setString(1, id);
			ResultSet rs = ppst.executeQuery();
			while (rs.next()) {
				String product_id = rs.getString("product_id");
				String product_name = rs.getString("product_name");
				double product_price = rs.getDouble("product_price");
				int product_stock = rs.getInt("product_stock");
				String product_description = rs.getString("product_description");
				String product_icon = rs.getString("product_icon");
				String category_type = rs.getString("category_type");
				String create_time = rs.getString("create_time");
				String update_time = rs.getString("update_time");

				ProductInfo productInfo = new ProductInfo();
				productInfo.setProduct_id(product_id);
				productInfo.setProduct_name(product_name);
				productInfo.setProduct_price(product_price);
				productInfo.setProduct_stock(product_stock);
				productInfo.setProduct_description(product_description);
				productInfo.setProduct_icon(product_icon);
				productInfo.setCategory_type(category_type);
				productInfo.setCreate_time(create_time);
				productInfo.setUpdate_time(update_time);

				return productInfo;
			}
			return null;
		} finally {
			connection.close();
		}
	}

	public List<ProductInfo> selectByCategory(String type) throws SQLException {
		Connection connection = JDBCUtil.getConnection();
		ArrayList<ProductInfo> products = new ArrayList();
		try {
			String sql = "select * from product_info where category_type = ?";
			PreparedStatement ppst = connection.prepareStatement(sql);
			ppst.setString(1, type);
			ResultSet rs = ppst.executeQuery();
			while (rs.next()) {
				String product_id = rs.getString("product_id");
				String product_name = rs.getString("product_name");
				double product_price = rs.getDouble("product_price");
				int product_stock = rs.getInt("product_stock");
				String product_description = rs.getString("product_description");
				String product_icon = rs.getString("product_icon");
				String category_type = rs.getString("category_type");
				String create_time = rs.getString("create_time");
				String update_time = rs.getString("update_time");

				ProductInfo productInfo = new ProductInfo();
				productInfo.setProduct_id(product_id);
				productInfo.setProduct_name(product_name);
				productInfo.setProduct_price(product_price);
				productInfo.setProduct_stock(product_stock);
				productInfo.setProduct_description(product_description);
				productInfo.setProduct_icon(product_icon);
				productInfo.setCategory_type(category_type);
				productInfo.setCreate_time(create_time);
				productInfo.setUpdate_time(update_time);

				products.add(productInfo);
			}
		} finally {
			connection.close();
		}
		return products;
	}

	public List<ProductInfo> selectByKey(String key) throws SQLException {
		Connection connection = JDBCUtil.getConnection();
		ArrayList<ProductInfo> products = new ArrayList();
		try {
			String sql = "select * from product_info where product_name like ?";
			PreparedStatement ppst = connection.prepareStatement(sql);
			ppst.setString(1, "%" + key + "%");
			ResultSet rs = ppst.executeQuery();
			while (rs.next()) {
				String product_id = rs.getString("product_id");
				String product_name = rs.getString("product_name");
				double product_price = rs.getDouble("product_price");
				int product_stock = rs.getInt("product_stock");
				String product_description = rs.getString("product_description");
				String product_icon = rs.getString("product_icon");
				String category_type = rs.getString("category_type");
				String create_time = rs.getString("create_time");
				String update_time = rs.getString("update_time");

				ProductInfo productInfo = new ProductInfo();
				productInfo.setProduct_id(product_id);
				productInfo.setProduct_name(product_name);
				productInfo.setProduct_price(product_price);
				productInfo.setProduct_stock(product_stock);
				productInfo.setProduct_description(product_description);
				productInfo.setProduct_icon(product_icon);
				productInfo.setCategory_type(category_type);
				productInfo.setCreate_time(create_time);
				productInfo.setUpdate_time(update_time);

				products.add(productInfo);
			}
		} finally {
			connection.close();
		}
		return products;
	}

	public List<ProductInfo> selectAll() throws SQLException {
		Connection connection = JDBCUtil.getConnection();
		ArrayList<ProductInfo> products = new ArrayList();
		try {
			String sql = "select * from product_info ";
			PreparedStatement ppst = connection.prepareStatement(sql);
			ResultSet rs = ppst.executeQuery();
			while (rs.next()) {
				String product_id = rs.getString("product_id");
				String product_name = rs.getString("product_name");
				double product_price = rs.getDouble("product_price");
				int product_stock = rs.getInt("product_stock");
				String product_description = rs.getString("product_description");
				String product_icon = rs.getString("product_icon");
				String category_type = rs.getString("category_type");
				String create_time = rs.getString("create_time");
				String update_time = rs.getString("update_time");

				ProductInfo productInfo = new ProductInfo();
				productInfo.setProduct_id(product_id);
				productInfo.setProduct_name(product_name);
				productInfo.setProduct_price(product_price);
				productInfo.setProduct_stock(product_stock);
				productInfo.setProduct_description(product_description);
				productInfo.setProduct_icon(product_icon);
				productInfo.setCategory_type(category_type);
				productInfo.setCreate_time(create_time);
				productInfo.setUpdate_time(update_time);

				products.add(productInfo);
			}
		} finally {
			connection.close();
		}
		return products;
	}
	public List<ProductInfo> selectAllByCart() throws SQLException {
		Connection connection = JDBCUtil.getConnection();
		ArrayList<ProductInfo> products = new ArrayList();
		try {
			String sql = "select * from product_cart ";
			PreparedStatement ppst = connection.prepareStatement(sql);
			ResultSet rs = ppst.executeQuery();
			while (rs.next()) {
				String product_id = rs.getString("product_id");
				String product_name = rs.getString("product_name");
				double product_price = rs.getDouble("product_price");
				int product_stock = rs.getInt("product_stock");
				String product_description = rs.getString("product_description");
				String product_icon = rs.getString("product_icon");
				String category_type = rs.getString("category_type");
				String create_time = rs.getString("create_time");
				String update_time = rs.getString("update_time");

				ProductInfo productInfo = new ProductInfo();
				productInfo.setProduct_id(product_id);
				productInfo.setProduct_name(product_name);
				productInfo.setProduct_price(product_price);
				productInfo.setProduct_stock(product_stock);
				productInfo.setProduct_description(product_description);
				productInfo.setProduct_icon(product_icon);
				productInfo.setCategory_type(category_type);
				productInfo.setCreate_time(create_time);
				productInfo.setUpdate_time(update_time);

				products.add(productInfo);
			}
		} finally {
			connection.close();
		}
		return products;
	}
}
