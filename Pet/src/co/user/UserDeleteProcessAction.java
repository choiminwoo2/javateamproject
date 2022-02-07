package co.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import dao.UserDAO;
import vo.User;

public class UserDeleteProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		String id = request.getParameter("id");
		System.out.println("ID=" + id);
		
		UserDAO mdao = new UserDAO(); 
		int result = mdao.delete(id);
		
		if(result ==1) {
		
		forward.setRedirect(true);
		forward.setPath("index.jsp"); 
		
		}
	
		request.getSession().invalidate();
		return forward;
 }
}
