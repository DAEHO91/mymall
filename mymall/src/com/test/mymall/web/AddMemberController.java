package com.test.mymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;


@WebServlet("/AddMemberController")
public class AddMemberController extends HttpServlet {

	private MemberService memberService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() AddMemberController.java");
		request.getRequestDispatcher("/WEB-INF/view/addMember.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() AddMemberController.java");
		
		Member member = new Member();
		memberService = new MemberService();

		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));	
		member.setLevel(Integer.parseInt(request.getParameter("level")));
		memberService.addMember(member);
		
		response.sendRedirect(request.getContextPath()+"/LoginController");
	}

}
