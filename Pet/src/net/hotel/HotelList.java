package net.hotel;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;

import action.Action;
import action.ActionForward;
import dao.HotelDAO;
import vo.Hotel;

public class HotelList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		HotelDAO dao = new HotelDAO();
		ArrayList<Hotel> arr = dao.selectAllHotel();
		if(arr != null) {
			forward.setRedirect(false);
			req.setAttribute("hotel_list", arr);
			System.out.println("arr=" + arr.size());
			forward.setPath("hotel/hotelListView.jsp");
			return forward;
		}
		return null;
	}

}
