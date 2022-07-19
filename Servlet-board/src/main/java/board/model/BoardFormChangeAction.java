package board.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import model.ActionForward;

public class BoardFormChangeAction implements Action{
	private String form = "MainForm.jsp?contentPage=board/";
	private String path;
	
	/**
	 * @param command
	 */
	public void setCommand(String command) {
		int idx = command.indexOf(".");
		path = command.substring(0, idx)+ ".jsp"; // -> null
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		if(path.equals("MainForm.jsp")) { 
			forward.setNextPath(path);
		}else {
			forward.setNextPath(form + path);
		}
		return forward;
	}
}
