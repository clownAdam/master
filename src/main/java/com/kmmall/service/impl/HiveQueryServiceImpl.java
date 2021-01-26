package com.kmmall.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kmmall.bean.OrderMaster;
import com.kmmall.bean.ProductInfo;
import com.kmmall.dao.ProductInfoDao;
import com.kmmall.dao.impl.HiveQueryImpl;
import com.kmmall.dao.impl.ProductInfoDaoImpl;
import com.kmmall.service.HiveQueryService;

public class HiveQueryServiceImpl implements HiveQueryService {
//查询访问排名头两条的商品信息，返回List集合
	public List<ProductInfo> selectHead2ByUid(String uid) throws SQLException, Exception {
		// 调用调用Dao层的HiveQuery，查询出访问排名头两条的商品id
		HiveQueryImpl hiveQuery = new HiveQueryImpl();
		List<String> pids = hiveQuery.selectHead2ByUid(uid);
		// 查出的Product信息放到list集合中
		ArrayList<ProductInfo> products = new ArrayList();
		// 如果没有访问商品的信息，则直接返回一个空的集合即可
		if (pids == null || pids.size() <2) {
			return products;
		}
//		调用ProductInfoDao,按照pid查询product信息
		ProductInfoDao productInfoDao = new ProductInfoDaoImpl();

		ProductInfo p1 = productInfoDao.selectById(pids.get(0));
		ProductInfo p2 = productInfoDao.selectById(pids.get(1));

		products.add(p1);
		products.add(p2);

		return products;
	}

	public List<ProductInfo> selectOrderMasterHive() throws SQLException {
		// 调用调用Dao层的HiveQuery，查询出访问排名头两条的商品id
				HiveQueryImpl hiveQuery = new HiveQueryImpl();
				List<String> pids = hiveQuery.selectOrderMasterHive();
				// 查出的Product信息放到list集合中
				ArrayList<ProductInfo> products = new ArrayList();
				// 如果没有访问商品的信息，则直接返回一个空的集合即可
//				if (pids == null || pids.size() <6) {
//					return products;
//				}
				ProductInfoDao productInfoDao = new ProductInfoDaoImpl();
				for(int i = 0;i<pids.size();i++) {
					ProductInfo p0 = productInfoDao.selectById(pids.get(i));
					System.out.println("p0:"+p0);
					products.add(p0);
				}
//				调用ProductInfoDao,按照pid查询product信息
				return products;
	}

}
