package guestbook.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import model.ActionForward;

public class GuestbookFormAction implements Action {
	private String path = "MainForm.jsp?contentPage=guestbook/GuestbookForm.jsp";
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setNextPath(path);
		
		return forward;
	}
}
