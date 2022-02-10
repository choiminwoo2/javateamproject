package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DB;
import vo.HotelDetail;

public class HotelDetailDAO {
	DB db = new DB();

	public HotelDetail getinfo(int hi_no) {
		Connection con = db.getConnect();
		HotelDetail h = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			String sql = "select hi_no, h.hotel_name, hi_intro, hi_url"
					   + "     , hi_date, map_no, hi_photofiles, hotel_photofile"
					   + "     , hotel_price_5kglt, hotel_price_5ge8let, hotel_price_8ge12lt, hotel_price_12gt"
					   + "     , e.hotel_no, hotel_tel, hotel_addr, hotel_addr_detail "
					   + "from hotel_info e join hotel h on e.hotel_no = h.hotel_no "
					   + "where hi_no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, hi_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				h = new HotelDetail();

				h.setHi_no(rs.getInt(1));
				h.setHotel_name(rs.getString(2));
				h.setHi_intro(rs.getString(3));
				h.setHi_url(rs.getString(4));
				h.setHi_date(rs.getString(5));
				h.setMap_no(rs.getInt(6));
				h.setHi_photofiles(rs.getString(7));
                h.setHotel_photofile(rs.getString(8));
                h.setHotel_price_5lt(rs.getInt(9));
                h.setHotel_price_5ge8lt(rs.getInt(10));
                h.setHotel_price_8ge12lt(rs.getInt(11));
                h.setHotel_price_12gt(rs.getInt(12));
                h.setHotel_no(rs.getInt(13));
                h.setHotel_tel(rs.getString(14));
                h.setHotel_addr(rs.getString(15));
                h.setHotel_addr_detail(rs.getString(16));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(con, pstmt, rs);
		}
		return h;
	}

}
