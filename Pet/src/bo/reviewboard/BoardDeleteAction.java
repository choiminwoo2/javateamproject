package bo.reviewboard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import dao.ReviewBoardDAO;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		boolean result=false;
	
		
		int review_no = Integer.parseInt(req.getParameter("review_no"));
		
		ReviewBoardDAO boarddao = new ReviewBoardDAO();
		
		result=boarddao.boardDelete(review_no);
		
		//삭제 처리 실패한 경우
		if(result==false) {
			System.out.println("리뷰 삭제 실패");
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			req.setAttribute("message", "데이터를 삭제하지 못했습니다.");
			forward.setPath("error/error.jsp");
			return forward;
	}
    //삭제 처리 성공한 경우 - 글 목록 보기 요청을 전송하는 부분입니다.
		System.out.println("리뷰 삭제 성공");
		res.setContentType("text/html;charset=utf-8");
		String hotel_name=req.getParameter("hotel_name");
		String hotel_no=req.getParameter("hotel_no");
		PrintWriter out = res.getWriter();
		out.println("<script>");
		out.println("alert('삭제되었습니다.');");
		out.println("location.href='BoardList.bo?hotel_no="+hotel_no+"&hotel_name=" + hotel_name+"';");
		out.println("</script>");
		out.close();
		return null;

}
}



