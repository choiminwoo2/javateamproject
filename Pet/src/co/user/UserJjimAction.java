package co.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import dao.UserDAO;
import vo.User;

public class UserJjimAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO udao = new UserDAO();
		
		
		 int hotel_no = Integer.parseInt(request.getParameter("hotel_no"));
		 System.out.println("호텔번호="+hotel_no);
		 int user_no = Integer.parseInt(request.getParameter("user_no"));
		 System.out.println("유저번호="+user_no);
		 
		 udao.Jjiminsert(hotel_no, user_no);
	    
	     return null;
	}

}
