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


public class BoardAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ReviewBoardDAO reviewdao = new ReviewBoardDAO();
		ActionForward forward=new ActionForward();
		
		Review review =new Review();
		//Review 객체에 폼에서 입력 받은 정보들을 저장합니다.
		review.setRb_id(req.getParameter("rb_id"));
		review.setRb_title(req.getParameter("rb_title"));
		review.setRb_text(req.getParameter("rb_text"));
		int hotel_no = Integer.parseInt(req.getParameter("hotel_no"));
		review.setHotel_no(hotel_no);
		String hotel_name = req.getParameter("hotel_name");
		
		
		Star star = new Star();
		star.setEv_score(Float.parseFloat(req.getParameter("starvalue")));
		star.setAnimal_info(req.getParameter("animal_info") + "/" + req.getParameter("weight"));
		star.setHotel_no(hotel_no);
		//글 등록 처리를 위해 DAO의 boardInsert()메서드를 호출합니다.
		//글 등록 폼에서 입력한 정보가 저장되어 있는 boarddata객체를 전달합니다.
		int result = reviewdao.boardInsert(review , star);
		
		//글 등록에 실패할 경우 false를 반환합니다.
		if(result==0) {
			System.out.println("리뷰 등록 실패");
			forward.setPath("error/error.jsp");
			req.setAttribute("message", "리뷰 등록 실패입니다.");
			forward.setRedirect(false);
			return forward;
		}
		System.out.println("리뷰 등록 완료");
		
		//글 등록이 완료되면 글 목록을 보여주기 위해 "BoardList.bo"로 이동합니다.
		//Redirect여부를 true로 설정합니다.
		forward.setRedirect(true);
		forward.setPath("BoardList.bo?hotel_no="+hotel_no);//이동할 경로를 지정합니다.
		return forward;
	}
		
	
}




