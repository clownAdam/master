package com.kmmall.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kmmall.bean.AD;
import com.kmmall.bean.ProductCategory;
import com.kmmall.service.impl.ADServiceImpl;
import com.kmmall.service.impl.ProductCategoryServiceImpl;
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
//监听器：坚挺servletContext对象的状态
@WebListener()
public class HeaderListener implements ServletContextListener {


	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		
	}
//项目启动时
	public void contextInitialized(ServletContextEvent sce) {
		try {
			// 查询分类,并存放到servletContext与对象中
			ProductCategoryServiceImpl categoryService = new ProductCategoryServiceImpl();
			List<ProductCategory> selectCategory = categoryService.selectCategory();
			ServletContext context = sce.getServletContext();
			context.setAttribute("categorys", selectCategory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}


}
