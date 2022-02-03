package co.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import dao.UserDAO;

import vo.User;




public class UserJoinProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String tel = request.getParameter("tel");
		int user_grant = Integer.parseInt(request.getParameter("user_grant"));
		String kind = request.getParameter("kind");
		int kg = Integer.parseInt(request.getParameter("kg"));
		
		User m = new User();
		
		m.setId(id);     	m.setPassword(password);	 m.setNickname(nickname);
		m.setTel(tel); 	   	m.setUser_grant(user_grant);  
		m.setKind(kind);     m.setKg(kg);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		UserDAO mdao = new UserDAO(); 
		int result = mdao.insert(m);
	
		
		if(result==0) {
			System.out.println("회원 가입 실패입니다.");
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			request.setAttribute("message", "회원 가입 실패입니다.");
			forward.setPath("error/error.jsp");
			return forward;
		}
		
		out.println("<script>");
		if (result == 1) { 
			out.println("alert('회원 가입을 축하합니다.');");
			out.println("location.href='index.jsp';");
		} else if (result == -1) {
			out.println("alert('아이디가 중복되었습니다. 다시 입력하세요');");
			
			out.println("history.back()"); 
		}
		out.println("</script>");
		out.close();
		return null;
	}

}
