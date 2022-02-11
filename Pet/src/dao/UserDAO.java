package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import vo.Hotel;
import vo.User;
import vo.Wishlist;


public class UserDAO {
	DB db = new DB();
	

	public int isId(String id, String password) {
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result= -1; //아이디가 없는 경우
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
		int result = 0; 
		System.out.println("insert DAO진입");
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
}
	
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
		}

	
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

	public User UserSession(String id) {
		User temp = null;
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "(select user_no, id, nickname,tel, user_grant, regdate from userdata where id = ?)";
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
		
		
		
		int result = 0;
		System.out.println("회원정보 수정진입");
		try {
			
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(
					 "update userdata set password=?, nickname=?, tel=? where id = ?");
			
			pstmt.setString(1, m.getPassword());
			pstmt.setString(2, m.getNickname());
			pstmt.setString(3, m.getTel());
			pstmt.setString(4, m.getId());
			
			result=pstmt.executeUpdate(); //성공시 result 는 1
			
			if(m.getKg() != 0) {	//일반 회원의 경우
				
				System.out.println("반려동물 정보수정");
				
				pstmt2 = con.prepareStatement(
						 "update animal set kind = ?, kg = ? where user_no = ?"); //fk인 유저 번호에 해당하는 반려동물 정보수정
				pstmt2.setString(1, m.getKind());
				pstmt2.setInt(2, m.getKg()); 
				pstmt2.setInt(3, m.getUser_no());
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

	//회원 탈퇴
	public int delete(String id) {
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
	
		ResultSet rs = null;
		
		int result = 0; 
		
		try {
			pstmt = con.prepareStatement(
					 " delete from userdata where id= ? ");
			
			pstmt.setString(1, id);
			
			result=pstmt.executeUpdate(); //성공시 result 는 1
		
			System.out.println("회원정보 탈퇴진입");
			} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			db.close(con, pstmt, rs);
		}
		return result;
	}


	public int getMyListCount(int user_no) {
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
		    String sql = "select count(*) from hotel where hotel_no in (select hotel_no from wishlist where user_no = ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("getListCount() 에러: " + ex);
		}  finally {
			db.close(con, pstmt, rs);
		}
		return result;
	}

	public int getListCount() {
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
		    String sql = "select count(*) from userdata where id != 'admin'";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("getListCount() 에러: " + ex);
		}  finally {
			db.close(con, pstmt, rs);
		}
		return result;
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
			
			int startrow = (page - 1) * limit + 1;
					
			int endrow = startrow + limit - 1;
					
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
			System.out.println(list);
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}  finally {
			db.close(con, pstmt, rs);
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
			db.close(con, pstmt, rs);
		}
		return m;
	}


	public User AnimalSession(int user_no) {
		User m = null;
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			
			String sql = "(select u.user_no, u.id, u.nickname, u.tel, u.user_grant, u.regdate, a.kind, a.kg from userdata u, animal a where a.user_no = ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				m = new User();
				m.setUser_no(rs.getInt(1));
				m.setId(rs.getString(2));
				m.setNickname(rs.getString(3));
				m.setTel(rs.getString(4));
				m.setUser_grant(rs.getInt(5));
				m.setRegdate(rs.getDate(6));
				m.setKind(rs.getString(7));
				m.setKg(rs.getInt(8));
			
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			db.close(con, pstmt, rs);
		}
		return m;
	}

	//찜하기
	public int Jjiminsert(int user_no, int hotel_no) {
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int wish_no = 0;
     try{
      String num = "(select nvl(max(wish_no),0)+1 from wishlist)";
      pstmt=con.prepareStatement(num);
      rs = pstmt.executeQuery();
      if(rs.next()) {
    	  wish_no = rs.getInt(1);
      }
      
      pstmt.close();
      String sql="INSERT INTO Wishlist (wish_no, hotel_no, user_no) VALUES("+num+",?,?)";
      pstmt=con.prepareStatement(sql);
      pstmt.setInt(1,user_no);
      pstmt.setInt(2,hotel_no);
      pstmt.executeUpdate();
     }
    
     catch(Exception e)
     {
      e.printStackTrace();
     }
     finally
     {
    	 db.close(con, pstmt,null);
     }
      return wish_no;
   }


	public List<Wishlist> getMyList(int page, int limit, int user_no) {
		List<Wishlist> list = new ArrayList<Wishlist>();
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql1 = "select hotel_name, hotel_tel,hotel_addr, hotel_no from hotel where hotel_no in (select hotel_no from wishlist where user_no = ?)";
			
			String sql = "select * "
					+" from (select b.*, rownum rnum"
					+" 		from("+sql1+") b"
					+         ")"
					+"   where rnum>=? and rnum<=?";
			pstmt = con.prepareStatement(sql);
			
			int startrow = (page - 1) * limit + 1;
					
			int endrow = startrow + limit - 1;
			pstmt.setInt(1, user_no);		
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, endrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Wishlist m = new Wishlist();
				m.setHotel_name(rs.getString(1));
				m.setHotel_tel(rs.getString(2));
				m.setHotel_addr(rs.getString(3));
				m.setHotel_no(rs.getInt(4));
				list.add(m);
			}
			System.out.println(list);
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}  finally {
			db.close(con, pstmt, rs);
		}
		return list;
	}


	public Wishlist Jjimcheck(int hotel_no, int user_no) {
		Wishlist m = null;
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			
			String sql = "(select wish_no from wishlist where hotel_no = ? and user_no = ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, hotel_no);
			pstmt.setInt(2, user_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				m = new Wishlist();
				m.setWish_no(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			db.close(con, pstmt, rs);
		}
		return m;
	}


	public void Jjimdel(int wish_no) {
		
		Connection con = db.getConnect();
		PreparedStatement pstmt = null;
		
	
		try {
			
			String sql = "delete from wishlist where wish_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, wish_no);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			db.close(con, pstmt, null);
		}
		
	}
}