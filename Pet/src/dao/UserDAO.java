package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import db.DB;
import vo.User;


public class UserDAO {
	DB db = new DB();
	private DataSource ds;
	
	public UserDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			} catch (Exception ex) {
				System.out.println("DB 연결 실패: " + ex);
		}
}

	public int isId(String id, String password) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result= -1; //아이디가 존재하지 않습니다.
		try {
			con = ds.getConnection();
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
		return result;
	}
	
	
	public int insert(User m) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		
		int result = 0; //초기값
		
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
			
			String num = "(select nvl(max(user_no),0)+1 from userdata)";
			
			String num2 = "(select nvl(max(animal_no),0)+1 from animal)";
			
			String num3 = "(select nvl(max(user_no),0) from userdata)";
			
			pstmt = con.prepareStatement(
					 "INSERT INTO userdata (user_no, id, password, nickname, tel, user_grant, regdate) VALUES ("+num+",?,?,?,?,?, sysdate)");
			
			
			pstmt2 = con.prepareStatement(
					 "INSERT INTO animal (animal_no, kind, kg, user_no) VALUES ("+num2+",?,?,"+num3+")");
			
			
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getNickname());
			pstmt.setString(4, m.getTel());
			pstmt.setInt(5, m.getUser_grant());
			result=pstmt.executeUpdate(); //삽입 성공시 result 는 1
			
			pstmt2.setString(1, m.getKind());
			pstmt2.setInt(2, m.getKg());
			pstmt2.executeUpdate();
			con.commit();
			
			
		  } catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			
			if (pstmt != null)
			try {
				
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			if (pstmt2 != null)
			try {
				
				pstmt2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			if (con != null)
			try {
				
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
}//insert end


	
	
	public int isId(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int result= -1;
		try {
			con = ds.getConnection();
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
		return result;
		}// isId end

	
	public int isNickname(String nickname) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		
		int result= -1;
		try {
			con = ds.getConnection();
			
			String sql = "select nickname from userdata where nickname = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nickname);
			rs = pstmt.executeQuery();
			
			
			
			if(rs.next()) { 
				result = 0;
				
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
		return result;
	}

	public User getDetail(String id) {
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			String sql = "select * from userdata where id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setNickname(rs.getString(3));
				user.setTel(rs.getString(4));
				user.setUser_grant(rs.getInt(5));
				user.setRegdate(rs.getDate(6));
			}
		} catch (SQLException ex) {
			 ex.printStackTrace();
		}  finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			try {
				if (pstmt != null)
				pstmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return user;
	} // getDetail end

	
}
