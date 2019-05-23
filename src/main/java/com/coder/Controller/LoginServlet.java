package com.coder.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coder.dao.Dao;

public class LoginServlet extends HttpServlet {
	
	private Dao dao = new Dao();
	
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
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		if (dao.isRight(name, pass)) {
			session.setAttribute("isLogin",true);
			resp.sendRedirect("main.jsp");
		}else {
			out.print("<script>alert('账号或密码错误!');window.location.href='index.jsp'</script>");
		}
		
	}
	
}
