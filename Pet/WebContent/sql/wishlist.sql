create table WishList (
	wish_no number not null primary key, 
	
	user_no number not null, 
		CONSTRAINT wishlist_user FOREIGN KEY(user_no) REFERENCES UserData(user_no) ON DELETE CASCADE
	
	/*  아직 hotel 테이블 없음
	hotel_no number not null,			
		CONSTRAINT wishlist_hotel FOREIGN KEY(hotel_no) REFERENCES hote_info(hotel_no) ON DELETE CASCADE
	*/
);