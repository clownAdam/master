package com.kmmall.dao;

import java.util.List;

import com.kmmall.bean.OrderMaster;

public interface OrderMasterDao {
	//新增
	public int insertOrder(OrderMaster order) throws Exception;
	//查询所有订单
	public List<OrderMaster> selectOrder() throws Exception;
	//根据用户id查订单
	public List<OrderMaster> selectOrderByUserId(int userId) throws Exception;
	//订单状态，我们使用数字来表示，0 ：新下单，-1：表示订单取消，1：发货，2：收获
	public int updateStatus(String orderId, int status) throws Exception;
}
