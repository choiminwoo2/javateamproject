package bo.reviewboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import dao.ReviewBoardDAO;
import vo.Review;
import vo.Star;

public class BoardModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		ReviewBoardDAO boarddao = new ReviewBoardDAO();
		Review review =new Review();
		
			int review_no = Integer.parseInt(req.getParameter("review_no"));
			
		
			//review 객체에 글 수정 폼에서 입력받은 정보들을 저장합니다.
			review.setReview_no(review_no);
			review.setRb_title(req.getParameter("rb_title"));
			review.setRb_text(req.getParameter("rb_text"));
			review.setRb_date(req.getParameter("rb_date"));
			
			
			
			Star star = new Star();
			star.setEv_score(Float.parseFloat(req.getParameter("starvalue")));
			System.out.println("별점(req)=" + req.getParameter("starvalue"));
			System.out.println("별점=" + star.getEv_score());
			star.setAnimal_info(req.getParameter("animal_info") + "/" + req.getParameter("weight") +"KG");
			star.setEv_no(Integer.parseInt(req.getParameter("ev_no")));
			
			
			//DAO에서 수정 메서드 호출하여 수정합니다.
			boolean result = boarddao.boardModify(review,star);
			
			//수정에 실패한 경우
			if(result == false) {
				System.out.println("리뷰 수정 실패");
				forward.setRedirect(false);
				req.setAttribute("message", "리뷰 수정이 되지 않았습니다.");
				forward.setPath("error/error.jsp");
				return forward;
			}
			//수정 성공의 경우
			System.out.println("게시판 수정 완료");
			
			forward.setRedirect(true);
			//수정한 글 내용을 보여주기 위해 글 내용 보기 페이지로 이동하기 위해 경로를 설정합니다.
			forward.setPath("BoardDetailAction.bo?review_no=" + review.getReview_no());
			return forward;
		
	}
}
