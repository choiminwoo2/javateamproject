package net2.hotelinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import dao.HotelDetailDAO;
import vo.HotelDetail;
import dao.UserDAO;
import vo.User;
import vo.Wishlist;

public class HotelinfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		HotelDetailDAO dao = new HotelDetailDAO();
		int hi_no = Integer.parseInt(req.getParameter("num"));
		HotelDetail h = dao.getinfo(hi_no);
		
		UserDAO udao = new UserDAO();
		HttpSession session=req.getSession();
		if (session.getAttribute("id")==null) {
			
			String message = "로그인 후 이용이 가능합니다.";
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('" + message + "');");
			out.println("location.href='login.co';");
			out.println("</script>");
			out.close();
			return null;
			
		}
		User user = (User) session.getAttribute("temp");
		int user_no = user.getUser_no();
		int hotel_no = Integer.parseInt(req.getParameter("num"));
		
		Wishlist jjim = udao.Jjimcheck(hotel_no, user_no);
		req.setAttribute("wish", jjim);//0아니면 1이상 값
		
		session.setAttribute("hotel_no", h.getHotel_no());
		session.setAttribute("hotel_name",h.getHotel_name());
		session.setAttribute("hi_photofiles", h.getHi_photofiles());
		session.setAttribute("img", h.getHotel_photofile());
		req.setAttribute("hotelinfo", h);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); //주소 변경없이 jsp페이지의 내용을 보여줍니다.
	    forward.setPath("hotelDetail/hotelinfo.jsp");
	    return forward;
	}

}
