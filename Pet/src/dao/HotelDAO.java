package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DB;
import vo.Hotel;

public class HotelDAO {
	DB db = new DB();
	
	public int test() {
		Connection conn= db.getConnect();
		PreparedStatement pstmt =null;
		String sql = "";
		try {
			pstmt = conn.prepareStatement(sql);
			
		}catch(Exception e) {
		}finally {
			db.close(conn, pstmt, null);
		}
		return -1;
	}
	//인설트호텔 시작
	public boolean insertHotel(Hotel hotel) {
		boolean result = false;
		Connection conn = db.getConnect();
		PreparedStatement pstmt =null;
		String sql = "insert into hotel values(hotel_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,hotel.getHotel_name());
			pstmt.setInt(2, hotel.getHotel_price_5lt());
			pstmt.setInt(3, hotel.getHotel_price_5ge8lt());
			pstmt.setInt(4, hotel.getHotel_price_8ge12lt());
			pstmt.setInt(5, hotel.getHotel_price_12gt());
			pstmt.setString(6, hotel.getHotel_tel());
			pstmt.setString(7, hotel.getHotel_postcode());
			pstmt.setString(8, hotel.getHotel_addr());
			pstmt.setString(9, hotel.getHotel_addrdetail());
			pstmt.setString(10, hotel.getHotel_pthtofile());
			int re = pstmt.executeUpdate();
			if(re == 1) {
				System.out.println("호텔 등록성공");
				result = true;
			}else {
				System.out.println("호텔 등록 실패");
			}
			
		}catch(Exception e) {
		}finally {
			db.close(conn, pstmt, null);
		}
		return result;
		
	}
	//인설트 호텔 end
}
