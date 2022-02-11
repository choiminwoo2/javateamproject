drop table UserData cascade constraints purge;

create table UserData (
	user_no number primary key,
	id varchar2(20) not null,
	password varchar2(15) NOT NULL,
	nickname varchar2(20) NOT NULL,
	tel varchar2(20),				
	user_grant number NOT NULL,		 /* 권한(0,1) 일반 사용자= 0, 호텔측 사용자= 1 */
	regdate date           			 /* 회원 가입한 날짜  */
);


/* 관리자 */
insert into userdata(user_no, id, password, nickname, user_grant) values (0, 'admin', 1234, '관리자', 2);  
insert into animal(animal_no, kind, kg, user_no) values (0,'dog',8,0); 		 			

/* 일반 사용자 */
insert into userdata(user_no, id, password, nickname, tel, user_grant, regdate) values (1, 'kka12', 1234, '자바77','010-2523-7894', 0,sysdate);
insert into animal(animal_no, kind, kg, user_no) values (1,'cat',4,1); 
insert into userdata(user_no, id, password, nickname, tel, user_grant, regdate) values (2, 'java314', 1234, '스프링55','010-1133-1347', 0,sysdate);
insert into animal(animal_no, kind, kg, user_no) values (2,'cat',8,2); 
insert into userdata(user_no, id, password, nickname, tel, user_grant, regdate) values (3, 'css53', 1234, '강아지주인','010-5134-6748', 0,sysdate);
insert into animal(animal_no, kind, kg, user_no) values (3,'dog',13,3); 
insert into userdata(user_no, id, password, nickname, tel, user_grant, regdate) values (4, 'Kmq112', 1234, 'LYT12','010-6136-9451', 0,sysdate);
insert into animal(animal_no, kind, kg, user_no) values (4,'cat',9,4); 
insert into userdata(user_no, id, password, nickname, tel, user_grant, regdate) values (5, 'Lymm1', 1234, 'books','010-7122-6147', 0,sysdate);
insert into animal(animal_no, kind, kg, user_no) values (5,'dog',15,5); 
insert into userdata(user_no, id, password, nickname, tel, user_grant, regdate) values (6, 'book77', 1234, 'tot123','010-8124-8579', 0,sysdate);
insert into animal(animal_no, kind, kg, user_no) values (6,'cat',5,6); 
insert into userdata(user_no, id, password, nickname, tel, user_grant, regdate) values (7, 'allove5', 1234, 'css677','010-2139-1321', 0,sysdate);
insert into animal(animal_no, kind, kg, user_no) values (7,'dog',10,7); 


/* 호텔측 사용자 */
insert into userdata(user_no, id, password, nickname, tel, user_grant, regdate) values (8, 'hoteluse', 1234, '호텔측사용자','010-2123-4761', 1,sysdate);
insert into userdata(user_no, id, password, nickname, tel, user_grant, regdate) values (9, 'hotelad99', 1234, '호텔주인','010-3411-4211', 1,sysdate);
insert into userdata(user_no, id, password, nickname, tel, user_grant, regdate) values (10, 'KLf114', 1234, '애견카페사장','010-2993-9051', 1,sysdate);
insert into userdata(user_no, id, password, nickname, tel, user_grant, regdate) values (11, 'CSS522', 1234, '호텔사장','010-2643-4966', 1,sysdate);
insert into userdata(user_no, id, password, nickname, tel, user_grant, regdate) values (12, 'Java566', 1234, 'My123A','010-21243-4531', 1,sysdate);
insert into userdata(user_no, id, password, nickname, tel, user_grant, regdate) values (13, 'windwo511', 1234, 'Hotel5','010-8223-1211', 1,sysdate);
insert into userdata(user_no, id, password, nickname, tel, user_grant, regdate) values (14, 'alwq115', 1234, 'everyone','010-8129-3411', 1,sysdate);
