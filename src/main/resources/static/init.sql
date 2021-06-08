drop table if exists message cascade;

create table message
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(4000) not null
);

insert into message (name) values ( 'GAYAYAYA' );

insert into message (name) values ( 'AYAYAY' );

insert into message (name) values ( 'OLOLOLOL' );