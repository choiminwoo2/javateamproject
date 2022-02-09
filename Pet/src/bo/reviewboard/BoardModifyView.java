package bo.reviewboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import dao.ReviewBoardDAO;
import vo.Review;

public class BoardModifyView implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();	   		
		ReviewBoardDAO boarddao = new ReviewBoardDAO();
		Review review =new Review();
	   	
	   	//파라미터로 전달받은 수정할 글 번호를 num변수에 저장합니다.
		int num=Integer.parseInt(req.getParameter("review_no"));
		//글 내용을 불러와서 review객체에 저장합니다.
	   	review=boarddao.getDetail(num);
	   	
	   	//글 내용 불러오기 실패한 경우입니다.
	   	if(review==null){
	   		System.out.println("(수정)상세보기 실패");
	   		forward = new ActionForward();
		   	forward.setRedirect(false);
		   	req.setAttribute("message", "수정 상세 보기 실패입니다.");
	   		forward.setPath("error/error.jsp");
	   		return forward;
	   	}
	   	System.out.println("(수정)상세보기 성공");
	   	
	   	//수정 폼 페이지로 이동할 때 원문 글 내용을 보여주기 때문에 review 객체를 
	   	//req 객체에 저장합니다.
	   	req.setAttribute("review", review);
	   	forward.setRedirect(false);
	   	//글 수정 폼 페이지로 이동하기위해 경로를 설정합니다.
   		forward.setPath("reviewboard/boardModify.jsp");
   		return forward;
 }
}


