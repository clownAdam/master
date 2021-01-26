package com.kmmall.dao;

import java.sql.SQLException;
import java.util.List;

import com.kmmall.bean.ProductInfo;

/**
 * 增删改查
 * @author Administrator
 *
 */
public interface ProductInfoDao {
	public int insert(ProductInfo pi) throws SQLException;
	//查询单个商品
	public ProductInfo selectById(String id)throws SQLException;
	//查询分类商品
	public List<ProductInfo> selectByCategory(String type)throws SQLException;
	//模糊查询
	public  List<ProductInfo> selectByKey(String key)throws SQLException;
	public List<ProductInfo> selectAll() throws SQLException;
}
