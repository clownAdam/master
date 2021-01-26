package com.kmmall.dao;

import java.sql.SQLException;
import java.util.List;

import com.kmmall.bean.ProductCategory;

public interface ProductCategoryDao {
	//查所有分类
	public List<ProductCategory> selectCategory() throws SQLException;
}
