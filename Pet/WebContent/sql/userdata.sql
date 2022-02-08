drop table UserData;

create table UserData (
	user_no number primary key,
	id varchar2(20) not null,
	password varchar2(15) NOT NULL,
	nickname varchar2(20) NOT NULL,
	tel varchar2(20),				
	user_grant number NOT NULL,		 /* 권한(0,1) 일반 사용자= 0, 호텔측 사용자= 1 */
	regdate date           			 /* 회원 가입한 날짜  */
);


/* 둘다 insert 해주세요 */
insert into userdata(user_no, id, password, nickname, user_grant) values (0, 'admin', 1234, '관리자', 2);  
insert into animal(animal_no, kind, kg, user_no) values (0,'dog',8,0); 		 			
/* 둘다 insert 해주세요 */	

insert into userdata(user_no, id, password, nickname, user_grant, regdate) values (1, 'hotel1', 1234, 'hotel1', 1,sysdate);
insert into userdata(user_no, id, password, nickname, user_grant, regdate) values (2, 'hotel2', 1234, 'hotel2', 1,sysdate);
insert into userdata(user_no, id, password, nickname, user_grant, regdate) values (3, 'hotel3', 1234, 'hotel3', 1,sysdate);
insert into userdata(user_no, id, password, nickname, user_grant, regdate) values (4, 'hotel4', 1234, 'hotel4', 1,sysdate);
insert into userdata(user_no, id, password, nickname, user_grant, regdate) values (5, 'hotel5', 1234, 'hotel5', 1,sysdate);
insert into userdata(user_no, id, password, nickname, user_grant, regdate) values (6, 'hotel6', 1234, 'hotel6', 1,sysdate);

select*from userdata;