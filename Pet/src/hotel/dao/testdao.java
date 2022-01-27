package hotel.dao;

import java.sql.Connection;

import db.DB;

public class testdao {
	DB db = new DB();
	Connection conn = db.getConnect();
}
