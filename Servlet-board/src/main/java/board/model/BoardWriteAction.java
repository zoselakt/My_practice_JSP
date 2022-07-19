package board.model;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.controller.BoardDao;
import board.controller.BoardVo;
import model.Action;
import model.ActionForward;

public class BoardWriteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		
		int fileSize = 5 * 1024 * 1024;
		String uploadPath = request.getServletContext().getRealPath("/UploadFolder");
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
			String fileName = "";
			Enumeration<String> names = multi.getFileNames();
			
			if(names.hasMoreElements()) {
				String name = names.nextElement();
				fileName = multi.getFilesystemName(name);
			}
			
			BoardDao dao = BoardDao.getInstance();
			BoardVo vo = new BoardVo();
			
			vo.setBoard_num(dao.getSeq());
			vo.setBoard_id(multi.getParameter("board_id"));
			vo.setBoard_subject(multi.getParameter("board_subject"));
			vo.setBoard_content(multi.getParameter("board_content"));
			vo.setBoard_file(multi.getParameter("board_file"));
			
			boolean result = dao.boardInsert(vo);
			if(result) {
				forward.setRedirect(true);
				forward.setNextPath("BoardListForm.bo");
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("글 작성 오류: " + e.getMessage());
		}
		return forward;
	}
}
