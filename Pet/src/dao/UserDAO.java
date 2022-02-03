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
	} //Member_info end

	public User UserSession(String id) {
		User temp = null;
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			
			String sql = "select * from userdata where id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				temp = new User();
				temp.setUser_no(rs.getInt(1));
				temp.setId(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setNickname(rs.getString(4));
				temp.setTel(rs.getString(5));
				temp.setUser_grant(rs.getInt(6));
				temp.setRegdate(rs.getDate(7));
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			db.close(con, pstmt, rs);
		}
		return temp;
	} //Member_info end
	
}
