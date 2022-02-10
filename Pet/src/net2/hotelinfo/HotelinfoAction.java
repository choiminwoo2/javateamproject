package net2.hotelinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import dao.HotelDetailDAO;
import vo.HotelDetail;

public class HotelinfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		HotelDetailDAO dao = new HotelDetailDAO();
		int hi_no = Integer.parseInt(req.getParameter("num"));
		HotelDetail h = dao.getinfo(hi_no);
		
		HttpSession session=req.getSession();
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
