package com.kmmall.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface HiveQuery {
	//查询指定用户访问的商品次数最多的前两条商品的 id
	//select * from uid_pid
	//返回值List集合中存储两条商品id
	public List<String> selectHead2ByUid(String uid) throws SQLException, Exception;
	public ArrayList<String> selectOrderMasterHive() throws Exception;
}
