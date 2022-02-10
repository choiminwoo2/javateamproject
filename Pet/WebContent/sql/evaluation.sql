--테이블 삭제
drop table evaluation cascade constraints purge;
--테이블 생성
CREATE TABLE evaluation(
   ev_no      number,         --별점 테이블 번호(pk)
   hotel_no   number,
   review_no  number,         --리뷰 번호(fk)
   ev_score   number(2,1),    --별점
   animal_info varchar2(20),  --반려동물 정보
   foreign key(review_no) references review_board(review_no) on delete cascade,   --게시판 인덱스
   PRIMARY KEY(ev_no)
   );
   
   --테이블 조회
   select * from EVALUATION

   
   --review_board테이블과 join한 내용 조회
   select * 
   from review_board inner join EVALUATION
   on REVIEW_BOARD.REVIEW_NO=EVALUATION.REVIEW_NO
   where review_board.review_no=?;