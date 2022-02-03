package bo.reviewboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;

public class BoardWriteAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); //포워딩 방식으로 주소가 바뀌지 않아요.
		forward.setPath("reviewboard/boardWrite.jsp");
		return forward;
	}

}
