--liquibase formatted sql

--changeset vishal:1
create table if not exists users (
                       id bigserial primary key ,
                       first_name varchar(100),
                       last_name varchar(100),
                       created_date timestamp
);
create sequence if not exists users_sequence start 1000 increment 1;
--rollback drop table users;
--rollback drop sequence users_sequence;