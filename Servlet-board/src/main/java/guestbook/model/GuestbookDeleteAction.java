package guestbook.model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.controller.GuestbookDao;
import guestbook.controller.GuestbookVo;
import model.Action;
import model.ActionForward;

public class GuestbookDeleteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		String inputPW = request.getParameter("pw");
		String g_no = request.getParameter("num");
		int guestbook_no = Integer.parseInt(g_no);
		
		GuestbookDao dao = GuestbookDao.getInstance();
		String dbPW = dao.getPassword(guestbook_no);
		
		if(!dbPW.equals(inputPW)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("0");
			out.close();
			return null;
		}
		boolean result = dao.deleteGuestbook(guestbook_no);
		if(result) {
			forward.setRedirect(true);
			forward.setNextPath("GuestbookListAction.ge");
		}else {
			return null;
		}
		return forward;
	}
}
