create table Favorite (
	fav_no number not null primary key, 
	
	user_no number not null, 
		CONSTRAINT favorite_user FOREIGN KEY(user_no) REFERENCES UserData(user_no) ON DELETE CASCADE
	
	/*  아직 hotel 테이블 없음
	hotel_no number not null,			
		CONSTRAINT favorite_hotel FOREIGN KEY(hotel_no) REFERENCES hote_info(hotel_no) ON DELETE CASCADE
	*/
);