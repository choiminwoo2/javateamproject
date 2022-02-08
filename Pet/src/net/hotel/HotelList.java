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
		int listcount = dao.getHotelCount();
		/*
		 * 총페이지 수 = db저장된 총 리스트 수 + 한페이지에서 보여주는 리스트의 수 -1 /한페이지에서 보여주는 리스트의 수
		 * 
		 */
		int maxpage = (listcount + limit -1) /limit;
		int startpage = ((page-1) / 10) * 10 +1;
		int endpage = startpage +10 -1;
		
		//만약 마지막 페이지그룹이 21~30이라면 보여주는 것이면 endpage는 30이게 되는데
		//만약 maxpage가 21~25까지라면 21~25까지만 표기되도록 한다.
		if(endpage > maxpage) {
			endpage = maxpage;
		}
		
		String state = req.getParameter("state");
		System.out.println("state= " + state);
		System.out.println("page= " + page);
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
			System.out.println("else진입");
			JsonObject obj = new JsonObject();
			JsonElement je = new Gson().toJsonTree(arr);
			obj.addProperty("page", page +1);
			obj.addProperty("maxpage", maxpage);
			obj.add("hotellist", je);
			if(arr != null) {
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
