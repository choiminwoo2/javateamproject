drop table evaluation cascade constraints purge;
CREATE TABLE evaluation(
   ev_no      number,     --별점 테이블 번호
   hotel_no   number,
   review_no  number,
   ev_score   number(2,1),    --본문
   animal_info varchar2(20),
   --foreign key(hotel_no) references hotel(hotel_no),   --호텔 번호
   foreign key(review_no) references review_board(review_no),   --게시판 인덱스
   PRIMARY KEY(ev_no)
   );
   
   select * from EVALUATION
   
   select round(avg(ev_score),1) from EVALUATION where hotel_no=1