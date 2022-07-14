create table addmember(
	num bigint primary key auto_increment,
	id	varchar(50) not null,
	password varchar(50) not null,
	name varchar(50) not null,
	ssn varchar(50) not null,
	email1 varchar(50) not null,
	email2 varchar(50) not null,
	addr1 varchar(50) not null,
	addr2 varchar(50) not null,
	regData timestamp not null default current_timestamp
) auto_increment = 1;

select * from addmember;
drop table addmember;
delete from addmember where id='kim123';
