package com.kmmall.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kmmall.bean.ProductInfo;
import com.kmmall.service.impl.ProductInfoServiceImpl;

@WebServlet("/product_add.do")
public class ProductAddServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			String product_name = req.getParameter("product_name");
			String product_price = req.getParameter("product_price");
			String product_stock = req.getParameter("product_stock");
			String product_description = req.getParameter("product_description");
			String product_icon = req.getParameter("product_icon");
			String category_type = req.getParameter("category_type");
			
			ProductInfoServiceImpl service = new ProductInfoServiceImpl();
			ProductInfo pi = new ProductInfo();
			
			pi.setProduct_name(product_name);
			pi.setProduct_icon(product_icon);
			pi.setProduct_price(Double.parseDouble(product_price));
			pi.setProduct_stock(Integer.parseInt(product_stock));
			pi.setProduct_description(product_description);
			pi.setCategory_type(category_type);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String formatDate = sdf.format(date);
			pi.setCreate_time(formatDate);
			pi.setUpdate_time(formatDate);
			
			//商品主键id使用随机字符串表示+时间戳
			String id = UUID.randomUUID().toString().replace("-", "");
			
			pi.setProduct_id(id);
			
			service.insert(pi);
//			转发至商品管理页面
		//	resp.sendRedirect("product_manager.do");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
