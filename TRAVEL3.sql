// 도시나 유저 삭제시 다른것도 사라지는지 확인
INSERT INTO USER_INFO (user_id,user_pw,user_email,user_phone,user_name,user_sex,user_age,user_date)
VALUES ('1','1','1','1','1','M','1997-03-13','2023-11-06');

INSERT INTO CITY_ID(CITY_ID,CITY_NAME,CITY_TIP)
VALUES (1,'Sapporo','우와');

INSERT INTO RESTAURANT (res_id, user_id, CITY_ID, res_name, res_location, res_phone, res_time)
VALUES (1,1,1,1,1,1,1);

INSERT INTO BOARDS ( user_id,title,CONTENT,city_name,category)
VALUES (1,'asd','asdasd','오사카','관광지');

INSERT INTO review (post_number, user_id, review_writer ,review_content)
VALUES (2,1,'asdasd','asdasdasd');

DELETE FROM user_info WHERE user_id = '1';

DELETE FROM city_id WHERE city_id.city_id = 1;

//도시 O
CREATE TABLE CITY_ID (
    CITY_NAME VARCHAR2(50) PRIMARY KEY NOT NULL,
    CITY_TIP CLOB
    );

//유저 정보  O
CREATE TABLE USER_INFO (
    user_id VARCHAR2(50) PRIMARY KEY NOT NULL,
    user_pw VARCHAR2(40) NOT NULL,
    user_email VARCHAR2(50) NOT NULL,
    user_phone VARCHAR2(30),
    user_name VARCHAR2(20) NOT NULL,
    user_sex VARCHAR2(10) NOT NULL,
    user_age date,
    user_date TIMESTAMP
      );
    
//식당

CREATE TABLE RESTAURANT (
    res_id int primary key NOT NULL,
    user_id VARCHAR2(50) NOT NULL,
    CITY_NAME VARCHAR2(50) NOT NULL,
    res_name VARCHAR2(100) NOT NULL,
    res_location VARCHAR2(100) NOT NULL,
    res_phone VARCHAR2(30),
    res_time varchar2(100),
    res_date timestamp NOT NULL,
    res_comment CLOB,
    res_img1 blob,
    res_img2 blob,
    res_img3 blob,
    CONSTRAINT fk_res_USER
        FOREIGN KEY (user_id)
        REFERENCES USER_INFO(user_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_res_CITY
        FOREIGN KEY (CITY_ID)
        REFERENCES CITY_ID(CITY_ID)
        ON DELETE CASCADE
    );

//숙소
CREATE TABLE accomodation (
    acc_id int primary key NOT NULL,
    user_id VARCHAR2(50) NOT NULL,
    CITY_NAME VARCHAR2(50) NOT NULL,
    acc_name VARCHAR2(100) NOT NULL,
    acc_location VARCHAR2(100) NOT NULL,
    acc_phone VARCHAR2(30),
    acc_time varchar2(100),
    acc_date timestamp NOT NULL,
    acc_comment CLOB,
    acc_img blob1,
    acc_img blob2,
    acc_img blob3,
    CONSTRAINT fk_acc_USER
        FOREIGN KEY (user_id)
        REFERENCES USER_INFO(user_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_acc_CITY
        FOREIGN KEY (CITY_ID)
        REFERENCES CITY_ID(CITY_ID)
        ON DELETE CASCADE
    );
    
//관광지
CREATE TABLE TOUR (
    tour_id int primary key NOT NULL,
    user_id VARCHAR2(50) NOT NULL,
    CITY_NAME VARCHAR2(50) NOT NULL,
    tour_name VARCHAR2(100) NOT NULL,
    tour_location VARCHAR2(100) NOT NULL,
    tour_phone VARCHAR2(30),
    tour_time varchar2(100),
    tour_date timestamp NOT NULL,
    tour_comment CLOB,
    tour_img blob1,
    tour_img blob2,
    tour_img blob3,
    CONSTRAINT fk_tour_USER
        FOREIGN KEY (user_id)
        REFERENCES USER_INFO(user_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_tour_CITY
        FOREIGN KEY (CITY_ID)
        REFERENCES CITY_ID(CITY_ID)
        ON DELETE CASCADE
    );
//게시판
CREATE TABLE BOARDS (
    post_number INT PRIMARY KEY NOT NULL,
    user_id VARCHAR2 (50) NOT NULL,
    title VARCHAR2(100) NOT NULL,
    CONTENT CLOB NOT NULL,
    post_time timestamp NOT NULL,
    city_name VARCHAR2(50) NOT NULL,
    category VARCHAR2(50) NOT NULL,
    CONSTRAINT fk_boards_USER
        FOREIGN KEY (user_id)
        REFERENCES USER_INFO(user_id)
        ON DELETE CASCADE
        );
        


//댓글
CREATE TABLE review (
    review_number int primary key NOT NULL,
    post_number int NOT NULL,
    user_id VARCHAR2(50) NOT NULL,
    review_writer VARCHAR2(50) NOT NULL,
    review_content VARCHAR2(255) NOT NULL,
    review_date timestamp NOT NULL,
    CONSTRAINT fk_review_user
        FOREIGN KEY (user_id)
        REFERENCES USER_INFO(user_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_review_boards
        FOREIGN KEY (post_number)
        REFERENCES boards(post_number)
        ON DELETE CASCADE
        );


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
    INTO :NEW.acc_id
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

//게시판 시퀀스
CREATE SEQUENCE board_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
//게시판 트리거
CREATE OR REPLACE TRIGGER boards_trigger
BEFORE INSERT ON boards
FOR EACH ROW
BEGIN
    SELECT board_seq.NEXTVAL
    INTO :NEW.post_number
    FROM dual;
END;
/

//리뷰 시퀀스
CREATE SEQUENCE review_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

//리뷰 트리거
CREATE OR REPLACE TRIGGER review_trigger
BEFORE INSERT ON review
FOR EACH ROW
BEGIN
    SELECT review_seq.NEXTVAL
    INTO :NEW.review_number
    FROM dual;
END;
/

