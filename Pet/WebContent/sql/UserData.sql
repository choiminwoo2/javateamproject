create table UserData (
	user_no number primary key,
	id varchar2(10) NOT NULL,
	nickname varchar2(10) NOT NULL,
	password varchar2(10) NOT NULL,
	tel varchar2(13) NOT NULL,
	user_grant number(2) NOT NULL,
	join_date varchar2(20) NOT NULL
);

insert into USERDATA(user_no, id, nickname, password, tel, user_grant, join_date) 
  values(1,'after12','tiger',1234, 01080312512, 0, '2022-01-28');
  
  insert into USERDATA(user_no, id, nickname, password, tel, user_grant, join_date) 
  values(2,'noon','cat123',1234, 01044531753, 1, '2022-01-30');
  
  insert into USERDATA(user_no, id, nickname, password, tel, user_grant, join_date) 
  values(3,'night','rabbit51',1234, 01055127731, 0, '2022-02-01');