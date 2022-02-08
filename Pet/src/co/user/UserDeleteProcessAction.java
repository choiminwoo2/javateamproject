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
		
		
		
		String id = request.getParameter("id");
		System.out.println("ID=" + id);
		
		UserDAO mdao = new UserDAO(); 
		int result = mdao.delete(id);
		
		if(result ==1) {
			request.getSession().invalidate();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			String message = "정상적으로 탈퇴 되셨습니다.";
			out.println("<script>");
			out.println("alert('" + message + "');");
			out.println("location.href='index.jsp';");
			out.println("</script>");
			out.close();
		}
		return null;
  }
}
