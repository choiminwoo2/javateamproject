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
import vo.Search;

public class HotelList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int limit = 10;
		int page = 1;
		Search search_obj = new Search();
		if(req.getParameter("page") != null && !req.getParameter("page").equals("")) {
			page = Integer.parseInt(req.getParameter("page"));
		}
		ActionForward forward = new ActionForward();
		HotelDAO dao = new HotelDAO();
		int listcount = dao.getHotelCount();
		/*
		 * 총페이지 수 = db저장된 총 리스트 수 + 한페이지에서 보여주는 리스트의 수 -1 /한페이지에서 보여주는 리스트의 수
		 * 
		 */
		int maxpage = (listcount + limit -1) /limit;
		int startpage = ((page-1) / 10) * 10 +1;
		int endpage = startpage +10 -1;
		String weight = req.getParameter("weight");
		String[] weightlist = null;
		if(weight != null) {
			weightlist = weight.split(",");
			if(weightlist.length == 2) {
				search_obj.setMax_weight(Integer.parseInt(weightlist[1]));
				search_obj.setMin_weight(Integer.parseInt(weightlist[0]));
			}else {
				search_obj.setMin_weight(Integer.parseInt(weightlist[0]));
			}
		}
		String animal = req.getParameter("animal");
		String location = req.getParameter("location");
		String price = req.getParameter("price");
		String[] pricelist = null;
		if(price != null) {
			pricelist = price.split(",");
			if(pricelist.length == 2) {
				search_obj.setMax_price(Integer.parseInt(pricelist[1]));
				search_obj.setMin_price(Integer.parseInt(pricelist[0]));
			}else {
				search_obj.setMin_price(Integer.parseInt(pricelist[0]));
			}
		}
		String search = req.getParameter("search");
		System.out.println("---------------");
		System.out.println("weight=" + weight);
		System.out.println("---------------");
		System.out.println("---------------");
		System.out.println("animal=" + animal);
		System.out.println("---------------");
		System.out.println("---------------");
		System.out.println("location=" + location);
		System.out.println("---------------");
		System.out.println("---------------");
		System.out.println("price=" + price);
		System.out.println("---------------");
		System.out.println("---------------");
		System.out.println("search=" + search);
		System.out.println("---------------");
		//만약 마지막 페이지그룹이 21~30이라면 보여주는 것이면 endpage는 30이게 되는데
		//만약 maxpage가 21~25까지라면 21~25까지만 표기되도록 한다.
		if(endpage > maxpage) {
			endpage = maxpage;
		}
		search_obj.setHotel_name(search);
		search_obj.setLoc(location);
		String state = req.getParameter("state");
		System.out.println("state= " + state);
		System.out.println("page= " + page);
		List<Hotel> arr = dao.selectHotel(page,limit,search_obj);
		if(state == null && price ==null &&
		   weight==null && location == null &&
		   animal ==null && search == null) {
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
