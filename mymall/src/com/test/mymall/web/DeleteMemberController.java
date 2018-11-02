package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.dao.MemberDao;
import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;

@WebServlet("/DeleteMemberController")
public class DeleteMemberController extends HttpServlet {
	
	private MemberService memberService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet.........DeleteMemberController.java");
		request.getRequestDispatcher("WEB-INF/view/deleteMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost.........DeleteMemberController.java");
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		

		memberService = new MemberService();
		Member member = new Member();
		member.setId(loginMember.getId());
		member.setNo(loginMember.getNo());
		member.setPw(request.getParameter("pw"));
		
		memberService.deleteMember(member);
		
		response.sendRedirect(request.getContextPath()+"/LogoutController");
	}

}
