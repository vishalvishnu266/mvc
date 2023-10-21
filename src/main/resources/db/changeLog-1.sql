--liquibase formatted sql

--changeset vishal:1
create sequence if not exists task_seq start 1 increment 1;

create table if not exists task (
                       id bigint not null DEFAULT NEXTVAL('task_seq') primary key ,
                       name varchar(100)
                       );
--rollback drop table task;
--rollback drop sequence task_seq;