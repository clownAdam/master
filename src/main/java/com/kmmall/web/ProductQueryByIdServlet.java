package com.kmmall.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kmmall.bean.MallUser;
import com.kmmall.bean.ProductInfo;
import com.kmmall.service.impl.ProductInfoServiceImpl;
//根据商品id查询商品，然后跳转到商品详情页面
@WebServlet("/goods_detail.do")
public class ProductQueryByIdServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String pid = req.getParameter("pid");
			//在此处，编写代码，将用户的访问商品的记录，放到某个文件中
//			记录：用户id，商品id
/*
 * 首先获取用户id
 * 		用户信息，我是们登录后，才有用户信息！！！
 * 		所以，这里需要一个条件判断，如果用户登录了，则采集，如果用户没登录，不采集
 * 	如何判断用户是否登录呢？
 * 		查询session中的"user_info"对应的对象，是否存在，如果存在，则用户登录，不存在，用户未登录
 * 
 *  如果有：记录
 *  	String str = userId+"\t"+productId
 * 将数据，写出到本地磁盘文件，io操作。
 * 
 * 
 * 开启flume，编写agent，监听这个磁盘文件。实时将数据从tomcat中，导入到hdfs。
 */
			
//			判断用户是否登录
			Object attribute = req.getSession().getAttribute("user_info");
			if(attribute!=null) {
				MallUser user = (MallUser)attribute;
//				用户名	商品id
				String info = user.getUser_id()+"\t"+pid+"\r\n";
//				将商品浏览记录，写出到tomcat中的磁盘中的某个文件
//				获取文件的输出流
				String realPath = req.getRealPath("log/uid_pid.log");
				System.out.println("log/uid_pid.log:"+info);
									//创建输出流，参数1：写出路径，参数2：是否是追加
				FileOutputStream fos = new FileOutputStream(realPath,true);
				fos.write(info.getBytes());
				fos.close();
			} 
			
			
			ProductInfoServiceImpl service = new ProductInfoServiceImpl();
			ProductInfo product = service.selectById(pid);
			req.setAttribute("product", product);
			req.getRequestDispatcher("goods_detail.jsp").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
