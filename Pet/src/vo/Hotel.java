package vo;

public class Hotel {
	private int hotel_no;
	private String hotel_name;
	private String hotel_postcode;
	private String hotel_addr;
	private String hotel_addrdetail;
	private String hotel_tel;
	private int hotel_price_5lt;
	private int hotel_price_5ge8lt;
	private int hotel_price_8ge12lt;
	private int hotel_price_12gt;	
	private String hotel_pthtofile;
	
	
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getHotel_postcode() {
		return hotel_postcode;
	}
	public void setHotel_postcode(String hotel_postcode) {
		this.hotel_postcode = hotel_postcode;
	}
	public String getHotel_addrdetail() {
		return hotel_addrdetail;
	}
	public void setHotel_addrdetail(String hotel_addrdetail) {
		this.hotel_addrdetail = hotel_addrdetail;
	}
	@Override
	public String toString() {
		return "Hotel [hotel_no=" + hotel_no + ", hotel_addr=" + hotel_addr + ", hotel_tel=" + hotel_tel
				+ ", hotel_price_5lt=" + hotel_price_5lt + ", hotel_price_5ge8lt=" + hotel_price_5ge8lt
				+ ", hotel_price_8ge12lt=" + hotel_price_8ge12lt + ", hotel_price_12gt=" + hotel_price_12gt
				+ ", hotel_pthtofile=" + hotel_pthtofile + "]";
	}
	public int getHotel_no() {
		return hotel_no;
	}
	public void setHotel_no(int hotel_no) {
		this.hotel_no = hotel_no;
	}
	public String getHotel_addr() {
		return hotel_addr;
	}
	public void setHotel_addr(String hotel_addr) {
		this.hotel_addr = hotel_addr;
	}
	public String getHotel_tel() {
		return hotel_tel;
	}
	public void setHotel_tel(String hotel_tel) {
		this.hotel_tel = hotel_tel;
	}
	public int getHotel_price_5lt() {
		return hotel_price_5lt;
	}
	public void setHotel_price_5lt(int hotel_price_5lt) {
		this.hotel_price_5lt = hotel_price_5lt;
	}
	public int getHotel_price_5ge8lt() {
		return hotel_price_5ge8lt;
	}
	public void setHotel_price_5ge8lt(int hotel_price_5ge8lt) {
		this.hotel_price_5ge8lt = hotel_price_5ge8lt;
	}
	public int getHotel_price_8ge12lt() {
		return hotel_price_8ge12lt;
	}
	public void setHotel_price_8ge12lt(int hotel_price_8ge12lt) {
		this.hotel_price_8ge12lt = hotel_price_8ge12lt;
	}
	public int getHotel_price_12gt() {
		return hotel_price_12gt;
	}
	public void setHotel_price_12gt(int hotel_price_12gt) {
		this.hotel_price_12gt = hotel_price_12gt;
	}
	public String getHotel_pthtofile() {
		return hotel_pthtofile;
	}
	public void setHotel_pthtofile(String hotel_pthtofile) {
		this.hotel_pthtofile = hotel_pthtofile;
	}
	
	
}
