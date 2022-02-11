package net.hotel;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import action.Action;
import action.ActionForward;

public class HotelDetailAdd implements Action {
	
	private static final String CHARSET = "utf-8";
	private static final String SAVE_DIR = "hotel/img";
	private static final int LIMIT_SIZE_BYTES = 20 * 1024 * 1024;

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		String readFolder = "";

		//5바이트 => 5키로 바이트 => 5메가 바이트
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletContext sc = req.getServletContext();
		readFolder = sc.getRealPath(SAVE_DIR);
		File attachesDir = new File(readFolder);
		factory.setRepository(attachesDir);
		factory.setSizeThreshold(LIMIT_SIZE_BYTES);
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		int num = -1;
		try {
			List<FileItem> items = fileUpload.parseRequest(req);
			List<String> temp = new ArrayList<String>();
			for(FileItem item : items) {
				if(item.isFormField()) {
					System.out.printf("파라미터명 : %s, 파라미터 값: %s \n", item.getFieldName(), item.getString(CHARSET));
					num = Integer.parseInt(item.getString(CHARSET));
				}else {
					System.out.printf("파라미터명 : %s, 파라미터 값: %s \n",item.getFieldName(),item.getName(),item.getSize());
					if(item.getSize() >0) {
						String separator = File.separator;
						int index = item.getName().lastIndexOf(separator);
						String fileName = item.getName().substring(index +1);
						System.out.println("fileNmae=" + fileName);
						File uploadFile = new File(readFolder + separator + fileName);
						temp.add(fileName);
						System.out.println("tempsize=" + temp.size());
						item.write(uploadFile);
						System.out.println("업로드 파일 네임 =" + readFolder + separator + fileName);
					}
				}
			}
			if(items != null) {
				String[] tempFileList = temp.stream().toArray(String[]::new); 
				String dbfile = String.join(",", tempFileList);
				System.out.println("db에 들어가는 파일리스트" +dbfile);
				forward.setRedirect(false);
				req.setAttribute("files", dbfile);
				req.setAttribute("num", num);
				forward.setPath("hotel/hotelcontentadd.jsp");
				return forward;
			}else {
				res.setContentType("text/html; charset=utf-8");
				PrintWriter out = res.getWriter();
				out.println("<script>");
				out.println("alert('입력에 실패하셨습니다.')");
				out.println("history.back();");
				out.println("</script>");
			}
		System.out.println("==========리드 폴더===========");
		System.out.println("readFolder=" +readFolder);
		}catch(Exception e) {
			e.printStackTrace();
		}
			return null;
	}
}
