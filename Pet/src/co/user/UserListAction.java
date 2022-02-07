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
		int index= -1; //search_field 에 존재하지 않는 값으로 초기화
		
		String search_word="";
		
		//메뉴-관리자-회원정볼 클릭한 경우(member_list.net)
		//또는 메뉴-관리자-회원정보 클릭후 페이지 클릭한 경우
		//(member_list.net?page=2&search_field=-1&search_word=)
		if (request.getParameter("search_word") == null
				|| request.getParameter("search_word").equals("")) {
			//총 리스트 수를 받아옵니다.
			listcount = mdao.getListCount();
			list = mdao.getList(page, limit);
		} /*else { //검색을 클릭한 경우
			index = Integer.parseInt(request.getParameter("search_field"));
			String[] search_field = new String[] {"id", "nickname" };
			search_word = request.getParameter("search_word");
			listcount = mdao.getListCount(search_field[index], search_word);
			list = mdao.getList(search_field[index], search_word, page, limit);
		}
		*/
		int maxpage = (listcount + limit -1)/limit;
		int startpage = ((page -1)/10)*10 +1;
		int endpage = startpage + 10 -1;
		if (endpage > maxpage) endpage = maxpage;
		
		request.setAttribute("page", page); //현재 페이지 수
		request.setAttribute("maxpage", maxpage); // 최대 페이지 수
		
		//현재 페이지에 표시할 첫 페이지 수
		request.setAttribute("startpage", startpage);
		
		//현재 페이지에 표시할 끝 페이지 수
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
