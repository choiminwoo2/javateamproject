package co.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import action.ActionForward;


public class UserLogOutAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		request.getSession().invalidate();
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String message = "로그아웃 되셨습니다.";
		out.println("<script>");
		out.println("alert('" + message + "');");
		out.println("location.href='index.jsp';");
		out.println("</script>");
		out.close();
	
		return null;
		
	}
			
}
