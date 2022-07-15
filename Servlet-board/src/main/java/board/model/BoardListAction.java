package board.model;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.controller.BoardDao;
import board.controller.BoardVo;
import model.Action;
import model.ActionForward;

public class BoardListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		ActionForward forward = new ActionForward();
		int spage = 1;
		String page = request.getParameter("page");
		
		if(page != null) {
			spage = Integer.parseInt(page);
		}
		//검색조건과 검색내용
		String opt = request.getParameter("opt");
		String condition = request.getParameter("condition");
		
		HashMap<String, Object> listOpt = new HashMap<String, Object>();
		listOpt.put("opt", opt);
		listOpt.put("condition", condition);
		listOpt.put("start", spage*10-9);
		
		BoardDao dao = BoardDao.getInstance();
		int listCount = dao.getBoardListCount(listOpt);
		ArrayList<BoardVo> list = dao.getBoardList(listOpt);
		
		int maxPage = (int) (listCount/10.0 + 0.9);
		int startPage = (int) (spage/5.0 + 0.8) * 5 - 4;
		int endPage = startPage + 4;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		request.setAttribute("spage", spage);
		request.setAttribute("maxpage", maxPage);
		request.setAttribute("startpage", startPage);
		request.setAttribute("endPage", endPage);
		
		request.setAttribute("list", list);
		
		forward.setRedirect(false);
		forward.setNextPath("boardListForm.do");
		
		return forward;
	}
}
