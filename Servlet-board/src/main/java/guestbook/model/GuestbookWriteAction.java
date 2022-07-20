package guestbook.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.controller.GuestbookDao;
import guestbook.controller.GuestbookVo;
import model.Action;
import model.ActionForward;

public class GuestbookWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		
		String guestbook_id = request.getParameter("guestbook_id");
		String guestbook_password = request.getParameter("guestbook_password");
		String guestbook_content = request.getParameter("guestbook_content");
		
		GuestbookDao dao = GuestbookDao.getInstance();
		
		GuestbookVo vo = new GuestbookVo();
		vo.setGuestbook_no(dao.getSeq());
		vo.setGuestbook_id(guestbook_id);
		vo.setGuestbook_password(guestbook_password);
		vo.setGuestbook_content(guestbook_content);
		
		boolean result = dao.guestbookInsert(vo);
		if(result) {
			forward.setRedirect(true);
			forward.setNextPath("Guestbookform.ge");
		}
		return forward;
	}
}
