package co.user;

import java.io.IOException;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import vo.User;
import dao.UserDAO;
import action.Action;
import action.ActionForward;


public class UserModifyProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			int kg=0;
			if(request.getParameter("kg") != null && !request.getParameter("kg").equals("")) {
			 kg = Integer.parseInt(request.getParameter("kg"));
			}
			
			int user_no = Integer.parseInt(request.getParameter("user_no"));
			System.out.println("유저번호=" + user_no);
			
			String id = request.getParameter("id");
			System.out.println("ID=" + id);
			String password = request.getParameter("password");
			System.out.println("Pass=" + password);
			String nickname = request.getParameter("nickname");
			System.out.println("닉네임=" + nickname);
			
			
			String tel = request.getParameter("tel");
			System.out.println("전화번호=" + tel);
			int user_grant = Integer.parseInt(request.getParameter("user_grant"));
			System.out.println("권한=" + user_grant);
		
			String kind = request.getParameter("kind");
			System.out.println("종류=" + kind);
			System.out.println("몸무게=" + kg);
			
			User m = new User();
			m.setId(id);     	m.setPassword(password);	 m.setNickname(nickname);
			m.setTel(tel); 	   	m.setUser_no(user_no);
			m.setKind(kind);     m.setKg(kg);
			
			UserDAO udao = new UserDAO(); 
			int result = udao.modify(m);
			
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			
			//삽입 성공
			if (result == 1) {
				HttpSession session = request.getSession();
				User temp = (User) session.getAttribute("temp");
				temp.setNickname(nickname);
				
				out.println("alert('수정되었습니다.');");
				out.println("location.href='index.jsp';");
			} else {
				out.println("alert('회원 정보 수정에 실패했습니다.');");
				out.println("history.back()");	
			}
			out.println("</script>");
			out.close();
		
			
			User userinfo = new User();
			userinfo = udao.UserSession(id);
			request.setAttribute("userinfo", userinfo);
		
			return null;
			
		
	} 
}
