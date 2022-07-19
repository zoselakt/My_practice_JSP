package board.model;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import model.ActionForward;

public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Action> commandMap;
       
	public void init(ServletConfig config) throws ServletException {
		loadProperties("/properties/BoardCommand");
	}
	
	/**
	 * @param filePath
	 */
	private void loadProperties(String filePath) { //filepath: /properties/BoardCommand
		commandMap = new HashMap<String, Action>(); //commandMap : 각 action경로
		ResourceBundle rb = ResourceBundle.getBundle(filePath);
		Enumeration<String> actionEnum = rb.getKeys();
		
		
		while(actionEnum.hasMoreElements()) { // false
			String command = actionEnum.nextElement();
			String className = rb.getString(command);
			
			try {
				Class actionClass = Class.forName(className); //actionClass: class board.model.BoardReplyAction
				Action actionInstance = (Action)actionClass.newInstance();
				
				if(className.equals("board.model.BoardFormChangeAction")) {
					BoardFormChangeAction bf = (BoardFormChangeAction) actionInstance;
					bf.setCommand(command);
				}
				commandMap.put(command, actionInstance); 
				// command: BoardWriteForm.bo / actionInstance: boardReplyAction
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
		doProcess(request, response);
	}
	
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI(); // requestURI : /Servlet-board/BoardListForm.bo
		int cmdIdx = requestURI.lastIndexOf("/")+1; // lastIndexOf: 141
		String command = requestURI.substring(cmdIdx); // cmdIdx : 15
		
		System.out.println("board cmd : " + command); // command : BoardWriteForm.bo
		ActionForward forward = null;
		Action action = null;
		
		try {
			action = commandMap.get(command); // -> 여기에서 null값이 뜬다.
			
			if(action == null) {
				System.out.println("명령어: " + command+"는 잘못된 명령입니다.");
				return;
			}
			forward = action.execute(request, response);
			
			if(forward != null) {
				if(forward.isRedirect()) {
					response.sendRedirect(forward.getNextPath());
				}else {
					RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getNextPath());
					dispatcher.forward(request, response);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
