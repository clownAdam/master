package com.kmmall.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.kmmall.bean.ProductInfo;
import com.kmmall.dao.ProductInfoDao;
import com.kmmall.dao.impl.ProductInfoDaoImpl;
import com.kmmall.service.ProductInfoService;

public class ProductInfoServiceImpl implements ProductInfoService {
	ProductInfoDao productInfoServiceDao = new ProductInfoDaoImpl();

	@Override
	public int insert(ProductInfo pi) throws SQLException {
		return productInfoServiceDao.insert(pi);
	}
	@Override
	public int insertCart(ProductInfo pi) throws SQLException {
		return productInfoServiceDao.insertCart(pi);
	}

	@Override
	public ProductInfo selectById(String id) throws SQLException {
		return productInfoServiceDao.selectById(id);
	}
	
	@Override
	public  List<ProductInfo> selectAll () throws SQLException {
		return productInfoServiceDao.selectAll();
	}
	@Override
	public  List<ProductInfo> selectCartAll () throws SQLException {
		return productInfoServiceDao.selectCartAll();
	}

	@Override
	public List<ProductInfo> selectByCategory(String type) throws SQLException {
		return productInfoServiceDao.selectByCategory(type);
	}

	@Override
	public List<ProductInfo> selectByKey(String key) throws SQLException {
		return productInfoServiceDao.selectByKey(key);
	}

}
