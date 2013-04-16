# Users schema
 
# --- !Ups

create table account (
  UDID						varchar(255),
  email                     varchar(255) not null,
  username                  varchar(255) not null,
  password                  varchar(255),
  constraint pk_account primary key (email, username)
);

create table UDID_lookup(
	user					varchar(255),
	udid					varchar(255),
	constraint pk_UDID_lookup primary key(udid)
	
);

# --- !Downs
 
drop table if exists account;
