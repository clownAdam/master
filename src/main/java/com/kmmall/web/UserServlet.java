package com.kmmall.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kmmall.bean.MallUser;
import com.kmmall.bean.OrderMaster;
import com.kmmall.service.impl.MallUserServiceImpl;
import com.kmmall.service.impl.OrderMasterServiceImpl;
import com.kmmall.service.impl.ProductCategoryServiceImpl;

//用户相关Servlet 主要查询该用户的订单信息
@WebServlet("/user_manager.do")
public class UserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		try {
			//获取用户id
			MallUser user = (MallUser)req.getSession().getAttribute("user_info");
			if (user == null) {
				resp.getWriter().write(
						"<script language=JavaScript type=text/javascript>alert('请登录');window.location.href='index.do';</script>");
			} else {
				Integer user_id = user.getUser_id();
				OrderMasterServiceImpl service = new OrderMasterServiceImpl();
				List<OrderMaster> selectOrderByUserId = service.selectOrderByUserId(user_id);
				req.setAttribute("orders", selectOrderByUserId);
				req.getRequestDispatcher("/user_manager.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
