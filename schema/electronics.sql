drop table Electronics;

create table Electronics(
	model_num varchar2(15) primary key,--모델번호
	model_name varchar2(20) not null,--모델명
	price int,--가격
	description varchar2(100),--상세설명
	password varchar2(20) not null,--비번
	writeday date  not null,--작성일
	readnum int,--조회수
	fname varchar2(50), --파일이름
        fsize int --파일용량
);


insert into Electronics values('iPhone 11','아이폰11',850000,'듀얼 카메라 시스템','1234',sysdate,0,null,0);
insert into Electronics values('iPhone SE','아이폰 SE',550000,'싱글 카메라 시스템','1234',sysdate,0,null,0);
insert into Electronics values('iPhone XR','아이폰 XR',690000,'싱글 카메라 시세틈','1234',sysdate,0,null,0);


SELECT SYS_DATETIME; --시스템 현재날짜와 시분초

SELECT writeday, to_char(writeday, 'YYYY-MM-DD HH:MI:SS AM') FROM Electronics;

 select model_num,model_name,price, description,password , to_char(writeday, 'YYYY-MM-DD HH:MI:SS AM') as writeday ,readnum
 from Electronics ;

