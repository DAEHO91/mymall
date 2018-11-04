package com.test.mymall.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.service.MemberItemService;
import com.test.mymall.vo.Member;

@WebServlet("/OrderListController")
public class OrderListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() OrderList.java");
		
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		MemberItemService memberItemService = new MemberItemService();
		
		List<Map<String, Object>> list = memberItemService.orderList(member);
		
		session.setAttribute("orderList", list);
				
		request.getRequestDispatcher("/WEB-INF/view/orderList.jsp").forward(request, response);
	}

}
