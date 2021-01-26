package com.kmmall.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kmmall.bean.MallUser;
import com.kmmall.bean.OrderMaster;
import com.kmmall.bean.ProductInfo;
import com.kmmall.service.impl.MallUserServiceImpl;
import com.kmmall.service.impl.OrderMasterServiceImpl;
import com.kmmall.service.impl.ProductCategoryServiceImpl;
import com.kmmall.service.impl.ProductInfoServiceImpl;

//get方法：跳转下单页面，post方法：提交订单
@WebServlet("/order.do")
public class OrderServlet extends HttpServlet {
	// 跳转下单页面
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			MallUser user = (MallUser) req.getSession().getAttribute("user_info");
			if (user == null) {
				resp.getWriter().write(
						"<script language=JavaScript type=text/javascript>"
						+ "alert('请登录');window.location.href='login.jsp';"
						+ "</script>");
			} else {
				String pid = req.getParameter("pid");
				ProductInfoServiceImpl service = new ProductInfoServiceImpl();
				ProductInfo selectById = service.selectById(pid);
				req.setAttribute("product", selectById);
				req.getRequestDispatcher("/order.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 提交订单
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			String product_quantity = req.getParameter("product_quantity");
			String product_id = req.getParameter("product_id");
			String product_price = req.getParameter("product_price");
			String product_name = req.getParameter("product_name");
			String buyer_name = req.getParameter("buyer_name");
			String buyer_phone = req.getParameter("buyer_phone");
			String buyer_address = req.getParameter("buyer_address");
			String buyer_openid = req.getParameter("buyer_openid");
			String order_amount = req.getParameter("order_amount");
			String user_id = req.getParameter("user_id");

			OrderMaster order = new OrderMaster();
			order.setProduct_quantity(Integer.parseInt(product_quantity));
			order.setProduct_id(product_id);
			order.setProduct_price(Double.parseDouble(product_price));
			order.setProduct_name(product_name);
			order.setBuyer_name(buyer_name);
			order.setBuyer_phone(buyer_phone);
			order.setBuyer_address(buyer_address);
			order.setBuyer_openid(buyer_openid);
			order.setOrder_amount(Double.parseDouble(order_amount));
			order.setUser_id(Integer.parseInt(user_id));

			order.setOrder_status(0);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String formatDate = sdf.format(date);
			order.setCreate_time(formatDate);
			order.setUpdate_time(formatDate);

			// 订单id随机生成
			String id = UUID.randomUUID().toString().replace("-", "");
			order.setOrder_id(id);

			OrderMasterServiceImpl serviceImpl = new OrderMasterServiceImpl();
			serviceImpl.insertOrder(order);
			
			/**
			 * 输入文件 order.log
			 */
			String info = id+"\t"+product_id+"\t"+product_name+"\r\n";
			String realPath = req.getRealPath("log/order.log");
			FileOutputStream fos = new FileOutputStream(realPath,true);
			fos.write(info.getBytes());
			fos.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 跳转订单管理页面
		resp.sendRedirect("user_manager.do");
	}
}
