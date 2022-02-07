package bo.reviewboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import dao.ReviewBoardDAO;
import vo.Review;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ReviewBoardDAO boarddao = new ReviewBoardDAO();
		Review review =new Review();
		
		//글 번호 파라미터 값을 num변수에 저장합니다.
		int num=Integer.parseInt(req.getParameter("num"));
		
		
		//글의 내용을 DAO에서 읽은 후 얻은 결과를 review 객체에 저장합니다.
		review=boarddao.getDetail(num);
		
		//review=null; //error테스트를 위한 값 설정
		//DAO에서 글의 내용을 읽지 못했을 경우 null을 반환합니다.
		if(review==null) {
			System.out.println("상세보기 실패");
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);;
			req.setAttribute("message", "데이터를 읽지 못했습니다.");
			forward.setPath("error/error.jsp");
			return forward;
		}
		System.out.println("상세보기 성공");
		
		//review 객체를 request 객체에 저장합니다.
		req.setAttribute("review", review);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		//글 내용 보기 페이지로 이동하기 위해 경로를 설정합니다.
		forward.setPath("reviewboard/boardView.jsp");
		return forward;

	}

}
