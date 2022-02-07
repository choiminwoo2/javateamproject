package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import vo.User;


public class UserDAO {
	DB db = new DB();
	

	public int isId(String id, String password) {
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result= -1; //아이디가 존재하지 않습니다.
		try {
			
			String sql = "select id, password from userdata where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) { 
				if(rs.getString(2).equals(password)) {
					result = 1; //아이디와 비밀번호가 일치하는 경우
				}else {
					result = 0; //비밀번호가 일치하지 않는 경우
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			db.close(con, pstmt, rs);
		}
		return result;
	}
	
	
	public int insert(User m) {
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		int no = 1;
		int result = 0; //초기값
		System.out.println("DAO진입");
		try {
			
			con.setAutoCommit(false);
			
			String num = "select nvl(max(user_no),0)+1 from userdata";//1
			pstmt = con.prepareStatement(num);
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				no = rs.getInt(1);
			}
			
			String num2 = "(select nvl(max(animal_no),0)+1 from animal)";
			
			pstmt.close();
			pstmt = con.prepareStatement(
					 "INSERT INTO userdata (user_no, id, password, nickname, tel, user_grant, regdate) "
					 + "VALUES ("+no+",?,?,?,?,?, sysdate)");
			
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getNickname());
			pstmt.setString(4, m.getTel());
			pstmt.setInt(5, m.getUser_grant());
			result=pstmt.executeUpdate(); //삽입 성공시 result 는 1
			
			if(m.getKg() != 0) {
				pstmt2 = con.prepareStatement(
						 "INSERT INTO animal (animal_no, kind, kg, user_no) VALUES ("+num2+",?,?,"+no+")");
				pstmt2.setString(1, m.getKind());
				pstmt2.setInt(2, m.getKg()); 
				pstmt2.executeUpdate();
				con.commit();
			}else {
				con.commit();
			}
			
			} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			db.close(con, pstmt, pstmt2, rs);
		}
		return result;
}//insert end
	
	public int isId(String id) {
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int result= -1;
		try {
			
			String sql = "select id from userdata where id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
				result = 0;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			db.close(con, pstmt, rs);
		}
		return result;
		}// isId end

	
	public int isNickname(String nickname) {
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		
		int result= -1;
		try {
			
			
			String sql = "select nickname from userdata where nickname = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nickname);
			rs = pstmt.executeQuery();
			System.out.println(nickname);
			if(rs.next()) { 
				result = 0;
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			db.close(con, pstmt, rs);
		}
		return result;
	}
/*
	public User nickname(String id) {
		User nickname = null;
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			String sql = "select * from userdata where id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				nickname = new User();
				nickname.setUser_no(rs.getInt(1));
				nickname.setId(rs.getString(2));
				nickname.setPassword(rs.getString(3));
				nickname.setNickname(rs.getString(4));
				nickname.setTel(rs.getString(5));
				nickname.setUser_grant(rs.getInt(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			db.close(con, pstmt, rs);
		}
		return nickname;
	} 
*/
	public User UserSession(String id) {
		User temp = null;
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		
		
		try {
			/*
			String no = "select user_no from userdata where id= ? ";
			pstmt = con.prepareStatement(no);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				no =  rs.getString(1);
			}
			*/
			
			String sql = "(select u.user_no, u.id, u.nickname, u.tel, u.user_grant, u.regdate, a.kind, a.kg from userdata u, animal a where u.id = ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				temp = new User();
				temp.setUser_no(rs.getInt(1));
				temp.setId(rs.getString(2));
				temp.setNickname(rs.getString(3));
				temp.setTel(rs.getString(4));
				temp.setUser_grant(rs.getInt(5));
				temp.setRegdate(rs.getDate(6));
				temp.setKind(rs.getString(7));
				temp.setKg(rs.getInt(8));
				
	}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			db.close(con, pstmt, rs);
			
		}
		return temp;
	} 


	public int modify(User m) {
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		
		int result = 0; //초기값
		System.out.println("회원정보 수정");
		try {
			
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(
					 "update userdata set password=?, nickname=?, tel=? where id = ?");
			
			pstmt.setString(1, m.getPassword());
			pstmt.setString(2, m.getNickname());
			pstmt.setString(3, m.getTel());
			pstmt.setString(4, m.getId());
			
			result=pstmt.executeUpdate(); //삽입 성공시 result 는 1
			
			if(m.getKg() != 0) {
				
				System.out.println("반려동물 정보수정");
				
				pstmt2 = con.prepareStatement(
						 "update animal set kind = ?, kg = ?");
				pstmt2.setString(1, m.getKind());
				pstmt2.setInt(2, m.getKg()); 
				pstmt2.executeUpdate();
				con.commit();
			}else {
				con.commit();
			}
			
			} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			db.close(con, pstmt, pstmt2, rs);
		}
		return result;
	}


	public int delete(String id) {
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
	
		ResultSet rs = null;
		
		int result = 0; //초기값
		
		try {
			
			
			pstmt = con.prepareStatement(
					 " delete from userdata where id= ? ");
			
			pstmt.setString(1, id);
			
			result=pstmt.executeUpdate(); //삭제 성공시 result 는 1
		
			System.out.println("회원정보 탈퇴진입");
			} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			db.close(con, pstmt, rs);
		}
		return result;
	}


	public int getListCount() {
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		
		try {
		
			pstmt = con.prepareStatement("select count(*) from userdata where id != 'admin'");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("getListCount() 에러: " + ex);
		}  finally {
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
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				
			}
		}
		return x;
	}


	public List<User> getList(int page, int limit) {
		List<User> list = new ArrayList<User>();
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			
			String sql = "select * "
					+" from (select b.*, rownum rnum"
					+" 		from(select * from userdata "
					+"           where id != 'admin'"
					+"             order by id) b"
					+         ")"
					+"   where rnum>=? and rnum<=?";
			pstmt = con.prepareStatement(sql);
			// 한 페이지당 10개씩 목록인 경우 1페이지, 2페이지, 3페이지, 4페이지 ...
			int startrow = (page - 1) * limit + 1;
					//읽기 시작할 row 번호 (1 11 21 31 ...
			int endrow = startrow + limit - 1;
					//읽을 마지막 row 번호 (10 20 30 40 ...
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				User m = new User();
				m.setUser_no(rs.getInt(1));
				m.setId(rs.getString("id"));
				m.setPassword(rs.getString(3));
				m.setNickname(rs.getString(4));
				m.setTel(rs.getString(5));
				m.setUser_grant(rs.getInt(6));
				m.setRegdate(rs.getDate(7));
				list.add(m);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}  finally {
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
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				
			}
		}
		return list;
	}
	
	public User user_info(String id) {
		User m = null;
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			
			String sql = "select * from userdata where id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				m = new User();
				m.setUser_no(rs.getInt(1));
				m.setId(rs.getString(2));
				m.setPassword(rs.getString(3));
				m.setNickname(rs.getString(4));
				m.setTel(rs.getString(5));
				m.setUser_grant(rs.getInt(6));
				m.setRegdate(rs.getDate(7));
			
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return m;
	}


	
}