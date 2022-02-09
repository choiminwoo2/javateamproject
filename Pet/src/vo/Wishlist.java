package vo;

public class Wishlist {
	private int wish_no;
	private int user_no;
	private int hotel_no;
	
	@Override
	public String toString() {
		return "Wishlist [wish_no=" + wish_no + ", user_no=" + user_no + ", hotel_no=" + hotel_no + "]";
	}

	public int getWish_no() {
		return wish_no;
	}

	public void setWish_no(int wish_no) {
		this.wish_no = wish_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getHotel_no() {
		return hotel_no;
	}

	public void setHotel_no(int hotel_no) {
		this.hotel_no = hotel_no;
	}
}
