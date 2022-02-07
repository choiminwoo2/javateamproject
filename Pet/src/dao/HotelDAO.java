package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.DB;
import vo.Hotel;
import vo.HotelDetail;

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
	public int insertHotel(Hotel hotel) {
		int result = -1;
		Connection conn = db.getConnect();
		int num = -1;
		String num_sql = "select nvl(max(hotel_no),0)+1 from hotel";
		PreparedStatement pstmt =null;
		ResultSet rs  = null;
		try {
			pstmt = conn.prepareStatement(num_sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
			String sql = "insert into hotel values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2,hotel.getHotel_name());
			pstmt.setInt(3, hotel.getHotel_animal_grade());
			pstmt.setInt(4, hotel.getHotel_price_5lt());
			pstmt.setInt(5, hotel.getHotel_price_5ge8lt());
			pstmt.setInt(6, hotel.getHotel_price_8ge12lt());
			pstmt.setInt(7, hotel.getHotel_price_12gt());
			pstmt.setString(8, hotel.getHotel_tel());
			pstmt.setString(9, hotel.getHotel_postcode());
			pstmt.setString(10, hotel.getHotel_addr());
			pstmt.setString(11, hotel.getHotel_addrdetail());
			pstmt.setString(12, hotel.getHotel_pthtofile());
			pstmt.setString(13, hotel.getId());
			int re = pstmt.executeUpdate();
			if(re == 1) {
				System.out.println("호텔 등록성공");
				result = num;
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
	//호텔 디테일 insert start
	public int insertHotelDetail(HotelDetail vo) {
		int result = 0;
		Connection conn = db.getConnect();
		int num = -1;
		String num_sql = "select nvl(max(hotel_no),0)+1 from hotel_info";
		PreparedStatement pstmt =null;
		ResultSet rs  = null;
		try {
			pstmt = conn.prepareStatement(num_sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
			String sql = "insert into hotel_info values(?,?,?,?,sysdate,null,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2,vo.getHotel_no());
			pstmt.setString(3, vo.getHi_intro());
			pstmt.setString(4, vo.getHi_url());
			pstmt.setString(5, vo.getHi_photofiles());
			result= pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("호텔상세 등록성공");
			}else {
				System.out.println("호텔상세 등록 실패");
			}
			
		}catch(Exception e) {
		}finally {
			db.close(conn, pstmt, null);
		}
		return result;
	}
	//호텔 디테일 인설트 end
	//호텔 All List
	public ArrayList<Hotel> selectAllHotel() {
		String sql ="select * from hotel";
		ArrayList<Hotel> arr = new ArrayList<Hotel>();
		Connection conn=null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = db.getConnect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Hotel h = new Hotel();
				h.setHotel_no(rs.getInt(1));
				h.setHotel_name(rs.getString(2));
				h.setHotel_animal_grade(rs.getInt(3));
				h.setHotel_price_5lt(rs.getInt(4));
				h.setHotel_price_5ge8lt(rs.getInt(5));
				h.setHotel_price_8ge12lt(rs.getInt(6));
				h.setHotel_price_12gt(rs.getInt(7));
				h.setHotel_tel(rs.getString(8));
				h.setHotel_postcode(rs.getString(9));
				h.setHotel_addr(rs.getString(10));
				System.out.println("addr=" +  h.getHotel_addr().substring(0, h.getHotel_addr().indexOf(" ")));
				h.setHotel_addrdetail(rs.getString(11));
				h.setHotel_pthtofile(rs.getString(12));
				arr.add(h);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(conn, stmt, rs);
		}
		
		return arr;
		
	}
	//호텔all list end
}
