package com.kmmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kmmall.bean.AD;
import com.kmmall.bean.OrderMaster;
import com.kmmall.dao.OrderMasterDao;
import com.kmmall.util.JDBCUtil;

public class OrderMasterDaoImpl implements OrderMasterDao {

	public int insertOrder(OrderMaster order) throws SQLException {
		Connection connection = JDBCUtil.getConnection();
		String sql = "insert into order_master values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ppst = connection.prepareStatement(sql);
		ppst.setInt(1, order.getProduct_quantity());
		ppst.setString(2, order.getOrder_id());
		ppst.setString(3, order.getProduct_id());
		ppst.setDouble(4, order.getProduct_price());
		ppst.setString(5, order.getBuyer_name());
		ppst.setString(6, order.getBuyer_phone());
		ppst.setString(7, order.getBuyer_address());
		ppst.setString(8, order.getBuyer_openid());
		ppst.setDouble(9, order.getOrder_amount());
		ppst.setInt(10, order.getOrder_status());
		ppst.setString(11, order.getCreate_time());
		ppst.setString(12, order.getUpdate_time());
		ppst.setInt(13, order.getUser_id());
		ppst.setString(14, order.getProduct_name());

		int executeUpdate = ppst.executeUpdate();
		return executeUpdate;
	}

	public List<OrderMaster> selectOrder() throws SQLException {

		Connection connection = JDBCUtil.getConnection();
		try {
			String sql = "select * from order_master";
			PreparedStatement ppst = connection.prepareStatement(sql);
			ResultSet rs = ppst.executeQuery();// 查询结果
			ArrayList<OrderMaster> orders = new ArrayList();
			// 取每一行的数据
			while (rs.next()) {
				int product_quantity = rs.getInt("product_quantity");
				String order_id = rs.getString("order_id");
				String product_id = rs.getString("product_id");
				double product_price = rs.getDouble("product_price");
				String buyer_name = rs.getString("buyer_name");
				String buyer_phone = rs.getString("buyer_phone");
				String buyer_address = rs.getString("buyer_address");
				String buyer_openid = rs.getString("buyer_openid");
				double order_amount = rs.getDouble("order_amount");
				int order_status = rs.getInt("order_status");
				String create_time = rs.getString("create_time");
				String update_time = rs.getString("update_time");
				int user_id = rs.getInt("user_id");
				String product_name = rs.getString("product_name");

				OrderMaster order = new OrderMaster();
				order.setProduct_quantity(product_quantity);
				order.setOrder_id(order_id);
				order.setProduct_id(product_id);
				order.setProduct_price(product_price);
				order.setBuyer_name(buyer_name);
				order.setBuyer_phone(buyer_phone);
				order.setBuyer_address(buyer_address);
				order.setBuyer_openid(buyer_openid);
				order.setOrder_amount(order_amount);
				order.setOrder_status(order_status);
				order.setCreate_time(create_time);
				order.setUpdate_time(update_time);
				order.setUser_id(user_id);
				order.setProduct_name(product_name);

				orders.add(order);
			}
			return orders;
		} finally {
			connection.close();
		}

	}

	public List<OrderMaster> selectOrderByUserId(int userId) throws SQLException {

		Connection connection = JDBCUtil.getConnection();
		try {
			String sql = "select * from order_master where user_id = ?";
			PreparedStatement ppst = connection.prepareStatement(sql);
			ppst.setInt(1, userId);
			ResultSet rs = ppst.executeQuery();// 查询结果
			ArrayList<OrderMaster> orders = new ArrayList();
			// 取每一行的数据
			while (rs.next()) {
				int product_quantity = rs.getInt("product_quantity");
				String order_id = rs.getString("order_id");
				String product_id = rs.getString("product_id");
				double product_price = rs.getDouble("product_price");
				String buyer_name = rs.getString("buyer_name");
				String buyer_phone = rs.getString("buyer_phone");
				String buyer_address = rs.getString("buyer_address");
				String buyer_openid = rs.getString("buyer_openid");
				double order_amount = rs.getDouble("order_amount");
				int order_status = rs.getInt("order_status");
				String create_time = rs.getString("create_time");
				String update_time = rs.getString("update_time");
				int user_id = rs.getInt("user_id");
				String product_name = rs.getString("product_name");
				OrderMaster order = new OrderMaster();
				order.setProduct_quantity(product_quantity);
				order.setOrder_id(order_id);
				order.setProduct_id(product_id);
				order.setProduct_price(product_price);
				order.setBuyer_name(buyer_name);
				order.setBuyer_phone(buyer_phone);
				order.setBuyer_address(buyer_address);
				order.setBuyer_openid(buyer_openid);
				order.setOrder_amount(order_amount);
				order.setOrder_status(order_status);
				order.setCreate_time(create_time);
				order.setUpdate_time(update_time);
				order.setUser_id(user_id);
				order.setProduct_name(product_name);
				orders.add(order);
			}
			return orders;
		} finally {
			connection.close();
		}

	}

	public int updateStatus(String orderId, int status) throws SQLException {

		Connection connection = JDBCUtil.getConnection();
		String sql = "update order_master set  order_status = ? where order_id = ?";
		PreparedStatement ppst = connection.prepareStatement(sql);
		ppst.setInt(1, status);
		ppst.setString(2, orderId);
		int executeUpdate = ppst.executeUpdate();
		return executeUpdate;
	}

}
