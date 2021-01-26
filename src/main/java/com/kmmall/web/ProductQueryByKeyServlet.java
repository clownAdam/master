package com.kmmall.web;

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

import com.kmmall.bean.ProductInfo;
import com.kmmall.service.impl.ProductCategoryServiceImpl;
import com.kmmall.service.impl.ProductInfoServiceImpl;

@WebServlet("/queryProductByKey.do")
public class ProductQueryByKeyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String key = req.getParameter("key");
			ProductInfoServiceImpl service = new ProductInfoServiceImpl();
			List<ProductInfo> selectByKey = service.selectByKey(key);
			req.setAttribute("products", selectByKey);
			req.getRequestDispatcher("/list.jsp").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
