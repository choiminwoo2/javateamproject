package bo.reviewboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;

/**
 * Servlet implementation class ReviewBoardFrontController
 */
@WebServlet("*.bo")
public class ReviewBoardFrontController extends HttpServlet {
	private static final long serialVersionUID=1L;
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		String RequestURI=request.getRequestURI();
		System.out.println("RequestURI= "+ RequestURI);
	         
		String contextPath= request.getContextPath();
		System.out.println("contextPath= " + contextPath);
		
		String command = RequestURI.substring(contextPath.length());
				System.out.println("command= " + command);
				
		//초기화
	   ActionForward forward = null;
	   Action action = null;
	   
	   switch (command) {
	   case "/BoardWrite.bo":
		   action = new BoardWriteAction();
		   break;
	   case "/BoardList.bo":
		   action = new BoardListAction();
		   break;
	   case "/BoardAddAction.bo":
		   action = new BoardAddAction();
		   break;
	   case "/BoardDeleteAction.bo":
		   action = new BoardDeleteAction();
		   break;
	   case "/BoardModifyAction.bo":
		   action = new BoardModifyAction();
		   break;
	   case "/BoardModifyView.bo":
			action = new BoardModifyView();
			break;
	   case "/BoardDetailAction.bo":
		   action = new BoardDetailAction();
		   break;	   
	   }
	   forward = action.execute(request,  response);
	   
	   if(forward != null) {
		   if(forward.isRedirect()) { //리다이렉트 됩니다.
			   response.sendRedirect(forward.getPath());
		   }else {//포워딩됩니다.
			   RequestDispatcher dispatcher = 
					   request.getRequestDispatcher(forward.getPath());
			   dispatcher.forward(request,  response);
		   }
	   }
	
	}
	//doProcess(request, response)메서드를 구현하여 요청이 GET방식이든
	//POST방식으로 전송되어 오든 같은 메서드에서 요청을 처리할 수 있도록 하였습니다.
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{
		 doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8"); 
		doProcess(request,response);
	}
	
}
