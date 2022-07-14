package jv300.mod002.list_contoller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jv300.mod002.dao.BoardDao;
import jv300.mod002.vo.BoardVo;

public class BoardListCommnad implements BoardCommand {
	public void execute(HttpServletRequest request, HttpServletResponse response){
		BoardDao dao = new BoardDao();
		List<BoardVo> boardAll = dao.selectAll();
		
		request.setAttribute("selectAll", boardAll);
	}
}
