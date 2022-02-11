package co.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import dao.UserDAO;
import vo.User;

public class UserDeleteCheckViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		UserDAO mdao = new UserDAO();
		User temp = new User();
		
		String id = request.getParameter("id");
		temp = mdao.UserSession(id);
		request.setAttribute("temp", temp);
		forward.setPath("user/userdeletecheck.jsp");
		return forward;
	
	}

}
