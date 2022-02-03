package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import vo.Review;

public class ReviewBoardDAO {
	DB db = new DB();
	
	public int test() {
		Connection con= db.getConnect();
		return -1;
	}

	public int getListCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		try {
			con= db.getConnect();

			// 새로운 글을 등록하는 부분입니다.
			pstmt = con.prepareStatement("select count(*) from review_board");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception ex) {
			System.out.println("getListCount() 에러: " + ex);
		} finally {

			if (rs != null)
				try {
					rs.close();
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
		return x;
	}

	public List<Review> getBoardList(int page, int limit) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// page : 페이지
		// limt : 페이지 당 목록의 수
		// board_re_ref desc, board_re_seq asc에 의해 정렬한 것을
		// 조건절에 맞는 rnum의 범위 만큼 가져오는 쿼리문입니다.

		String board_list_sql = 
				  "select * "
		        + " from (select rownum rnum, j.* "
				      + " from (select * from review_board order by review_no) j " 
				      + " ) " 
				+ " where rnum>=? and rnum<=?";

		List<Review> list = new ArrayList<Review>();
		// 한 페이지당 10개씩 목록인 경우 1페이지,2페이지, 3페이지, 4페이지...
		int startrow = (page - 1) * limit + 1; // 읽기 시작할 row번호(1,11,21..
		int endrow = startrow + limit - 1; // 읽을 마지막 row 번호(10 20 30 40..
		try {
			con= db.getConnect();
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();

			// DB에서 가져온 데이터를 VO객체에 담습니다.
			while (rs.next()) {
				Review board = new Review();
				board.setReview_no(rs.getInt("review_no"));
				board.setRb_id(rs.getString("rb_id"));
				board.setRb_title(rs.getString("rb_title"));
				board.setRb_text(rs.getString("rb_text"));
				board.setRb_date(rs.getString("rb_date"));
				board.setRb_redate(rs.getString("rb_redate"));
				//board.setCnt(rs.getInt("cnt"));
				list.add(board); // 값을 담은 객체를 리스트에 저장합니다.
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("getBoardList() 에러: " + ex);
		} finally {

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
		return list;
	}
}
