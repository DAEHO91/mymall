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

import com.test.mymall.service.ItemService;

@WebServlet("/itemListController")
public class itemList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() itemList.java");
		ItemService itemService = new ItemService();
		HttpSession session = request.getSession();
		
		ArrayList<HashMap<String, Object>> list = itemService.itemList();
		
		session.setAttribute("list", list);

		request.getRequestDispatcher("/WEB-INF/view/itemList.jsp").forward(request, response);
	}

}
