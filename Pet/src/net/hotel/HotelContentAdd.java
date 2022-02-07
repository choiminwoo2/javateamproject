package net.hotel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import dao.HotelDAO;
import vo.HotelDetail;

public class HotelContentAdd implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		HotelDetail vo = new HotelDetail();
		HotelDAO dao = new HotelDAO();
		System.out.println("콘텐츠진입");
		String file = req.getParameter("fileList");
		String content = req.getParameter("content");
		String link = req.getParameter("link");
		int num = Integer.parseInt(req.getParameter("num"));
		vo.setHotel_no(num);
		vo.setHi_intro(content);
		vo.setHi_photofiles(file);
		vo.setHi_url(link);
		System.out.println("file= " + file);
		System.out.println("content= " + content);
		System.out.println("link= " + link);
		System.out.println("num= " + num);
		try {
			int result = dao.insertHotelDetail(vo);
			if(result == 1) {
				forward.setRedirect(true);
				forward.setPath("hotelList.net");
				return forward;
			}else {
				res.setContentType("text/html; charset=utf-8");
				PrintWriter out = res.getWriter();
				out.println("<script>");
				out.println("alert('입력에 실패하셨습니다.')");
				out.println("history.back();");
				out.println("</script>");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
