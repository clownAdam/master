package com.kmmall.service;

import java.sql.SQLException;
import java.util.List;

import com.kmmall.bean.ProductInfo;

public interface HiveQueryService {
	//查询指定用户访问的商品次数最多的前两条商品id
		//select * from uid_pid
		//返回值List集合中存储两条商品id
		public List<ProductInfo> selectHead2ByUid(String uid) throws SQLException, Exception;
}
