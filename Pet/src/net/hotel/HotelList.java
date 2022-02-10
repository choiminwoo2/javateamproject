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
		String weight = null;
		String animal = null;
		String location = null;
		String price = null;
		String search = null;
		if(req.getParameter("search") != null) {
			search =req.getParameter("search");
		}
		if(req.getParameter("weight") != null) {
			weight =req.getParameter("weight");
		}
		if(req.getParameter("animal") != null) {
			animal =req.getParameter("animal");
		}
		if(req.getParameter("loc") != null) {
			location =req.getParameter("loc");
		}
		
		if(req.getParameter("price") != null) {
			price = req.getParameter("price");
		}
		System.out.println("---------------");
		System.out.println("animal=" + animal);
		System.out.println("---------------");
		System.out.println("location=" + location);
		System.out.println("---------------");
		System.out.println("---------------");
		System.out.println("search=" + search);
		System.out.println("---------------");
		System.out.println("weight=" + weight);
		System.out.println("---------------");
		System.out.println("price=" + price);
		System.out.println("---------------");
		String state = req.getParameter("state");
		System.out.println("state= " + state);
		System.out.println("page= " + page);
		int listcount = dao.getHotelCount(price,weight,location,search,animal);
		int maxpage = (listcount + limit -1) /limit;
		if(state == null && price ==null &&
		   weight==null && location == null &&
		   animal ==null && search == null) {
			System.out.println("모두 널일 때 진입");
			List<Hotel> arr = dao.selectHotel(page,limit,price,weight,location,search,animal);
			if(arr != null) {
				forward.setRedirect(false);
				req.setAttribute("hotellist", arr);
				System.out.println("arr=" + arr.size());
				forward.setPath("hotel/hotelListView.jsp");
				System.out.println("getpath로 감" + forward.getPath());
				return forward;
			}
			
			//ajax요청이라면
		}else {
			System.out.println("ajax요청");
			List<Hotel> arr = dao.selectHotel(page,limit,price,weight,location,search,animal);
			System.out.println("else진입");
			JsonObject obj = new JsonObject();
			JsonElement je = new Gson().toJsonTree(arr);
			obj.addProperty("page", page +1);
			obj.addProperty("maxpage", maxpage);
			obj.addProperty("animal", animal);
			obj.addProperty("loc", location);
			obj.addProperty("search", search);
			obj.addProperty("price", price);
			obj.addProperty("weight", weight);
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
