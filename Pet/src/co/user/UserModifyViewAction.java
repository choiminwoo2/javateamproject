package co.user;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import action.ActionForward;
import dao.UserDAO;
import vo.User;

public class UserModifyViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		UserDAO udao = new UserDAO();
		
		
		User u2 = new User();
		
		String id = request.getParameter("id");
		
		User u = udao.UserSession(id);
		
		
		
		int user_no = Integer.parseInt(request.getParameter("user_no"));
		 u2 = udao.AnimalSession(user_no);
		
	
		request.setAttribute("userinfo", u);
		request.setAttribute("animalinfo",u2);
		
		forward.setPath("user/usermodify.jsp");
		return forward;
	}

}
