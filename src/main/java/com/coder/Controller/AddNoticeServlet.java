package com.coder.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coder.dao.Dao;
import com.coder.model.NoticeInfo;
import com.coder.service.DeptService;
import com.coder.service.NoticeService;

public class AddNoticeServlet extends HttpServlet {
	
	private NoticeService noticeService = new NoticeService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");		
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("title");
		String content = req.getParameter("content");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/M/dd HH:mm:ss");
		String time = sf.format(new Date());
		String uid = req.getSession().getAttribute("uid").toString();
		noticeService.addNoticeService(name, content, time, uid);
		out.flush();
		out.close();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
}
