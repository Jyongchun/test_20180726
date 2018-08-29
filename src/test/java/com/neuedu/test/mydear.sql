create database if not exists mydear;

create table s(
ss   varchar(20) comment'学号',
sn   varchar(20) ,
sd   varchar(20) ,
sa   int comment'年龄'
);
create table c(
cc   varchar(20) ,
cn   varchar(20)

);

create table sc(
ss   varchar(20) ,
cc   varchar(20),
g   int(20)
);
INSERT INTO s(ss,sn)VALUES ('001','张三');
INSERT INTO s(ss,sn)VALUES ('005','李四');
INSERT INTO s(ss,sn)VALUES ('006','王五');

INSERT INTO c(cc,cn)VALUES ('1','税收基础');
INSERT INTO c(cc,cn)VALUES ('2','语文');

INSERT INTO sc(ss,cc,g)VALUES ('001','1',80);
INSERT INTO sc(ss,cc,g)VALUES ('006','1',90);
INSERT INTO sc(ss,cc,g)VALUES ('005','2',120);
#推荐使用
select s.ss ,s.sn from s
join sc on sc.ss=s.ss
Join c on c.cc=sc.cc
where c.cn='税收基础';
#不得已采用
select ss,sn from s where ss in(select ss from c,sc where c.cc=sc.cc and cn='税收基础') ;

create table logrecord(
        id         int     primary key 	auto_increment,
        user_id         int,
        operation	  varchar(200),
        create_time timestamp
 );

create table bank(
    name VARCHAR(50),
    money DOUBLE
 );
INSERT INTO bank (name, money) VALUES ('mike',2000),('july',2000)