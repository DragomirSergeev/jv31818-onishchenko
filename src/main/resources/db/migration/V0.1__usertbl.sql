CREATE table USERS (id int(20) not null auto_increment primary key, login varchar(255) not null unique , password varchar(255) not null, name varchar(255) null);