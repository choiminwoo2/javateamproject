package co.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import dao.UserDAO;

public class UserDeleteCheckProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = request.getParameter("password");
		System.out.println("Password=" + password);
		
		UserDAO mdao = new UserDAO(); 
		int result = mdao.deletecheck(password);
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if(result ==1) {
			out.println("location.href='userdeleteview.co';");
		}else {
			out.println("alert('비밀번호가 다릅니다.');");
			out.println("location.href='index.jsp';");
		}
		out.println("</script>");
		out.close();
		return null;
	}
}
