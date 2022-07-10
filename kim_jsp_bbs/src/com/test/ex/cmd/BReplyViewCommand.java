package com.test.ex.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.ex.dao.Bdao;
import com.test.ex.dto.Bdto;

public class BReplyViewCommand implements BCommand{
	
	public void execute(HttpServletRequest request, HttpServletResponse response){
		String bId = request.getParameter("bId");
		Bdao dao = new Bdao();
		Bdto dto = dao.replyView(bId);
		
		request.setAttribute("replyView", dto);
	}
}
