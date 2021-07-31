drop table if exists hibernate_sequence
drop table if exists student_infomation
drop table if exists user_information
create table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
create table student_infomation (student_id integer not null, address varchar(255), email varchar(255), first_name varchar(255) not null, last_name varchar(255), tel_no varchar(255), primary key (student_id)) engine=InnoDB
create table user_information (user_id integer not null, active bit, email varchar(255), password varchar(255) not null, role varchar(255), username varchar(20) not null, primary key (user_id)) engine=InnoDB
alter table user_information add constraint UK_hu5i69dqh5n8f259xbkyyd7tl unique (username)