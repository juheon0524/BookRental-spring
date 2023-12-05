

create table member(
	id varchar(50) not null primary key,
    pw varchar(500) not null,
    name varchar(100) not null,
	auth varchar(50) not null,
    memberflag char(1) default '1' 
);

create table persistent_logins(
	username varchar(64),
    series varchar(64) primary key,
    token varchar(64) not null,
    last_used timestamp not null
);