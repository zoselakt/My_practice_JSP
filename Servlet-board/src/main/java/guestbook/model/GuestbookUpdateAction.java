package guestbook.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.controller.GuestbookDao;
import guestbook.controller.GuestbookVo;
import model.Action;
import model.ActionForward;

public class GuestbookUpdateAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		GuestbookDao dao = GuestbookDao.getInstance();
		GuestbookVo vo = new GuestbookVo();
		
		int guestbook_no = Integer.parseInt(request.getParameter("guestbook_no"));
		String guestbook_id = request.getParameter("geustbook_id");
		String guestbook_content = request.getParameter("geustbook_content");
		String pageNum = request.getParameter("page");
		
		vo.setGuestbook_id(guestbook_id);
		vo.setGuestbook_content(guestbook_content);
		vo.setGuestbook_parent(guestbook_no);
		
		boolean result = dao.guestbookInsert(vo);
		if(result) {
			forward.setRedirect(true);
			forward.setNextPath("GuestbookListAction.ge?page="+pageNum);
		}else {
			return null;
		}
		return forward;
	}
}
