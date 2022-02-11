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
   foreign key(hotel_no) references hotel(hotel_no) on delete cascade,
   PRIMARY KEY(review_no)
   );

   --테스트 데이터 insert
   insert into review_board
   values(1,1,'KAR','후기입니다1','좋아요',sysdate,null);
   
   insert into review_board
   values(1,2,'KAR','후기입니다2','좋아요2',sysdate,null);
   
   insert into review_board
   values(1,3,'KAR','후기입니다3','좋아요3',sysdate,null);
   
   insert into review_board
   values(1,4,'KAR','후기입니다4','좋아요4',sysdate,null);
   
   insert into review_board
   values(1,5,'KAR','후기입니다5','좋아요5',sysdate,null);
   
   insert into review_board
   values(1,6,'KAR','후기입니다6','좋아요6',sysdate,null);
   
   insert into review_board
   values(1,7,'KAR','후기입니다7','좋아요7',sysdate,null);
   
   insert into review_board
   values(1,8,'KAR','후기입니다8','좋아요8',sysdate,null);
   
   insert into review_board
   values(1,9,'KAR','후기입니다9','좋아요9',sysdate,null);
   
   insert into review_board
   values(1,10,'KAR','후기입니다10','좋아요10',sysdate,null);
   
   insert into review_board
   values(1,11,'KAR','후기입니다11','좋아요11',sysdate,null);
   
   insert into review_board
   values(1,12,'KAR','후기입니다12','좋아요12',sysdate,null);
      
   insert into review_board
   values(1,13,'KAR','후기입니다13','좋아요13',sysdate,null);
   
   insert into review_board
   values(1,14,'KAR','후기입니다14','좋아요14',sysdate,null);
      
   insert into review_board
   values(1,15,'KAR','후기입니다15','좋아요15',sysdate,null);
   
   insert into review_board
   values(1,16,'KAR','후기입니다16','좋아요16',sysdate,null);
   
   insert into review_board
   values(1,17,'KAR','후기입니다17','좋아요17',sysdate,null);
      
   insert into review_board
   values(1,18,'KAR','후기입니다18','좋아요18',sysdate,null);
   
   insert into review_board
   values(1,19,'KAR','후기입니다19','좋아요19',sysdate,null);
   
   insert into review_board
   values(1,20,'KAR','후기입니다20','좋아요20',sysdate,null);
   
    insert into review_board
   values(1,21,'KAR','후기입니다21','좋아요21',sysdate,null);
   
   insert into review_board
   values(1,22,'KAR','후기입니다22','좋아요22',sysdate,null);
      
   insert into review_board
   values(1,23,'KAR','후기입니다23','좋아요23',sysdate,null);
   
   insert into review_board
   values(1,24,'KAR','후기입니다24','좋아요24',sysdate,null);
      
   insert into review_board
   values(1,25,'KAR','후기입니다25','좋아요25',sysdate,null);
   
   insert into review_board
   values(1,26,'KAR','후기입니다26','좋아요26',sysdate,null);
   
   insert into review_board
   values(1,27,'KAR','후기입니다27','좋아요27',sysdate,null);
      
   insert into review_board
   values(1,28,'KAR','후기입니다28','좋아요28',sysdate,null);
   
   insert into review_board
   values(1,29,'KAR','후기입니다29','좋아요29',sysdate,null);
   
   insert into review_board
   values(1,30,'KAR','후기입니다30','좋아요30',sysdate,null);
   
   insert into review_board
   values(1,31,'KAR','후기입니다31','좋아요31',sysdate,null);
   
   insert into review_board
   values(1,32,'KAR','후기입니다32','좋아요32',sysdate,null);
   
   insert into review_board
   values(1,33,'KAR','후기입니다33','좋아요33',sysdate,null);
   
   insert into review_board
   values(1,34,'KAR','후기입니다34','좋아요34',sysdate,null);
   
   insert into review_board
   values(1,35,'KAR','후기입니다35','좋아요35',sysdate,null);
   
   insert into review_board
   values(1,36,'KAR','후기입니다36','좋아요36',sysdate,null);
   
   insert into review_board
   values(1,37,'KAR','후기입니다37','좋아요37',sysdate,null);
   
   insert into review_board
   values(1,38,'KAR','후기입니다38','좋아요38',sysdate,null);
   
   insert into review_board
   values(1,39,'KAR','후기입니다39','좋아요39',sysdate,null);
   
   insert into review_board
   values(1,40,'KAR','후기입니다40','좋아요40',sysdate,null);
    
   insert into review_board
   values(1,41,'KAR','후기입니다41','좋아요',sysdate,null);
   
   insert into review_board
   values(1,42,'KAR','후기입니다42','좋아요2',sysdate,null);
   
   insert into review_board
   values(1,43,'KAR','후기입니다43','좋아요3',sysdate,null);
   
   insert into review_board
   values(1,44,'KAR','후기입니다44','좋아요4',sysdate,null);
   
   insert into review_board
   values(1,45,'KAR','후기입니다45','좋아요5',sysdate,null);
   
   insert into review_board
   values(1,46,'KAR','후기입니다46','좋아요6',sysdate,null);
   
   insert into review_board
   values(1,47,'KAR','후기입니다47','좋아요7',sysdate,null);
   
   insert into review_board
   values(1,48,'KAR','후기입니다48','좋아요8',sysdate,null);
   
   insert into review_board
   values(1,49,'KAR','후기입니다49','좋아요9',sysdate,null);
   
   insert into review_board
   values(1,50,'KAR','후기입니다50','좋아요50',sysdate,null);
     
   insert into review_board
   values(1,51,'KAR','후기입니다51','좋아요51',sysdate,null);
   

   
   --테이블 조회
   select*from review_board
   --데이터 삭제
   delete from review_board where review_no=2;
   

