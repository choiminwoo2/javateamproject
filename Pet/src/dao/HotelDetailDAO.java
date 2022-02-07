package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import vo.HotelDetail;

public class HotelDetailDAO {
	DB db = new DB();
	
	public HotelDetail getinfo(String hi_no) {
		Connection con= db.getConnect();
		HotelDetail m =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			
			String sql = "select hi_no,h.hotel_name,hi_intro,hi_url,hi_date,map_no from hotel_info e join hotel h on e.hotel_no = h.hotel_no where hi_no = ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,hi_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				m = new HotelDetail();
				m.setHi_no(rs.getInt(1));
				//m.setHotel_no(rs.geInt(2));
				m.setHotel_name(rs.getString(2));
				m.setHi_intro(rs.getString(3));
				m.setHi_url(rs.getString(4));
				m.setHi_date(rs.getString(5));
				m.setMap_no(rs.getInt(6));
				
			}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
					if (rs != null)
						try {
						rs.close();

				} catch (SQLException ex) {
					ex.printStackTrace();
				}
					if (pstmt != null)
						try {
						pstmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
					if (con != null)
						try {
						con.close();// 4단계:DB연결을 끊는다.
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			return m;
	}
	
}

