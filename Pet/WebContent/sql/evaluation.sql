--테이블 삭제
drop table evaluation cascade constraints purge;
--테이블 생성
CREATE TABLE evaluation(
   ev_no      number,         --별점 순서(pk)
   hotel_no   number,
   review_no  number,         --리뷰 번호(fk)
   ev_score   number(2,1),    --별점 점수
   animal_info varchar2(20),  --반려동물 정보
   foreign key(review_no) references review_board(review_no) on delete cascade,   --게시판 인덱스
   PRIMARY KEY(ev_no)
   );
   
   --테이블 조회
   select * from EVALUATION
   --테이블 내용 삭제
   delete from EVALUATION where hotel_no=1;

   --데이터 insert
   insert into EVALUATION values(1,1,1,5,'강아지/10');
   insert into EVALUATION values(2,1,2,4.5,'고양이/7');
   insert into EVALUATION values(3,1,3,4,'강아지/12');
   insert into EVALUATION values(4,1,4,5,'강아지/5');
   insert into EVALUATION values(5,1,5,3,'고양이/8');
   insert into EVALUATION values(6,1,6,5,'고양이/11');
   insert into EVALUATION values(7,1,7,4,'강아지/4');
   insert into EVALUATION values(8,1,8,3.5,'강아지/12');
   insert into EVALUATION values(9,1,9,5,'강아지/10');
   insert into EVALUATION values(10,1,10,5,'고양이/10');
   insert into EVALUATION values(11,1,11,4,'강아지/10');
   insert into EVALUATION values(12,1,12,4.5,'고양이/7');
   insert into EVALUATION values(13,1,13,4,'강아지/12');
   insert into EVALUATION values(14,1,14,5,'강아지/5');
   insert into EVALUATION values(15,1,15,3,'고양이/8');
   insert into EVALUATION values(16,1,16,5,'고양이/11');
   insert into EVALUATION values(17,1,17,4,'강아지/4');
   insert into EVALUATION values(18,1,18,3.5,'강아지/12');
   insert into EVALUATION values(19,1,19,5,'강아지/10');
   insert into EVALUATION values(20,1,20,5,'강아지/10');
   insert into EVALUATION values(21,1,21,5,'강아지/10');
   insert into EVALUATION values(22,1,22,4.5,'고양이/7');
   insert into EVALUATION values(23,1,23,4,'강아지/12');
   insert into EVALUATION values(24,1,24,5,'강아지/5');
   insert into EVALUATION values(25,1,25,3,'고양이/8');
   insert into EVALUATION values(26,1,26,5,'고양이/11');
   insert into EVALUATION values(27,1,27,4,'강아지/4');
   insert into EVALUATION values(28,1,28,3.5,'강아지/12');
   insert into EVALUATION values(29,1,29,5,'강아지/10');
   insert into EVALUATION values(30,1,30,5,'강아지/10');
   insert into EVALUATION values(31,1,31,5,'강아지/10');
   insert into EVALUATION values(32,1,32,4.5,'고양이/7');
   insert into EVALUATION values(33,1,33,4,'강아지/12');
   insert into EVALUATION values(34,1,34,5,'강아지/5');
   insert into EVALUATION values(35,1,35,3,'고양이/8');
   insert into EVALUATION values(36,1,36,5,'고양이/11');
   insert into EVALUATION values(37,1,37,4,'강아지/4');
   insert into EVALUATION values(38,1,38,3.5,'강아지/12');
   insert into EVALUATION values(39,1,39,5,'강아지/10');
   insert into EVALUATION values(40,1,40,5,'강아지/10');
   insert into EVALUATION values(41,1,41,5,'강아지/10');
   insert into EVALUATION values(42,1,42,4.5,'고양이/7');
   insert into EVALUATION values(43,1,43,4,'강아지/12');
   insert into EVALUATION values(44,1,44,5,'강아지/5');
   insert into EVALUATION values(45,1,45,3,'고양이/8');
   insert into EVALUATION values(46,1,46,5,'고양이/11');
   insert into EVALUATION values(47,1,47,4,'강아지/4');
   insert into EVALUATION values(48,1,48,3.5,'강아지/12');
   insert into EVALUATION values(49,1,49,5,'강아지/10');
   insert into EVALUATION values(50,1,50,5,'강아지/10');
   insert into EVALUATION values(51,1,51,5,'강아지/10');
   
   --review_board테이블과 join한 내용 조회
   select * 
   from review_board inner join EVALUATION
   on REVIEW_BOARD.REVIEW_NO=EVALUATION.REVIEW_NO
   where review_board.review_no=?;