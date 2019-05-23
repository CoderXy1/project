package com.coder.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coder.service.MenuService;

public class GetMenuServlet extends HttpServlet {
	
	private MenuService menuService = new MenuService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tree = menuService.getMenu().toString();
		resp.setCharacterEncoding("utf8");
		PrintWriter pw = resp.getWriter();
		pw.write(tree);
		pw.flush();
		pw.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
