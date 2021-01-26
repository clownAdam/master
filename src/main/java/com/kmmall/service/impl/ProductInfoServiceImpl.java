package com.kmmall.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.kmmall.bean.ProductInfo;
import com.kmmall.dao.ProductInfoDao;
import com.kmmall.dao.impl.ProductInfoDaoImpl;
import com.kmmall.service.ProductInfoService;

public class ProductInfoServiceImpl implements ProductInfoService {
	ProductInfoDao productInfoServiceDao = new ProductInfoDaoImpl();

	public int insert(ProductInfo pi) throws SQLException {
		return productInfoServiceDao.insert(pi);
	}

	public ProductInfo selectById(String id) throws SQLException {
		return productInfoServiceDao.selectById(id);
	}
	
	public  List<ProductInfo> selectAll () throws SQLException {
		return productInfoServiceDao.selectAll();
	}

	public List<ProductInfo> selectByCategory(String type) throws SQLException {
		return productInfoServiceDao.selectByCategory(type);
	}

	public List<ProductInfo> selectByKey(String key) throws SQLException {
		return productInfoServiceDao.selectByKey(key);
	}

}
