DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS shops;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS shops_by_products;

/*users*/
create table users
(
id int primary key auto_increment,
user varchar(500) not null unique,
creation_date datetime not null,
state varchar(1) not null
);

/*Inserta los usuarios*/
insert into users (user,creation_date,state) 
values("BZAMORA",now(),"S");
insert into users (user,creation_date,state) 
values("SLITARDO",now(),"S");

/*shop*/
create table shops
(
id int primary key auto_increment,
name varchar(500) not null unique,
category varchar(500) not null,
state varchar(1) not null,
user varchar(500) not null
);

/*product*/
create table products
(
id int primary key auto_increment,
name varchar(500) not null unique,
amount int not null,
state varchar(1) not null
);

/*shops_by_products*/
create table shops_by_products
(
id_shop int not null,
id_product int not null,
PRIMARY KEY (id_shop, id_product),
state varchar(1) not null
);
ALTER TABLE shops_by_products ADD FOREIGN KEY (id_shop) REFERENCES shops(id);
ALTER TABLE shops_by_products ADD FOREIGN KEY (id_product) REFERENCES products(id);
