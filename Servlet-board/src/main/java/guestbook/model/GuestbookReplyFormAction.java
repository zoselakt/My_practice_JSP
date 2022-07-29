package guestbook.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.controller.GuestbookDao;
import guestbook.controller.GuestbookVo;
import model.Action;
import model.ActionForward;

public class GuestbookReplyFormAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		int guestbook_no = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("page");
		
		GuestbookDao dao = GuestbookDao.getInstance();
		GuestbookVo vo = dao.getGuestbook(guestbook_no);
		
		request.setAttribute("guestbook_no", guestbook_no);
		request.setAttribute("pageNum", pageNum);
		
		forward.setRedirect(false);
		forward.setNextPath("guestbook/GuestbookReplyForm.jsp");
		
		return forward;
	}
}
