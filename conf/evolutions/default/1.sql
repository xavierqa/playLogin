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

create table profiles(
	id  					varchar(255),
	profiles_json			varchar(255),
	constraint pk_profiles primary key(id),
	foreign key (uuid_uuid) references project (id) on delete cascade on update restrict		
);

create table date(
	id						varchar(255),
	birthday				date,
	birthday_json			varchar(255),
	constraint pk_date primary key(id),
	foreign key (uuid_uuid) references project (id) on delete cascade on update restrict

);


# --- !Downs
 
drop table if exists account;
drop table if exists uuid;
drop table if exists profiles;
drop table if exists date;
