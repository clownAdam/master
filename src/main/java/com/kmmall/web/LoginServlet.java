package com.kmmall.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kmmall.bean.MallUser;
import com.kmmall.service.impl.MallUserServiceImpl;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String user_account = req.getParameter("user_account");
			String user_password = req.getParameter("user_password");

			MallUserServiceImpl serviceImpl = new MallUserServiceImpl();
			MallUser user = new MallUser();
			user.setUser_account(user_account);
			user.setUser_password(user_password);

			MallUser selectByAP = serviceImpl.selectByAP(user_account, user_password);
			if (selectByAP != null) {
				//登录成功，就把用户信息放到session中。
				req.getSession().setAttribute("user_info", selectByAP);
				resp.sendRedirect("user_manager.do");

			} else {
				req.setAttribute("message", "登录失败");
				req.getRequestDispatcher("/info.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
