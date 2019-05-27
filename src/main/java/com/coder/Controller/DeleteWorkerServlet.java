package com.coder.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coder.service.UserService;
import com.coder.service.WorkerService;

public class DeleteWorkerServlet extends HttpServlet {
	
	private WorkerService workerService = new WorkerService();
	
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
		String wid = req.getParameter("wid");
		String wName = req.getParameter("wName");
		String dName = req.getParameter("dName");
		if (workerService.deleteWorkerService(wid)) {
			out.write(workerService.searchWorkerService(wName, dName).toString());
		}
		out.flush();
		out.close();
	}
	
}
