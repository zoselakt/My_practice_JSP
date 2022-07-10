package com.test.ex.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.ex.dao.Bdao;

public class BModifyCommand implements BCommand {
	
	public void execute(HttpServletRequest request, HttpServletResponse response){
		String bId = request.getParameter("bId");
		String bName =request.getParameter("bName");
		String bTitle =request.getParameter("bTitle");
		String bContent =request.getParameter("bContent");
		
		Bdao dao = new Bdao();
		dao.modify(bId, bName, bTitle, bContent);
	}
}
