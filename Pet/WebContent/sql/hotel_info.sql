drop table hotel_info cascade constraints purge;
CREATE TABLE hotel_info(
   hi_no    number,         --호텔 상세 페이지번호
   hotel_no     number,
   hi_intro     varchar2(2000),    --본문
   hi_url       varchar2(50),      --호텔 링크
   hi_date date default sysdate,   --호텔 등록일
   map_no     number,      
   hi_photofiles varchar2(1000), --호텔 상세페이지에서 사용할 사진 목록.
   foreign key(hotel_no) references hotel(hotel_no),   --호텔 번호
   PRIMARY KEY(hi_no)
   );
   
   
   insert into HOTEL_INFO
   values (1,'우리호텔1',1,'안녕하세요.','http://naver.com',sysdate,1)
   
 insert into HOTEL_INFO
   values (2,'우리호텔2',1,'안녕하세요2','http://naver.com',sysdate,1)
   