package net.hotel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import action.ActionForward;
import dao.HotelDAO;
import vo.Hotel;

public class HotelAddOk implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		HotelDAO dao = new HotelDAO();
		Hotel hotel = new Hotel();
		
		String readFolder = "";
		
		String saveFolder = "hotel/img";
		
		//5바이트 => 5키로 바이트 => 5메가 바이트
		int size = 5 * 1024 * 1024;
		
		ServletContext sc = req.getServletContext();
		
		
		readFolder = sc.getRealPath(saveFolder);
		System.out.println("==========리드 폴더===========");
		System.out.println("readFolder=" +readFolder);
		int result =-1;
		try {
			MultipartRequest multi = new MultipartRequest(req, readFolder,size, "utf-8",
					new DefaultFileRenamePolicy());
			String hotel_name = multi.getParameter("hotel_name");
			System.out.println("호텔 이름:" +hotel_name);
			String[] hotel_weight = {multi.getParameter("hotel_weight_5lt"),
					multi.getParameter("hotel_weight_5ge8lt"),
					multi.getParameter("hotel_weight_8ge12lt"),
					multi.getParameter("hotel_weight_12ge")};
			for(String s : hotel_weight) {
				System.out.println("호텔 무게 5~12까지 순서대로"+s);
			}
			String hotel_tel = multi.getParameter("hotel_tel");
			System.out.println("호텔 전화번호= "+ hotel_tel);
			String[] postcode = multi.getParameterValues("post1");
			for(String s : postcode) {
				System.out.println("주소 순서순대로"+ s);
			}
			String file_name = multi.getOriginalFileName("hotel_file");
			System.out.println("파일이름= "+file_name);
			hotel.setHotel_name(hotel_name);
			hotel.setHotel_price_5lt(Integer.parseInt(hotel_weight[0]));
			hotel.setHotel_price_5ge8lt(Integer.parseInt(hotel_weight[1]));
			hotel.setHotel_price_8ge12lt(Integer.parseInt(hotel_weight[2]));
			hotel.setHotel_price_12gt(Integer.parseInt(hotel_weight[3]));
			hotel.setHotel_tel(hotel_tel);
			hotel.setHotel_postcode(postcode[0]);
			hotel.setHotel_addr(postcode[1]);
			hotel.setHotel_addrdetail(postcode[2]);
			hotel.setHotel_pthtofile(file_name);
			result = dao.insertHotel(hotel);
			System.out.println(result);
			if(result != -1) {
				forward.setRedirect(false);
				req.setAttribute("num", result);
				forward.setPath("hotel/hotelDetailAddView.jsp");
			}else {
				res.setContentType("text/html; charset=utf-8");
				PrintWriter out = res.getWriter();
				
				out.println("<script>");
				out.println("alert('입력에 실패하셨습니다.')");
				out.println("history.back();");
				out.println("</script>");
			}
		}catch(Exception e) {
			forward.setPath("error/error.jsp");
			req.setAttribute("message", "호텔 등록 실패입니다.");
			forward.setRedirect(false);
		}
		
		return forward;
	}
	

}
