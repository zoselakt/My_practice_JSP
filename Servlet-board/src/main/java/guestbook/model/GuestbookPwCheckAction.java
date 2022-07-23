package guestbook.model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.controller.GuestbookDao;
import model.Action;
import model.ActionForward;

public class GuestbookPwCheckAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		String inputPW = request.getParameter("pw");
		String g_no = request.getParameter("num");
		int guestbook_no = Integer.parseInt(g_no);
		
		GuestbookDao dao = GuestbookDao.getInstance();
		String dbPW = dao.getPassword(guestbook_no);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(!dbPW.equals(inputPW)) {
			out.println("0");
		}else {
			out.println("1");
		}
		out.close();
		return null;
	}
}
