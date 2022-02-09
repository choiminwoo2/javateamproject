package co.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import dao.UserDAO;
import vo.User;
import vo.Wishlist;

public class UserMyListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		UserDAO udao = new UserDAO();
		Wishlist jjim = new Wishlist();
	
		
		int page = 1;
		int limit = 10;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		List<User> list = null;
		int listcount = 0;
		
		listcount = udao.getListCount();
		list = udao.getList(page, limit);
	
		int maxpage = (listcount + limit -1)/limit;
		int startpage = ((page -1)/10)*10 +1;
		int endpage = startpage + 10 -1;
		if (endpage > maxpage) endpage = maxpage;
		
		request.setAttribute("page", page); 
		request.setAttribute("maxpage", maxpage); 
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("totallist", list);
		
		String id = request.getParameter("id");
		int user_no = Integer.parseInt(request.getParameter("usr_no"));
		jjim = udao.MyList(user_no);
		
		request.setAttribute("jjim", jjim);
		forward.setPath("user/mylist.jsp");
		return forward;
		
		
		
	
		
		
	}

}
