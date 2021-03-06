package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		String num_sql = "select nvl(max(hi_no),0)+1 from hotel_info";
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
	
	//호텔all list end
	public List<Hotel> selectHotel(int page, int limit, String price, String weight, String location, String search, String animal) {
		String[] weights = {"5kglt","5ge8lt","8ge12lt","12gt"};
		String sql = " select * from (select " + 
				" rownum rnum,h.* from hotel h ";
		System.out.println("서치는=" +search);
		if(search != null && !search.equals("notItem")) {
			sql+= "where hotel_name like ? ";
		}else {
			sql+= "where hotel_name like '%%' ";
		}
		if(location != null && !location.equals("notItem")) {
			sql += "and hotel_addr like ? ";
		}
		if(animal != null && !animal.equals("notItem")) {
			sql += "and hotel_animal_grade = ? ";
		}
		if(weight != null && !weight.equals("notItem")) {
			for(int i=0; i < weights.length; i++) {
				if(weights[i].equals(weight)) {
					sql+="and hotel_price_"+weights[i];
					if(price.split(",").length > 1) {
						sql+=" between ? and ? ";
					}else {
						if(price.equals("50000")) {
							sql += " < ? ";
						}
						else if(price.equals("100000")) {
							sql += " >= ? ";
						}
					}
					
				}
			}
			
		}
		sql +="order by hotel_no desc) where " + 
					" rnum >= ? and rnum <= ?";
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int startrow = (page-1) * limit +1;
		//endrow는 페이지 곱하기  limit하면 됀다.
		int endrow = page * limit;
		List<Hotel> arr = new ArrayList<Hotel>();
		System.out.println("SQL= " + sql);
		try {
			conn = db.getConnect();
			pstmt = conn.prepareStatement(sql);
			int cnt = 0;
			if(search != null && !search.equals("notItem")) {
				pstmt.setString(++cnt, "%"+search+"%");
			}else {
				sql+= "where hotel_name like '%%' ";
			}
			if(location != null && !location.equals("notItem")) {
				pstmt.setString(++cnt, location +"%");
			}
			if(animal != null && !animal.equals("notItem")) {
				pstmt.setInt(++cnt, Integer.parseInt(animal));
			}
			if(weight != null && !weight.equals("notItem")) {
				for(int i=0; i < weights.length; i++) {
					if(weights[i].equals(weight)) {
						if(price.split(",").length > 1) {
							String[] temp = price.split(",");
							pstmt.setInt(++cnt, Integer.parseInt(temp[0]));
							pstmt.setInt(++cnt, Integer.parseInt(temp[1]));
						}else {
							if(price.equals("50000")) {
								pstmt.setInt(++cnt, Integer.parseInt(price));
							}
							else if(price.equals("100000")) {
								pstmt.setInt(++cnt, Integer.parseInt(price));
							}
						}
						
					}
				}
			}
			pstmt.setInt(++cnt, startrow);
			pstmt.setInt(++cnt, endrow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Hotel h = new Hotel();
				h.setHotel_no(rs.getInt(2));
				h.setHotel_name(rs.getString(3));
				h.setHotel_animal_grade(rs.getInt(4));
				h.setHotel_price_5lt(rs.getInt(5));
				h.setHotel_price_5ge8lt(rs.getInt(6));
				h.setHotel_price_8ge12lt(rs.getInt(7));
				h.setHotel_price_12gt(rs.getInt(8));
				h.setHotel_tel(rs.getString(9));
				h.setHotel_postcode(rs.getString(10));
				h.setHotel_addr(rs.getString(11));
				h.setHotel_addrdetail(rs.getString(12));
				h.setHotel_pthtofile(rs.getString(13));
				arr.add(h);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(conn, pstmt, rs);
		}
		return arr;
	}
	public int getHotelCount(String price, String weight, String location, String search, String animal) {
		int result = -1;
		String[] weights = {"5kglt","5ge8lt","8ge12lt","12gt"};
		String sql = "select count(*) from hotel ";
		System.out.println("서치는=" +search);
		if(search != null && !search.equals("notItem")) {
			sql+= "where hotel_name like ? ";
		}else {
			sql+= "where hotel_name like '%%' ";
		}
		if(location != null && !location.equals("notItem")) {
			sql += "and hotel_addr like ? ";
		}
		if(animal != null && !animal.equals("notItem")) {
			sql += "and hotel_animal_grade = ? ";
		}
		if(weight != null && !weight.equals("notItem")) {
			for(int i=0; i < weights.length; i++) {
				if(weights[i].equals(weight)) {
					sql+="and hotel_price_"+weights[i];
					if(price.split(",").length > 1) {
						sql+=" between ? and ? ";
					}else {
						if(price.equals("50000")) {
							sql += " < ? ";
						}
						else if(price.equals("100000")) {
							sql += " >= ? ";
						}
					}
					
				}
			}
			
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			int cnt=0;
			conn = db.getConnect();
			pstmt = conn.prepareStatement(sql);
			if(search != null && !search.equals("notItem")) {
				pstmt.setString(++cnt, "%"+search+"%");
			}else {
				sql+= "where hotel_name like '%%' ";
			}
			if(location != null && !location.equals("notItem")) {
				pstmt.setString(++cnt, location +"%");
			}
			if(animal != null && !animal.equals("notItem")) {
				pstmt.setInt(++cnt, Integer.parseInt(animal));
			}
			if(weight != null && !weight.equals("notItem")) {
				for(int i=0; i < weights.length; i++) {
					if(weights[i].equals(weight)) {
						if(price.split(",").length > 1) {
							String[] temp = price.split(",");
							pstmt.setInt(++cnt, Integer.parseInt(temp[0]));
							pstmt.setInt(++cnt, Integer.parseInt(temp[1]));
						}else {
							if(price.equals("50000")) {
								pstmt.setInt(++cnt, Integer.parseInt(price));
							}
							else if(price.equals("100000")) {
								pstmt.setInt(++cnt, Integer.parseInt(price));
							}
						}
					}
				}
			}
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(conn, pstmt, rs);
		}
		return result;
	}
	
}
