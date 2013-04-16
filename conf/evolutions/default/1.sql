# Users schema
 
# --- !Ups

create table account (
  email                     varchar(255) not null,
  username                      varchar(255),
  password                  varchar(255),
  constraint pk_account primary key (email)
);


# --- !Downs
 
drop table if exists account;
