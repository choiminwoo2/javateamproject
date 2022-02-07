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

public class UserListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		UserDAO mdao = new UserDAO();
		
		int page = 1;
		int limit = 10;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		List<User> list = null;
		int listcount = 0;
		int index= -1; 
		
		String search_word="";
		if (request.getParameter("search_word") == null
				|| request.getParameter("search_word").equals("")) {
		
			listcount = mdao.getListCount();
			list = mdao.getList(page, limit);
		}
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
		request.setAttribute("search_field", index);
		request.setAttribute("search_word", search_word);
		forward.setPath("user/userList.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
