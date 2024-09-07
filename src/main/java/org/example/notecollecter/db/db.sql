create database if not exists notecollecter;

use notecollecter;

create table user(
    id varchar(255) primary key,
    firstname varchar(255),
    lastname varchar(255),
    email varchar(255),
    password varchar(255),
    profilepic varchar(255),
    notes varchar(255)
);

create table note(
    id varchar(255) primary key,
    title varchar(255),
    description varchar(255),
    date date not null,
    prioritylvl int(10) not null,
    userid varchar(255),
    constraint foreign key(userid) references user(id)
);