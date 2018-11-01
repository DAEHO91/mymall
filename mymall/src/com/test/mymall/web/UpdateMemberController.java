package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.dao.MemberDao;
import com.test.mymall.vo.Member;

@WebServlet("/UpdateMemberController")
public class UpdateMemberController extends HttpServlet {

	private MemberDao memberDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet...........UpdateMemberController.java");
		request.getRequestDispatcher("WEB-INF/view/updateMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost...........UpdateMemberController.java");
		
		Member member = new Member();
		memberDao = new MemberDao(); 
		
		member.setNo(Integer.parseInt(request.getParameter("no")));
		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
		member.setLevel(Integer.parseInt(request.getParameter("level")));
		
		memberDao.updateMember(member);
		
		response.sendRedirect(request.getContextPath()+"/GetMemberController");
	}

}
