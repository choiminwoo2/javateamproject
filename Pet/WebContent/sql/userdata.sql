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


insert into userdata(user_no, id, password, nickname, user_grant) values (0, 'admin', 1234, '관리자', 2);


select*from userdata;