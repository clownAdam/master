package com.kmmall.web;

import com.kmmall.bean.ProductInfo;
import com.kmmall.service.impl.ProductInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//产品相关Servlet,商品管理
@WebServlet("/product_cart.do")
public class ProductCartServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		List<ProductInfo> selectAll = new ArrayList<>();
		ProductInfoServiceImpl service = new ProductInfoServiceImpl();
		String pid = (String) req.getParameter("pid");
		String uid = (String) req.getParameter("uid");
		ProductInfo productInfo = service.selectById(pid);
		System.out.println("productInfo = " + productInfo);
		selectAll.add(productInfo);
		req.setAttribute("products", selectAll);
		
		req.getRequestDispatcher("/product_cart.jsp").forward(req, resp);
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	

}

}
