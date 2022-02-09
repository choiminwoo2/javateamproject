drop table wishlist;

create table Wishlist (
	wish_no number primary key, 
	user_no number, /*CONSTRAINT wish_user_no foreign key(user_no) references userdata (user_no) ON DELETE CASCADE,*/
	hotel_no number/*, CONSTRAINT wish_hi_no FOREIGN KEY(hi_no) REFERENCES hotel_info(hi_no) ON DELETE CASCADE*/
);

CREATE SEQUENCE wish_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;