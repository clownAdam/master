package com.kmmall.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kmmall.util.JDBCUtil;
import com.kmmall.util.JsonUtils;

@WebServlet("/address.do")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, Integer> map1 = new HashMap<String, Integer>();

		String sql = "Select buyer_address, count(*) c  from order_master group by buyer_address  order by c desc limit 6";
		Connection conn = JDBCUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String buyer_address = rs.getString("buyer_address");
				int count = rs.getInt("c");
				map.put(buyer_address, count);
			}
			request.setAttribute("maps", map);
			System.out.println(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		String sql1 = "Select buyer_name, count(*) c  from order_master group by buyer_name  order by c desc limit 6";
		Connection conn1 = JDBCUtil.getConnection();
		try {
			PreparedStatement ps = conn1.prepareStatement(sql1);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				String name = res.getString("buyer_name");
				int c = res.getInt("c");
				map1.put(name, c);
			}
			System.out.println("map1:"+map1);
			request.setAttribute("maps1", map1);
			request.getRequestDispatcher("address.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
