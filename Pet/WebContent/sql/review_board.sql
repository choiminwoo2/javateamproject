drop table review_board cascade constraints purge;
CREATE TABLE review_board(
   review_no   number,         --게시글번호
   rb_id       varchar2(30),   --작성자
   rb_title    varchar2(60),  --제목
   rb_text     varchar2(300), --내용
   rb_date date default sysdate,      --글의 작성 날짜
   rb_redate date default sysdate,      --글의 수정 날짜
   PRIMARY KEY(review_no)
   );
   
   
   select*from review_board