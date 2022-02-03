package co.user;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import dao.UserDAO;
import vo.User;

public class UserInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		String id = request.getParameter("id");
		System.out.println(id);
		UserDAO userdao = new UserDAO();
		
		User userdata = userdao.getDetail(id);
		
		request.setAttribute("userdata", userdata);
		
	
		forward.setRedirect(false); 
		forward.setPath("index.jsp");
		return forward;
	}

}
