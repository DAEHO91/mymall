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

import com.test.mymall.service.ItemService;

@WebServlet("/itemListController")
public class itemList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() itemList.java");
		ItemService itemService = new ItemService();
		HttpSession session = request.getSession();
		
		List<Map<String, Object>> list = itemService.itemList();
		System.out.println(list+"<<<< itemList.java");
		
		session.setAttribute("itemlist", list);

		request.getRequestDispatcher("/WEB-INF/view/itemList.jsp").forward(request, response);
	}

}
