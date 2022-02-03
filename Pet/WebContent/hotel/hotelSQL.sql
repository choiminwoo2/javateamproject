DROP TABLE HOTEL CASCADE;
--테이블 생성
CREATE TABLE HOTEL(
	hotel_no number primary key,
	hotel_addr varchar2(100) not null,
	hotel_price_5kglt number(6) not null,
	hotel_price_5ge8let number(6) not null,
	hotel_price_8ge12lt number(6) not null,
	hotel_price_12gt number(6) not null,
	hotel_photofile varchar2(20) not null,
	hotel_photosidefile varchar2(100),
	hotel_photoinnerfile varchar2(100) 
);
--테스트용 테이블
CREATE TABLE HOTEL1 AS
SELECT * FROM HOTEL;
--시퀀스
CREATE SEQUENCE hotel_seq;

--더미데이터
insert into hotel values(hotel_seq.nextval, "서울",30000,50000,70000,100000,'hotel.jpg','photosidefile',
'photoinnerfile');
