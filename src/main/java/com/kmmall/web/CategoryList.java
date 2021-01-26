package com.kmmall.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kmmall.bean.ProductInfo;
import com.kmmall.service.impl.ProductCategoryServiceImpl;
import com.kmmall.service.impl.ProductInfoServiceImpl;
//查询分类下的商品
//categoryList.do?categoryId=001
@WebServlet("/categoryList.do")
public class CategoryList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//根据分类来查询商品列表
			String categoryType = req.getParameter("categoryId");
			ProductInfoServiceImpl service = new ProductInfoServiceImpl();
			//获取到分类下的所有商品
			List<ProductInfo> selectByCategory = service.selectByCategory(categoryType);
			//转发到JSP
			req.setAttribute("products", selectByCategory);
			req.getRequestDispatcher("/list.jsp").forward(req, resp);
		} catch (Exception e) {
		}
	}
}
