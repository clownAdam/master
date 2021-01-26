package com.kmmall.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kmmall.bean.OrderMaster;
import com.kmmall.bean.ProductInfo;
import com.kmmall.dao.HiveQuery;
import com.kmmall.dao.ProductInfoDao;
import com.kmmall.util.HiveUtil;

public class HiveQueryImpl implements HiveQuery {

	// 查询指定uid用户的访问记录次数最多的前两个商品信息
//	public List<String> selectHead2ByUid(String uid) throws Exception {
//		Connection conn = HiveUtil.getConnection();
//		Statement stmt = conn.createStatement();
//
//		String sql = "select pid ,count(*)  c from (Select uid,pid from uid_pid where uid = "
//				+ uid + " )t1 group by pid order by c desc limit 2";
//		System.out.println("Running:" + sql);
//		ResultSet res = stmt.executeQuery(sql);
//		ArrayList<String> arrayList = new ArrayList();
//		while (res.next()) {
//			// 保存商品id
//			arrayList.add(res.getString(1));
//		}
//		return arrayList;
	public List<String> selectHead2ByUid(String uid) throws Exception {
		String tempuid = null;
		Connection conn = HiveUtil.getConnection();
		Statement stmt = conn.createStatement();

		String sql = "select pid ,count(*)  c from (Select uid,pid from uid_pid where uid = " + uid
				+ " )t1 group by pid order by c desc limit 2";
		if (tempuid != uid) {

			System.out.println("Running:" + sql);
		}
		ResultSet res = stmt.executeQuery(sql);
		ArrayList<String> arrayList = new ArrayList();
		while (res.next()) {
			// 保存商品id
			arrayList.add(res.getString(1));
		}
		return arrayList;

	}

	public static void main(String[] args) throws Exception {
		HiveQueryImpl hive = new HiveQueryImpl();
		// List<String> selectHead2ByUid = hive.selectHead2ByUid("11");
		ArrayList<String> selectOrderMasterHive = hive.selectOrderMasterHive();
		System.out.println(selectOrderMasterHive);
		// 如果没有访问商品的信息，则直接返回一个空的集合即可
		// if (pids == null || pids.size() <6) {
		// return products;
		// }
		ProductInfoDao productInfoDao = new ProductInfoDaoImpl();
		for (int i = 0; i < selectOrderMasterHive.size(); i++) {
			ProductInfo p0 = productInfoDao.selectById(selectOrderMasterHive.get(i));
			System.out.println("p0:" + p0);
		}

		// System.out.println(selectHead2ByUid);
	}

	public ArrayList<String> selectOrderMasterHive() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = HiveUtil.getConnection();
		Statement stmt = conn.createStatement();

		String sql = "select product_id,product_name,count(*) c  from order_master group by product_id,product_name order by c desc limit 6";
		System.out.println("Running:" + sql);
		ResultSet res = stmt.executeQuery(sql);
		ArrayList<String> arrayList = new ArrayList();
		while (res.next()) {
			// 保存商品id
			arrayList.add(res.getString(1));
		}
		return arrayList;

	}

}
