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
		
		int user_no = Integer.parseInt(request.getParameter("user_no"));
		UserDAO udao = new UserDAO();
	
		User u = udao.UserSession(id);
		User u2 = udao.AnimalSession(user_no);
		
		if(u==null) {
			forward.setPath("error/error.jsp");
			forward.setRedirect(false);
			request.setAttribute("message", "아이디에 해당하는 정보가 없습니다.");
			return forward;
		}
		forward.setPath("user/userInfo.jsp");
		forward.setRedirect(false);
		request.setAttribute("userinfo",u);
		request.setAttribute("animalinfo",u2);
		return forward;
	}

}
