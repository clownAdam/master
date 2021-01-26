package com.kmmall.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kmmall.bean.MallUser;
import com.kmmall.service.impl.MallUserServiceImpl;

@WebServlet("/regist.do")
public class RegistServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("zhu ce bu fen begin");
		try {
			String user_name = req.getParameter("user_name");
			String user_pic = req.getParameter("user_pic");
			String user_sex = req.getParameter("user_sex");
			String user_account = req.getParameter("user_account");
			String user_password = req.getParameter("user_password");
			
			MallUserServiceImpl serviceImpl = new MallUserServiceImpl();
			MallUser user = new MallUser();
			user.setUser_name(user_name);
			user.setUser_pic(user_pic);
			user.setUser_sex(user_sex);
			user.setUser_account(user_account);
			user.setUser_password(user_password);
			
		//用户id修改为主键自增
			int insertUser = serviceImpl.insertUser(user);
			req.setAttribute("message", insertUser>0?"注册成功":"注册失败"+",点击跳转登录页面");
			req.setAttribute("page", "login.do");
			req.getRequestDispatcher("/info.jsp").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
