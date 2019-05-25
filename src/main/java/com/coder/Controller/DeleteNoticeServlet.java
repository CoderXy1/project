package com.coder.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coder.service.NoticeService;

public class DeleteNoticeServlet extends HttpServlet {
	
	private NoticeService noticeService = new NoticeService();
	
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
		System.out.println(did);
		String name = req.getParameter("title");
		String content = req.getParameter("content");
		if (noticeService.deleteNoticeService(did)) {
			out.write(noticeService.searchNoticeService(name,content).toString());
		}
		out.flush();
		out.close();
	}
	
}
