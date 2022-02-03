drop table UserData;

create table UserData (
	user_no number not null primary key,
	id varchar2(15) NOT NULL,
	password varchar2(10) NOT NULL,
	nickname varchar2(15) NOT NULL,
	tel varchar2(15) NOT NULL,				
	user_grant number NOT NULL,		 /* 권한(0,1) 일반 사용자= 0, 호텔측 사용자= 1 */
	regdate date not null            /* 회원 가입한 날짜  */
);


insert into userdata values (1, 'admin', 1234, '관리자', '010-1234-1234', 2 , sysdate);