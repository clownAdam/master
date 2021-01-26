package com.kmmall.service.impl;

import java.util.List;

import com.kmmall.bean.OrderMaster;
import com.kmmall.dao.OrderMasterDao;
import com.kmmall.dao.impl.OrderMasterDaoImpl;
import com.kmmall.service.OrderMasterService;

public class OrderMasterServiceImpl implements OrderMasterService {
	OrderMasterDao orderMasterDao = new OrderMasterDaoImpl();
	public int insertOrder(OrderMaster order) throws Exception {
		return orderMasterDao.insertOrder(order);
	}

	public List<OrderMaster> selectOrder() throws Exception {
		return orderMasterDao.selectOrder();
	}

	public List<OrderMaster> selectOrderByUserId(int userId) throws Exception {
		return orderMasterDao.selectOrderByUserId(userId);
	}

	public int updateStatus(String orderId, int status) throws Exception {
		return orderMasterDao.updateStatus(orderId, status);
	}

}
