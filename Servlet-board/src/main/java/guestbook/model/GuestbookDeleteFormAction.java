package guestbook.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import model.ActionForward;

public class GuestbookDeleteFormAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		int guestbook_no = Integer.parseInt(request.getParameter("num"));
		request.setAttribute("guestbook_no", guestbook_no);
		
		forward.setRedirect(false);
		forward.setNextPath("guestbook/GuestbookDeleteForm.jsp");
		
		return forward;
	}
}
