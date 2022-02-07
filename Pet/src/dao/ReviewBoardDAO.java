package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import vo.Review;
import vo.Star;

public class ReviewBoardDAO {
	DB db = new DB();

	public int getListCount(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		try {
			con = db.getConnect();

			// 새로운 글을 등록하는 부분입니다.
			pstmt = con.prepareStatement("select count(*) from review_board where hotel_no=?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception ex) {
			System.out.println("getListCount() 에러: " + ex);
		} finally {

			db.close(con, pstmt, rs);
		}
		return x;
	}

	public List<Review> getBoardList(int page, int limit, int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// page : 페이지
		// limt : 페이지 당 목록의 수
		// board_re_ref desc, board_re_seq asc에 의해 정렬한 것을
		// 조건절에 맞는 rnum의 범위 만큼 가져오는 쿼리문입니다.

		String board_list_sql = "select * " + " from (select rownum rnum, j.* "
				+ " from (select * from review_board where hotel_no=? order by review_no desc) j " + " ) "
				+ " where rnum>=? and rnum<=?";

		List<Review> list = new ArrayList<Review>();
		// 한 페이지당 10개씩 목록인 경우 1페이지,2페이지, 3페이지, 4페이지...
		int startrow = (page - 1) * limit + 1; // 읽기 시작할 row번호(1,11,21..
		int endrow = startrow + limit - 1; // 읽을 마지막 row 번호(10 20 30 40..
		try {
			con = db.getConnect();
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, no);
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, endrow);
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
				// board.setCnt(rs.getInt("cnt"));
				list.add(board); // 값을 담은 객체를 리스트에 저장합니다.
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("getBoardList() 에러: " + ex);
		} finally {
			db.close(con, pstmt, rs);
		}
		return list;
	}

	public int boardInsert(Review review, Star star) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;

		try {
			con = db.getConnect();

			// 트랜잭션을 이용하기 위해서 setAutoCommit을 false로 설정합니다.
			con.setAutoCommit(false);

			String review_no = "select nvl(max(review_no),0)+1 from review_board";

			pstmt = con.prepareStatement(review_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1);
			}
			pstmt.close();

			String review_sql = "insert into review_board " 
			+ "values(?," + num + ",?,?,?,sysdate,null)";

			pstmt = con.prepareStatement(review_sql);
			pstmt.setInt(1, review.getHotel_no());
			pstmt.setString(2, review.getRb_id());
			pstmt.setString(3, review.getRb_title());
			pstmt.setString(4, review.getRb_text());
			pstmt.executeUpdate();
			pstmt.close();

			String ev_no = "(select nvl(max(ev_no),0)+1 from evaluation)";
			String star_sql = "insert into evaluation "
			+ " values(" + ev_no + "," 
					+ "  ?," + num 
					+ ",?, ?)";

			pstmt = con.prepareStatement(star_sql);
			pstmt.setInt(1, star.getHotel_no());
			pstmt.setFloat(2, star.getEv_score());
			pstmt.setString(3, star.getAnimal_info());

			if (pstmt.executeUpdate() == 1) {
				con.commit(); // commit합니다.
			} else {
				con.rollback();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("boardReply() 에러 : " + ex);
			if (con != null) {
				try {
					con.rollback(); // rollback합니다.
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.setAutoCommit(true);
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return num;
	}// boardReply()메서드 end

	public float getStaravg(int no) {
		
		//    select avg(ev_score) from EVALUATION where hotel_no=1
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		float x = 0;
		try {
			con = db.getConnect();

			// 새로운 글을 등록하는 부분입니다.
			pstmt = con.prepareStatement("select round(avg(ev_score),1) from EVALUATION where hotel_no=?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getFloat(1);
			}
		} catch (Exception ex) {
			System.out.println("getStaravg() 에러: " + ex);
		} finally {

			db.close(con, pstmt, rs);
		}
		return x;
	}

	//글 내용 보기
	public Review getDetail(int num) {
			Review board = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = db.getConnect();
				pstmt = con.prepareStatement("select * from review_board inner join EVALUATION " + 
						"   on REVIEW_BOARD.REVIEW_NO=EVALUATION.REVIEW_NO"
						+ "  where review_board.review_no=? ");
				pstmt.setInt(1, num);
				rs=pstmt.executeQuery();
				
			if (rs.next()) {
				board = new Review();
                board.setEv_no(rs.getInt("ev_no"));
				board.setReview_no(rs.getInt(2));
				board.setHotel_no(rs.getInt(1));
				board.setRb_id(rs.getString("rb_id"));
				board.setRb_title(rs.getString("rb_title"));
				board.setRb_text(rs.getString("rb_text"));
				board.setRb_date(rs.getString("rb_date"));
				board.setRb_redate(rs.getString("rb_redate"));
				board.setEv_score(rs.getFloat("ev_score"));
				board.setAnimal_info(rs.getString("animal_info"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("getDetail() 에러: " + ex);
		} finally {

		db.close(con, pstmt, rs);
		}
		return board;
	}
    //글 수정
	public boolean boardModify(Review review, Star star) {
		Connection con = null;
		PreparedStatement pstmt = null;
	
		String sql = "update review_board "
				   + "set rb_title=?, rb_text=? "
				   + "where review_no = ?";
		try {
			con = db.getConnect();
			// 트랜잭션을 이용하기 위해서 setAutoCommit을 false로 설정합니다.
						con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, review.getRb_title());
			pstmt.setString(2, review.getRb_text());
			pstmt.setInt(3, review.getReview_no());
			int result1=pstmt.executeUpdate();
			pstmt.close();
			
			sql = "update evaluation "
					   + "set ev_score=?, animal_info=? "
					   + "where ev_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setFloat(1, star.getEv_score());
			pstmt.setString(2, star.getAnimal_info());
			pstmt.setInt(3, star.getEv_no());
			int result2=pstmt.executeUpdate();
			if(result1==1&&result2==1) {
				con.commit();
			}
			return true;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("boardReply() 에러 : " + ex);
			if (con != null) {
				try {
					con.rollback(); // rollback합니다.
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} finally {
			
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.setAutoCommit(true);
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return false;
	}
	
}
