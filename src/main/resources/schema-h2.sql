drop table if exists person;
drop sequence if exists person_seq;
create sequence person_seq;
create table person ( id bigint not null default nextval('person_seq'),
first_name varchar(255) not null,  last_name varchar(255) not null, age integer not null,
primary key (id));