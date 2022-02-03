package net.hotel;

import java.io.IOException;

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
		boolean result =false;
		try {
			MultipartRequest multi = new MultipartRequest(req, readFolder,size, "utf-8",
					new DefaultFileRenamePolicy());
		
		}catch(Exception e) {
			forward.setPath("error/error.jsp");
			req.setAttribute("message", "회원가입 실패입니다.");
			forward.setRedirect(false);
		}
		
		return null;
	}
	

}
