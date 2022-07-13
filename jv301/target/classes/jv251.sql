create table addmember(
	num bigint primary key auto_increment,
	id	varchar(16) not null,
	password varchar(16) not null,
	name varchar(20) not null,
	ssn varchar(14) not null,
	email1 varchar(11) not null,
	email2 varchar(11) not null,
	addr1 varchar(20) not null,
	addr2 varchar(20) not null,
	regData timestamp not null default current_timestamp
) auto_increment = 1;

select * from addmember;
