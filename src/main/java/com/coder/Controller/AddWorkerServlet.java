package com.coder.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coder.service.WorkerService;

public class AddWorkerServlet extends HttpServlet {
	
	private WorkerService workerService = new WorkerService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");		
		PrintWriter out = resp.getWriter();
		String wName = req.getParameter("wName");
		String sex = req.getParameter("sex");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String pName = req.getParameter("pName");
		String education = req.getParameter("education");
		String idNumber = req.getParameter("idNumber");
		String address = req.getParameter("address");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd HH:MM:ss");
		String creatTime = sf.format(new Date());
		String birthday = req.getParameter("birthday");
		String interests = req.getParameter("interests");
		String qq = req.getParameter("qq");
		String political = req.getParameter("political");
		String postcode  = req.getParameter("postcode");
		String family  = req.getParameter("family");
		String major   = req.getParameter("major");
		String remarks  = req.getParameter("remarks");
		String dName  = req.getParameter("dName");		
		workerService.addWorkerService(wName, sex, phone, email, pName, education, idNumber, address, creatTime, birthday, interests, qq, political, postcode, family, major, remarks, dName);
		out.flush();
		out.close();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
}
