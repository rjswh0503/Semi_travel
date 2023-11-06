//실험용
INSERT INTO USER_INFO (user_id,user_pw,user_email,user_phone,user_name,user_sex,user_age,user_date)
VALUES ('1','1','1','1','1','M','1997-03-13','2023-11-06');

DELETE FROM USER_INFO WHERE user_ID = 1;
DELETE FROM review WHERE review_id = 1;

//댓글

  
CREATE TABLE review(
    review_ID INT PRIMARY KEY,
    user_id VARCHAR2(20) NOT NULL,
    CITY_ID number NOT NULL,
    review_TITLE VARCHAR2(50) NOT NULL,
    review_comment VARCHAR2(255) NOT NULL,
     CONSTRAINT fk_review_USER
        FOREIGN KEY (user_id)
        REFERENCES USER_INFO(user_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_review_CITY
        FOREIGN KEY (CITY_ID)
        REFERENCES CITY_ID(CITY_ID)
        ON DELETE CASCADE
    );
    
 
INSERT INTO review(review_ID,user_id,CITY_ID,review_TITLE,review_comment)
VALUES (1,'1',1,'1','1');
INSERT INTO review(review_ID,user_id,CITY_ID,review_TITLE,review_comment)
VALUES (2,'1',1,'1','1');
INSERT INTO review(review_ID,user_id,CITY_ID,review_TITLE,review_comment)
VALUES (3,'1',1,'1','1');
INSERT INTO review(review_ID,user_id,CITY_ID,review_TITLE,review_comment)
VALUES (4,'1',1,'1','1');
INSERT INTO review(review_ID,user_id,CITY_ID,review_TITLE,review_comment)
VALUES (5,'1',1,'1','1');




    

//도시
CREATE TABLE CITY_ID (
    CITY_ID number PRIMARY KEY NOT NULL,
    CITY_NAME VARCHAR2(30) NOT NULL,
    CITY_TIP CLOB
    );

//유저 정보
CREATE TABLE USER_INFO (
    user_id VARCHAR2(20) PRIMARY KEY NOT NULL,
    user_pw VARCHAR2(20) NOT NULL,
    user_email VARCHAR2(30) NOT NULL,
    user_phone VARCHAR2(20),
    user_name VARCHAR2(10) NOT NULL,
    user_sex char,
    user_age date,
    user_date date
    );
    
//식당

CREATE TABLE RESTAURANT (
    res_id NUMBER primary key NOT NULL,
    user_id VARCHAR2(20) NOT NULL,
    CITY_ID number NOT NULL,
    res_name VARCHAR2(50) NOT NULL,
    res_location VARCHAR2(50) NOT NULL,
    res_phone VARCHAR2(30),
    res_time date,
    res_date date NOT NULL,
    res_like number NOT NULL,
     res_comment VARCHAR2(255),
    CONSTRAINT fk_res_USER
        FOREIGN KEY (user_id)
        REFERENCES USER_INFO(user_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_res_CITY
        FOREIGN KEY (CITY_ID)
        REFERENCES CITY_ID(CITY_ID)
        ON DELETE CASCADE
    );
    
CREATE TABLE accomodation (
    acc_num NUMBER PRIMARY KEY NOT NULL,
    user_id VARCHAR2(20) NOT NULL,
    CITY_ID number NOT NULL,
    acc_name VARCHAR2(20) NOT NULL,
    acc_location VARCHAR2(50) NOT NULL,
    acc_phone VARCHAR2(20) ,
    acc_time DATE ,
    acc_date DATE NOT NULL,
    acc_like NUMBER NOT NULL,
    acc_comment VARCHAR2(255),
    CONSTRAINT fk_acc_USER
        FOREIGN KEY (user_id)
        REFERENCES USER_INFO(user_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_acc_CITY
        FOREIGN KEY (CITY_ID)
        REFERENCES CITY_ID(CITY_ID)
        ON DELETE CASCADE
    );
    
CREATE TABLE TOUR (
    tour_id number NOT NULL,
    user_id VARCHAR2(20) NOT NULL,
    CITY_ID number NOT NULL,
    tour_name VARCHAR2(50) NOT NULL,
    tour_location VARCHAR(50) NOT NULL,
    tour_phone VARCHAR(30),
    tour_time date,
    tour_date date NOT NULL,
    tour_like NUMBER NOT NULL,
    tour_comment VARCHAR2(255),
    CONSTRAINT fk_tour_USER
        FOREIGN KEY (user_id)
        REFERENCES USER_INFO(user_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_tour_CITY
        FOREIGN KEY (CITY_ID)
        REFERENCES CITY_ID(CITY_ID)
        ON DELETE CASCADE
    );

//도시 INSERT
INSERT INTO CITY_ID(CITY_ID,CITY_NAME,CITY_TIP)
VALUES (27,'OSAKA','우와');
INSERT INTO CITY_ID(CITY_ID,CITY_NAME,CITY_TIP)
VALUES (1,'Sapporo','우와');
INSERT INTO CITY_ID(CITY_ID,CITY_NAME,CITY_TIP)
VALUES (42,'NagaSSaki','우와');
INSERT INTO CITY_ID(CITY_ID,CITY_NAME,CITY_TIP)
VALUES (13,'Tokyo','우와');
INSERT INTO CITY_ID(CITY_ID,CITY_NAME,CITY_TIP)
VALUES (22,'Shizuoka','우와');
INSERT INTO CITY_ID(CITY_ID,CITY_NAME,CITY_TIP)
VALUES (26,'Kyoto','우와');
INSERT INTO CITY_ID(CITY_ID,CITY_NAME,CITY_TIP)
VALUES (23,'Nagoya','우와');
INSERT INTO CITY_ID(CITY_ID,CITY_NAME,CITY_TIP)
VALUES (40,'Fukuoka','우와');
//도시 UPDATE
        
UPDATE CITY_ID SET CITY_TIP='오';

//도시 삭제
DELETE FROM CITY_ID WHERE CITY_ID = 1;
//식당 시퀀스
CREATE SEQUENCE res_seq
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

//식당 트리거
CREATE OR REPLACE TRIGGER res_trigger
BEFORE INSERT ON RESTAURANT
FOR EACH ROW
BEGIN
  SELECT res_seq.NEXTVAL
  INTO :NEW.res_ID
  FROM dual;
END;
/
//숙소 시퀀스
CREATE SEQUENCE acc_seq
    START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
  
//숙소 트리거
CREATE OR REPLACE TRIGGER acc_trigger
BEFORE INSERT ON ACCOMODATION
FOR EACH ROW
BEGIN
    SELECT acc_seq.NEXTVAL
    INTO :NEW.acc_num
    FROM dual;
END;
/

//관광지 시퀀스
CREATE SEQUENCE tour_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
//관광지 트리거
CREATE OR REPLACE TRIGGER tour_trigger
BEFORE INSERT ON TOUR
FOR EACH ROW
BEGIN
    SELECT tour_seq.NEXTVAL
    INTO :NEW.tour_id
    FROM dual;
END;
/

//리뷰 시퀀스
CREATE SEQUENCE review_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

//관광지 트리거
CREATE OR REPLACE TRIGGER review_trigger
BEFORE INSERT ON review
FOR EACH ROW
BEGIN
    SELECT review_seq.NEXTVAL
    INTO :NEW.review_id
    FROM dual;
END;
/
