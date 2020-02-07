create sequence HIBERNATE_SEQUENCE start with 1001;

create table Graphic
(
    id bigint not null auto_increment,
    content varchar(255),
    url varchar(255),
    primary key (id)
)