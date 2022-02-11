--테이블 삭제
DROP TABLE HOTEL cascade constraints purge;
--테이블 생성
CREATE TABLE HOTEL(
	hotel_no number primary key,
	hotel_name varchar2(50) not null,
	hotel_animal_grade number(3) check(hotel_animal_grade in(0,1,2)),
	hotel_price_5kglt number(6) not null,
	hotel_price_5ge8lt number(6) not null,
	hotel_price_8ge12lt number(6) not null,
	hotel_price_12gt number(6) not null,
	hotel_tel varchar2(13) not null,
	hotel_postcode varchar2(10) not null,
	hotel_addr varchar2(100) not null,
	hotel_addr_detail varchar2(100) not null,
	hotel_photofile varchar2(100) not null,
	hotel_id varchar2(50) not null
);
--테스트용 테이블
CREATE TABLE HOTEL1 AS
SELECT * FROM HOTEL;
--시퀀스
CREATE SEQUENCE hotel_seq;

--더미데이터
insert into hotel values(1,'애견사랑', 0,30000,50000,70000,90000,'02-514-7899','512','경기 파주시
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
insert into hotel values(2,'펫을 다룬', 2,50000,70000,90000,110000,'02-514-7899','512','경기 파주시
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
 insert into hotel values(3,'고양이나라', 1, 30000,50000,70000,90000,'02-514-7899','512','경기 파주시
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
 insert into hotel values(4,'당신의 강아지', 0, 30000,50000,70000,90000,'02-514-7899','512','경기 파주시
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
 insert into hotel values(5,'고양이 집사', 1, 30000,50000,70000,90000,'02-514-7899','512','경기 파주시
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
 insert into hotel values(6,'테스트', 0, 30000,50000,70000,90000,'02-514-7899','512','서울 용산구
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
  insert into hotel values(7,'TEST', 2, 30000,50000,70000,90000,'02-514-7899','512','서울 용산구
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
  insert into hotel values(8,'애견스 닷컴', 0, 30000,50000,70000,90000,'02-514-7899','512','서울 용산구
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
  insert into hotel values(9,'우리호텔', 2, 30000,50000,70000,90000,'02-514-7899','512','서울 용산구
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
  insert into hotel values(10,'냥냥', 1, 30000,50000,70000,90000,'02-514-7899','512','서울 용산구
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
  insert into hotel values(12,'고양이 마을', 1, 30000,50000,70000,90000,'02-514-7899','512','서울 용산구
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
   insert into hotel values(13,'강아지 마을', 0, 70000,90000,100000,140000,'02-514-7899','512','서울 용산구
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
    insert into hotel values(14,'고양이 마을', 1, 70000,90000,100000,140000,'02-514-7899','512','서울 용산구
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
     insert into hotel values(15,'냥이', 1, 70000,90000,100000,140000,'02-514-7899','512','서울 용산구
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
     insert into hotel values(16,'강지', 0, 70000,90000,100000,140000,'02-514-7899','512','서울 용산구
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
     insert into hotel values(17,'고양이강아지', 2, 70000,90000,100000,140000,'02-514-7899','512','서울 용산구
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
     insert into hotel values(18,'냥냥냥', 1, 70000,90000,100000,140000,'02-514-7899','512','서울 용산구
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
     insert into hotel values(19,'멍멍멍', 0, 70000,90000,100000,140000,'02-514-7899','512','서울 용산구
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
      insert into hotel values(20,'멍멍이', 0, 70000,90000,100000,140000,'02-514-7899','512','서울 용산구
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
      insert into hotel values(21,'개와고양이', 2, 70000,90000,100000,140000,'02-514-7899','512','경기 용산구
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
      insert into hotel values(22,'Cats', 1, 70000,90000,100000,140000,'02-514-7899','512','경기 용산구
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
      insert into hotel values(23,'DOGS', 0, 70000,90000,100000,140000,'02-514-7899','512','경기 용산구
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
       insert into hotel values(24,'도그네', 0, 70000,90000,100000,140000,'02-514-7899','512','경기 용산구
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');
       insert into hotel values(25,'냥이네', 1, 70000,90000,100000,140000,'02-514-7899','512','경기 용산구
 새꽃로 1','하루빌딩 1층 403호','test.png','hoteluse');


	