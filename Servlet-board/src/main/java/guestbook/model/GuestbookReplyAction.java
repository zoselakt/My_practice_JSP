package guestbook.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.controller.GuestbookDao;
import guestbook.controller.GuestbookVo;
import model.Action;
import model.ActionForward;

public class GuestbookReplyAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		GuestbookDao dao = GuestbookDao.getInstance();
		GuestbookVo vo = new GuestbookVo();
		
		String pageNum = request.getParameter("page");
		
		int guestbook_no = Integer.parseInt(request.getParameter("guestbook_no"));
		String guestbook_id = request.getParameter("geustbook_id");
		String guestbook_password = request.getParameter("geustbook_password");
		String guestbook_content = request.getParameter("geustbook_content");
		int guestbook_group = Integer.parseInt(request.getParameter("guestbook_group"));
		
		vo.setGuestbook_no(dao.getSeq());
		vo.setGuestbook_id(guestbook_id);
		vo.setGuestbook_password(guestbook_password);
		vo.setGuestbook_content(guestbook_content);
		vo.setGuestbook_group(guestbook_group);
		vo.setGuestbook_parent(guestbook_no);
		
		boolean result = dao.guestbookInsert(vo);
		if(result) {
			forward.setRedirect(true);
			forward.setNextPath("GuestbookListAction.ge?page="+pageNum);
		}
		return forward;
	}
}
