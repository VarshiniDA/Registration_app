create database cust_reg_db

use cust_reg_db

create table login 
(
	email Varchar(128),
    password varchar(20)
)

insert into login values
(
	'varshinida2002@gmail.com',
    'testing'
)

select * from login

create table registration
(
	name varchar(45),
    city varchar(45),
    email varchar(128),
    mobile varchar(10)
)

select * from registration