--테이블 삭제
drop table review_board cascade constraints purge;
--테이블 생성
CREATE TABLE review_board(
   hotel_no   number,
   review_no   number,         --게시글번호(pk)
   rb_id       varchar2(30),   --작성자
   rb_title    varchar2(60),   --제목
   rb_text     varchar2(300),  --내용
   rb_date date default sysdate,      --글의 작성 날짜
   rb_redate date default sysdate,    --글의 수정 날짜
   PRIMARY KEY(review_no)
   );
   
   --테스트 데이터 insert
   insert into review_board
   values(1,1,'admin','후기입니다.','좋아요',sysdate,null)
   
   insert into review_board
   values(2,2,'admin','후기입니다2.','좋아요2',sysdate,null)
   
    insert into review_board
   values(1,3,'admin','후기입니다3.','좋아요3',sysdate,null)
   
   --테이블 조회
   select*from review_board
   --데이터 삭제
   delete from review_board where review_no=2;
   



