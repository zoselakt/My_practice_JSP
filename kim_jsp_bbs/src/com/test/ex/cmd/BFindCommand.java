package com.test.ex.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.ex.dao.Bdao;

public class BFindCommand implements BCommand{
	public void execute(HttpServletRequest request, HttpServletResponse response){
		String bfind = request.getParameter("bfind");
		String bquery = request.getParameter("bquery");
		String field = "title";
		if(bfind != null) {
			bfind = field;
		}
		String query = "";
		if(query != null) {
			query = bquery;
		}
		
//		Bdao dao = new Bdao();
//		dao.findWrite(bId);
	}
}
