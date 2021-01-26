package com.kmmall.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kmmall.bean.OrderMaster;
import com.kmmall.bean.ProductInfo;
import com.kmmall.service.impl.OrderMasterServiceImpl;
import com.kmmall.service.impl.ProductInfoServiceImpl;

//产品相关Servlet,商品管理
@WebServlet("/order_manager.do")
public class OrderManagerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			OrderMasterServiceImpl service = new OrderMasterServiceImpl();
			List<OrderMaster> selectOrder = service.selectOrder();
			req.setAttribute("orders", selectOrder);
			req.getRequestDispatcher("/order_manager.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
