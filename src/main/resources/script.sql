DROP TABLE IF EXISTS users;

/*users*/
create table users
(
id int primary key auto_increment,
user varchar(500) not null unique,
creation_date datetime not null,
state varchar(1) not null
);

insert into users (user,creation_date,state) 
values("BZAMORA",now(),"S");

SELECT *FROM users;