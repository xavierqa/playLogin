# Users schema
 
# --- !Ups

create table account (
  uuid						varchar(255),
  email                     varchar(255) not null,
  username                  varchar(255) not null,
  password                  varchar(255),
  constraint pk_account primary key (email, username)
);

create table uuid(
	user					varchar(255),
	uuid					varchar(255),
	constraint pk_UUID primary key(uuid)
	
);

# --- !Downs
 
drop table if exists account;
