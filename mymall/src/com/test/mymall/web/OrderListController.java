package com.test.mymall.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
		System.out.println("doGet()메서드 OrderList.java");
		
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		MemberItemService memberItemService = new MemberItemService();
		
		// 회원권한을 입력받아 관리자일경우 모든 주문내역 조회, 고객일경우 자신의 주문내역만 조회
		ArrayList<HashMap<String, Object>> list = memberItemService.orderList(member);
		
		session.setAttribute("orderList", list);
				
		request.getRequestDispatcher("/WEB-INF/view/orderList.jsp").forward(request, response);
	}

}
