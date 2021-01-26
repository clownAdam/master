package com.kmmall.service;

import java.sql.SQLException;
import java.util.List;

import com.kmmall.bean.ProductCategory;

public interface ProductCategoryService {
	//查所有分类
	public List<ProductCategory> selectCategory() throws SQLException;
}
