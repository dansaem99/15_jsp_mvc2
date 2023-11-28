#CREATE DATABASE MVC2_PRACTICE;   
USE MVC2_PRACTICE;
	
CREATE TABLE MEMBER(
    MEMBER_ID 				VARCHAR(30)  PRIMARY KEY,
	MEMBER_NM 				VARCHAR(50)  NOT NULL,
    PASSWD 					VARCHAR(50)  NOT NULL,
   	IMG_NM					VARCHAR(200) NOT NULL,
	SEX 					CHAR(1)   	 NOT NULL,     
	BIRTH_DT 				CHAR(10)  	 NOT NULL, 
	HP 						VARCHAR(20)  NOT NULL,
	SMS_RECV_AGREE_YN 		CHAR(1)   	 NOT NULL,
	EMAIL 					VARCHAR(50)  NOT NULL,
	EMAIL_RECV_AGREE_YN 	CHAR(1)   	 NOT NULL,
	ZIPCODE 				CHAR(5)  	 NOT NULL,
	ROAD_ADDRESS 			VARCHAR(100),
	JIBUN_ADDRESS 			VARCHAR(100),
	NAMUJI_ADDRESS 			VARCHAR(100),
	JOIN_DT 				TIMESTAMP
);
