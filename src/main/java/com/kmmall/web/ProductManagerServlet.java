package com.kmmall.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kmmall.bean.ProductInfo;
import com.kmmall.service.impl.ProductInfoServiceImpl;
//产品相关Servlet,商品管理
@WebServlet("/product_manager.do")
public class ProductManagerServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		ProductInfoServiceImpl service = new ProductInfoServiceImpl();
		
		List<ProductInfo> selectAll = service.selectAll();
		req.setAttribute("products", selectAll);
		
		req.getRequestDispatcher("/product_manager.jsp").forward(req, resp);
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	

}

}
