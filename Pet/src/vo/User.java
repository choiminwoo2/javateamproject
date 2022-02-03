package vo;

import java.util.Date;

public class User {
	private int user_no;
	private String id;
	private String password;
	private String nickname;
	private String tel;
	private int user_grant;
	private Date regdate;
	private int animal_no;
	private String kind;
	private int kg;
	
	
	@Override
	public String toString() {
		return "User [user_no=" + user_no + ", id=" + id + ", password=" + password + ", nickname=" + nickname
				+ ", tel=" + tel + ", user_grant=" + user_grant + ", regdate=" + regdate + ", animal_no=" + animal_no
				+ ", kind=" + kind + ", kg=" + kg + "]";
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getUser_grant() {
		return user_grant;
	}
	public void setUser_grant(int user_grant) {
		this.user_grant = user_grant;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getAnimal_no() {
		return animal_no;
	}
	public void setAnimal_no(int animal_no) {
		this.animal_no = animal_no;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getKg() {
		return kg;
	}
	public void setKg(int kg) {
		this.kg = kg;
	}

	
	
	
	
	
	
	
	
}

