package guestbook.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.controller.GuestbookDao;
import guestbook.controller.GuestbookVo;
import model.Action;
import model.ActionForward;

public class GuestbookListAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		
	int spage = 1;
	String page = request.getParameter("page");
	
	if(page != null) {
		spage = Integer.parseInt(page);
	}
	
	GuestbookDao dao = GuestbookDao.getInstance();
	int listCount = dao.getGuestbookCount();
	int maxPage = (int)(listCount/5.0 + 0.9);
	
	if(spage > maxPage) {
		spage = maxPage;
	}
	
	ArrayList<GuestbookVo> list = dao.getGuestbookList(spage * 5-4);
	int startPage = (int)(spage/5.0+0.8) * 5 - 4;
	int endPage = startPage + 4;
	
	if(endPage > maxPage) {
		endPage = maxPage;
	}
	
	request.setAttribute("spage", spage);
	request.setAttribute("maxPage", maxPage);
	request.setAttribute("startPage", startPage);
	request.setAttribute("endPage", endPage);
	request.setAttribute("list", list);
	
	forward.setRedirect(false);
	forward.setNextPath("GuestbookForm.ge");
	return forward;
	}
}
