package dao;

import java.sql.Connection;

import db.DB;

public class UserDAO {
	DB db = new DB();
	
	public int test() {
		Connection con= db.getConnect();
		return -1;
	}
}
