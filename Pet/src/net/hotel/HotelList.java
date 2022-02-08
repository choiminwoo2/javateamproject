package net.hotel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import action.Action;
import action.ActionForward;
import dao.HotelDAO;
import vo.Hotel;

public class HotelList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int limit = 10;
		int page = 1;
		
		if(req.getParameter("page") != null && !req.getParameter("page").equals("")) {
			page = Integer.parseInt(req.getParameter("page"));
		}
		ActionForward forward = new ActionForward();
		HotelDAO dao = new HotelDAO();
		List<Hotel> arr = dao.selectHotel(page,limit);
		
		String state = req.getParameter("state");
		
		if(state == null) {
			if(arr != null) {
				forward.setRedirect(false);
				req.setAttribute("hotellist", arr);
				System.out.println("arr=" + arr.size());
				for(Hotel h : arr) {
					System.out.println(h.toString());
				}
				forward.setPath("hotel/hotelListView.jsp");
				return forward;
			}
			//ajax요청이라면
		}else {
			JsonObject obj = new JsonObject();
			JsonElement je = new Gson().toJsonTree(arr);
			
			obj.add("hotellist", je);
			if(arr != null) {
				forward.setRedirect(false);
				req.setAttribute("list", obj);
				System.out.println("arr=" + arr.size());
				System.out.println("-------------josn------------");

				res.setContentType("text/html; charset=utf-8");
				res.getWriter().append(obj.toString());
				System.out.println(obj.toString());
				return null;
			}
		}
		return null;
	}

}
