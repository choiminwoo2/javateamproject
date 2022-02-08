drop table hotel_info cascade constraints purge;
CREATE TABLE hotel_info(
   hi_no    number,         --호텔 상세 페이지번호
   hotel_no number,
   hi_intro     varchar2(2000),    --본문
   hi_url       varchar2(50),      --호텔 링크
   hi_date date default sysdate,   --호텔 등록일
   map_no     number,      
   hi_photofiles varchar2(1000), --호텔 상세페이지에서 사용할 사진 목록.
   foreign key(hotel_no) references hotel(hotel_no) on delete cascade,   --호텔 번호
   PRIMARY KEY(hi_no)
   );
   
   select*from hotel_info
   
   
select hi_no,         h.hotel_name,          hi_intro,         hi_url
,hi_date,          map_no, hi_photofiles, hotel_photofile,
hotel_price_5kglt, hotel_price_5ge8let, hotel_price_8ge12lt,hotel_price_12gt
from hotel_info e join hotel h on e.hotel_no = h.hotel_no where hi_no = 1 ;

delete from hotel_info

   insert into HOTEL_INFO
   values(1,1,'안녕하세요','http://naver.com',sysdate,0,'hotel1.png/attach.png/down.png/profile.png');

   