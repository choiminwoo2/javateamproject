package co.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import dao.UserDAO;
import vo.User;

public class UserLoginProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserDAO mdao = new UserDAO();
		User temp = mdao.UserSession(id);
		
		int result = mdao.isId(id, password);
		System.out.println("결과는" + result);
		
		//로그인 성공
		if (result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("password", password);
			session.setAttribute("temp", temp); //로그인한 유저 정보 
		
			String IDStore = request.getParameter("remember");
			Cookie cookie = new Cookie("id", id);
			
			// ID 기억하기
			if (IDStore != null && IDStore.equals("store")) {
			//쿠키의 유효시간을 24시간으로 설정합니다.
			cookie.setMaxAge(2*60);
			//클라이언트로 쿠키값을 전송합니다
			response.addCookie(cookie);
			} else {
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			}
			forward.setRedirect(true);
			forward.setPath("index.jsp"); //로그인 성공시 메인 페이지로 이동
			return forward;
		} else {
			String message = "비밀번호가 일치하지 않습니다. " ;
			if (result == -1)
				message = "아이디가 존재하지 않습니다.";
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('" + message + "');");
			out.println("location.href='login.co';");
			out.println("</script>");
			out.close();
			return null;
		}
	}
}
