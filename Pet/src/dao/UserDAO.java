package dao;

import java.sql.Connection;

import db.DB;
import db.User;

public class UserDAO {
	DB db = new DB();
	
	public int test() {
		Connection con= db.getConnect();
		return -1;
	}

	public int insert(User m) {
		// TODO Auto-generated method stub
		return 0;
	}
}
