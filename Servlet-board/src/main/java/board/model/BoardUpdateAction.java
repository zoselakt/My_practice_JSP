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

public class BoardUpdateAction implements Action {
	@Override
	public ActionForward execute (HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		String pageNum = request.getParameter("page");
		int fileSize = 5 * 1024 * 1024;
		String uploadPath = request.getServletContext().getRealPath("/UploadFolder");
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
			
			int num = Integer.parseInt(multi.getParameter("board_num"));
			String subject = multi.getParameter("board_subject");
			String content = multi.getParameter("board_content");
			String existFile = multi.getParameter("existing_file");
			
			BoardVo vo = new BoardVo();
			vo.setBoard_num(num);
			vo.setBoard_subject(subject);
			vo.setBoard_content(content);
			
			Enumeration<String> fileNames = multi.getFileNames();
			if(fileNames.hasMoreElements()) {
				String fileName = fileNames.nextElement();
				String updateFile = multi.getFilesystemName(fileName);
				if(updateFile == null) {
					vo.setBoard_file(existFile);
				}else {
					vo.setBoard_file(updateFile);
				}
			}
			BoardDao dao = BoardDao.getInstance();
			boolean result = dao.updateBoard(vo);
			if(result) {
				forward.setRedirect(true);
				forward.setNextPath("BoardListAction.bo?page=" + pageNum);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("글 수정 오류: "+ e.getMessage());
		}
		return forward;
	}
}
