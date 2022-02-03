drop table review_board cascade constraints purge;
CREATE TABLE review_board(
  --호텔번호
   review_no   number,         --게시글번호
   rb_id       varchar2(30),   --작성자
   rb_title    varchar2(60),  --제목
   rb_text     varchar2(300), --내용
   rb_date date default sysdate,      --글의 작성 날짜
   rb_redate date default sysdate,      --글의 수정 날짜
   PRIMARY KEY(review_no)
   );
   
   insert into review_board
   values(1,'admin','후기입니다.','좋아요',sysdate,null)
   
   insert into review_board
   values(2,'admin','후기입니다2.','좋아요2',sysdate,null)
   
   select*from review_board
   
ALTER TABLE review_board
ADD COLUMN rating INT NOT NULL DEFAULT 0;




select *
from (select  rownum  rnum, j.* 
      from (select * from review_board order by review_no) j
	 ) 
where rnum>=1 and rnum<=10