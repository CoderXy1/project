package com.coder.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coder.service.UserService;

public class DeleteUserServlet extends HttpServlet {
	
	private UserService userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");		
		PrintWriter out = resp.getWriter();
		String uid = req.getParameter("uid");
		String uname = req.getParameter("uname");
		String power = req.getParameter("power");
		//System.out.println(req.getParameter("uid"));
		if (userService.deleteUserService(uid)) {
			out.write(userService.searchUserService(uname,power).toString());
		}
		out.flush();
		out.close();
	}
	
}
