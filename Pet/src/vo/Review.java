package vo;

public class Review {
	private int hotel_no;
	private int review_no;
	private String rb_id;
	private String rb_title;
	private String rb_text;
	private String rb_date;
	private String rb_redate;
	private float ev_score;
	private int ev_no;
	private String animal_info;

	public int getEv_no() {
		return ev_no;
	}
	public void setEv_no(int ev_no) {
		this.ev_no = ev_no;
	}
	public float getEv_score() {
		return ev_score;
	}
	public void setEv_score(float ev_score) {
		this.ev_score = ev_score;
	}
	public String getAnimal_info() {
		return animal_info;
	}
	public void setAnimal_info(String animal_info) {
		this.animal_info = animal_info;
	}
	public int getHotel_no() {
		return hotel_no;
	}
	public void setHotel_no(int hotel_no) {
		this.hotel_no = hotel_no;
	}	
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public String getRb_id() {
		return rb_id;
	}
	public void setRb_id(String rb_id) {
		this.rb_id = rb_id;
	}
	public String getRb_title() {
		return rb_title;
	}
	public void setRb_title(String rb_title) {
		this.rb_title = rb_title;
	}
	public String getRb_text() {
		return rb_text;
	}
	public void setRb_text(String rb_text) {
		this.rb_text = rb_text;
	}
	public String getRb_date() {
		return rb_date.substring(0, 10);
	}
	public void setRb_date(String rb_date) {
		this.rb_date = rb_date;
	}
	public String getRb_redate() {
		return rb_redate;
	}
	public void setRb_redate(String rb_redate) {
		this.rb_redate = rb_redate;
	}
	
}
