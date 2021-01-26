package com.kmmall.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kmmall.bean.AD;
import com.kmmall.bean.MallUser;
import com.kmmall.bean.ProductCategory;
import com.kmmall.bean.ProductInfo;
import com.kmmall.service.ProductInfoService;
import com.kmmall.service.impl.ADServiceImpl;
import com.kmmall.service.impl.HiveQueryServiceImpl;
import com.kmmall.service.impl.ProductCategoryServiceImpl;
import com.kmmall.service.impl.ProductInfoServiceImpl;
import com.kmmall.util.JDBCUtil;

/*
 * http协议：超文本传输协议
 * 		请求头、请求行、请求体
 * 	请求方式：
 * 		get  post  put delete head .......
 * get:参数位于地址中，并且传输的参数有大小限制，不安全
 * post:参数位于请求体中，不在地址栏中，并且没有大小限制，安全
 * 
 * 当请求servlet时，请求交给service方法去处理。
 * 在Servlet的子类HttpServlet中，扩展Http功能，可以根据不同的请求，来划分不同的处理方法：
 * 	get请求：doGet（）
 * post请求：doPost（）
 * put请求：doPut（）
 * 
 */
//首页Servlet
@WebServlet("/index.do") // 声明Servlet，并指定请求路径
public class IndexServlet extends HttpServlet {
	HiveQueryServiceImpl hiveQueryServiceImpl = new HiveQueryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 查询分类
			ProductCategoryServiceImpl categoryService = new ProductCategoryServiceImpl();
			List<ProductCategory> selectCategory = categoryService.selectCategory();
//			// 查询广告
			ADServiceImpl adService = new ADServiceImpl();
			List<AD> selectAD = adService.selectAD();

//	查询推荐内容  预留大数据实现
			List<ProductInfo> head2Product = new ArrayList<ProductInfo>();
			List<ProductInfo> product = new ArrayList<ProductInfo>();
//			// 如果用户已登录，则推荐，如果用户未登录，则不推荐
			Object attribute = req.getSession().getAttribute("user_info");
			List<ProductInfo> selectOrderMasterHive = new ArrayList();
			MallUser user = (MallUser) attribute;
			if (attribute != null) {
				System.out.println("user_info is null");
				String sql = "select * from product_info where user_id=? order by rand() limit 4";
				Connection con = JDBCUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, user.getUser_id());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String product_name = rs.getString("product_name");
					String product_icon = rs.getString("product_icon");
					String product_id = rs.getString("product_id");
					Double product_price = rs.getDouble("product_price");
					ProductInfo productInfo1 = new ProductInfo();
					productInfo1.setProduct_icon(product_icon);
					productInfo1.setProduct_name(product_name);
					productInfo1.setProduct_id(product_id);
					productInfo1.setProduct_price(product_price);
					head2Product.add(productInfo1);
				}
//				MallUser user = (MallUser) attribute;
//				System.out.println("user_info:" + user);
				head2Product = hiveQueryServiceImpl.selectHead2ByUid(user.getUser_id() + "");
////				查询销量列表 预留大数据实现
//				selectOrderMasterHive = hiveQueryServiceImpl.selectOrderMasterHive();
//				System.out.println("selectOrderMasterHive:" + selectOrderMasterHive);
//				req.setAttribute("orderHive", selectOrderMasterHive);
			} else {
				System.out.println("user_info is null");
				String sql = "select * from product_info order by rand() limit 4";
				Connection con = JDBCUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
//				MallUser user = (MallUser) attribute;
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String product_name = rs.getString("product_name");
					String product_icon = rs.getString("product_icon");
					String product_id = rs.getString("product_id");
					Double product_price = rs.getDouble("product_price");
					ProductInfo productInfo1 = new ProductInfo();
					productInfo1.setProduct_icon(product_icon);
					productInfo1.setProduct_name(product_name);
					productInfo1.setProduct_id(product_id);
					productInfo1.setProduct_price(product_price);
					head2Product.add(productInfo1);
				}

////			查询销量列表 预留大数据实现				
				Connection connection = JDBCUtil.getConnection();
				try {
					String sql1 = "select * from product_info order by rand() limit 6";
//					SELECT * FROM table ORDER BY RAND() LIMIT 5;
					PreparedStatement ppst = connection.prepareStatement(sql1);
					ResultSet rs1 = ppst.executeQuery();
					while (rs1.next()) {
						String product_id = rs1.getString("product_id");
						String product_name = rs1.getString("product_name");
						double product_price = rs1.getDouble("product_price");
//						int product_stock = rs1.getInt("product_stock");
						String product_description = rs1.getString("product_description");
//						String product_icon = rs.getString("product_icon");
//						String category_type = rs.getString("category_type");
//						String create_time = rs.getString("create_time");
//						String update_time = rs.getString("update_time");

						ProductInfo productInfo = new ProductInfo();
						productInfo.setProduct_id(product_id);
						productInfo.setProduct_name(product_name);
						productInfo.setProduct_price(product_price);
//						productInfo.setProduct_stock(product_stock);
						productInfo.setProduct_description(product_description);
//						productInfo.setProduct_icon(product_icon);
//						productInfo.setCategory_type(category_type);
//						productInfo.setCreate_time(create_time);
//						productInfo.setUpdate_time(update_time);
						selectOrderMasterHive.add(productInfo);
					}
				} finally {
					connection.close();
				}
			}
//			//把信息放到request域中
			req.setAttribute("head2Product", head2Product);
			req.setAttribute("orderHive", selectOrderMasterHive);
////	查询销量列表 预留大数据实现
//
//			List<ProductInfo> selectOrderMasterHive = hiveQueryServiceImpl.selectOrderMasterHive();
//			System.out.println("selectOrderMasterHive:" + selectOrderMasterHive);
//			req.setAttribute("orderHive", selectOrderMasterHive);

//			List<ProductInfo> selectOrderMasterHive = hiveQueryServiceImpl.selectOrderMasterHive();
//			System.out.println("selectOrderMasterHive:" + selectOrderMasterHive);
//			req.setAttribute("orderHive", selectOrderMasterHive);
////			
//			if(==null) {
//				String sql = "select * from product_info limit 6";
//				Connection conn = JDBCUtil.getConnection();
//				PreparedStatement ps = conn.prepareStatement(sql);
//				ResultSet res = ps.executeQuery();
//				while(res.next()) {
//					String product_name = res.getString("product_name");
//					String product_icon = res.getString("product_icon");
//					ProductInfo productInfo1 = new ProductInfo();
//					productInfo1.setProduct_icon(product_icon);
//					productInfo1.setProduct_name(product_name);
//					head2Product.add(productInfo1);
//				}req.setAttribute("productInfo1", head2Product);
//			}else {
			/*
			 * List<ProductInfo> selectOrderMasterHive =
			 * hiveQueryServiceImpl.selectOrderMasterHive();
			 * System.out.println("selectOrderMasterHive:" + selectOrderMasterHive);
			 * req.setAttribute("orderHive", selectOrderMasterHive);
			 */

//	查询分类推荐  预留大数据实现

//查询首页底部
			String sql = "select * from product_info limit 60";
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				String product_name = res.getString("product_name");
				String product_icon = res.getString("product_icon");
				String product_id = res.getString("product_id");
				double product_price = res.getDouble("product_price");
				ProductInfo productInfo2 = new ProductInfo();
				productInfo2.setProduct_icon(product_icon);
				productInfo2.setProduct_name(product_name);
				productInfo2.setProduct_id(product_id);
				productInfo2.setProduct_price(product_price);
				product.add(productInfo2);
			}
			req.setAttribute("product", product);
//		转发数据到首页
			req.setAttribute("categorys", selectCategory);
			req.setAttribute("ads", selectAD);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
