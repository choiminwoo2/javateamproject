--테이블 삭제
DROP TABLE HOTEL cascade constraints purge;
--테이블 생성
CREATE TABLE HOTEL(
	hotel_no number primary key,
	hotel_name varchar2(20) not null,
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
--트리거 
CREATE OR REPLACE TRIGGER DELETE_HOTEL
	AFTER DELETE ON USERDATA
	FOR EACH ROW
BEGIN
	DELETE HOTEL 
	WHERE HOTEL_ID = :OLD.USERDATA.ID
END;
/
	