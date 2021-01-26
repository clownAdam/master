package com.kmmall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kmmall.service.impl.OrderMasterServiceImpl;

@WebServlet("/updateStatus.do")
public class UpdateStatusServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String status = req.getParameter("status");
			String orderId = req.getParameter("order_id");
			int statusInt = Integer.parseInt(status);
			OrderMasterServiceImpl service = new OrderMasterServiceImpl();
			
			int result = service.updateStatus(orderId, statusInt);
			req.setAttribute("message", result>0?"操作成功":"操作失败"+",点击跳转用户管理页面");
			req.setAttribute("page", "user_manager.do");
			req.getRequestDispatcher("/info.jsp").forward(req, resp);
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
