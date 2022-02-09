drop table wishlist cascade constraints purge; 

create table Wishlist ( 
	wish_no number primary key, 
	user_no number, 
	hotel_no number, 
	foreign key(user_no) references userdata(user_no) on delete cascade, 
	foreign key(hotel_no) references hotel(hotel_no) on delete cascade 
);

CREATE SEQUENCE wish_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;

select wish_no
from wishlist 
where hotel_no = 2 and user_no = 10;