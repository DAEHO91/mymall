package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;


@WebServlet("/GetMemberController")
public class GetMemberController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet .......GetMemberController.java");	
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");

		if(session.getAttribute("loginMember") == null) {
			response.sendRedirect(request.getContextPath()+"/IndexController");
		}else {
			MemberService memberService = new MemberService();
			Member member = memberService.selectMember(loginMember.getId());
		
			session.setAttribute("member", member);
			request.getRequestDispatcher("WEB-INF/view/getMember.jsp").forward(request, response);	
		}
	}
}
