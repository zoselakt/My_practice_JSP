package board.model;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.controller.BoardDao;
import model.Action;
import model.ActionForward;

public class BoardDeleteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		String num = request.getParameter("num");
		int boardNum = Integer.parseInt(num);
		BoardDao dao = BoardDao.getInstance();
		String fileName = dao.getFileName(boardNum);
		boolean result = dao.deleteBoard(boardNum);
		
		if(fileName != null) {
			String folder = request.getServletContext().getRealPath("UploadFolder");
			String filePath = folder + "/" + fileName;
			
			File file = new File(filePath);
			if(file.exists()) {
				file.delete();
			}
		}
		if(result) {
			forward.setRedirect(true);
			forward.setNextPath("BoardListAction.bo");
		}else {
			return null;
		}
		return forward;
	}
}
