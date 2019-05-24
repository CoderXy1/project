package com.coder.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coder.service.DeptService;

public class DeleteDeptServlet extends HttpServlet {
	
	private DeptService deptService = new DeptService();
	
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
		String did = req.getParameter("did");
		String deptName = req.getParameter("deptName");
		//System.out.println(req.getParameter("uid"));
		if (deptService.deleteDeptService(did)) {
			out.write(deptService.searchDeptService(deptName).toString());
		}
		out.flush();
		out.close();
	}
	
}
