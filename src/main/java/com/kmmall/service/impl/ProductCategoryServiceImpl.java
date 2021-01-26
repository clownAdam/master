package com.kmmall.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.kmmall.bean.ProductCategory;
import com.kmmall.dao.ProductCategoryDao;
import com.kmmall.dao.impl.ProductCategoryDaoImpl;
import com.kmmall.service.ProductCategoryService;

public class ProductCategoryServiceImpl implements ProductCategoryService {
	ProductCategoryDao productCategoryDao = new ProductCategoryDaoImpl();
	public List<ProductCategory> selectCategory() throws SQLException {
		return productCategoryDao.selectCategory();
	}

}
