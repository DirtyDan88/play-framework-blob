# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table image (
  id                        bigint not null,
  name                      varchar(255),
  data                      blob,
  constraint pk_image primary key (id))
;

create sequence image_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists image;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists image_seq;

