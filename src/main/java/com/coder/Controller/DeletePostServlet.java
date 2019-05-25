package com.coder.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coder.service.DeptService;
import com.coder.service.PostService;

public class DeletePostServlet extends HttpServlet {
	
	private PostService postService = new PostService();
	
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
		String pid = req.getParameter("pid");
		String postName = req.getParameter("postName");
		if (postService.deletePostService(pid)) {
			out.write(postService.searchPostService(postName).toString());
		}
		out.flush();
		out.close();
	}
	
}
