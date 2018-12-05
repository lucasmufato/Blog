create table autores (
  id          bigint    not null,
  created_on  timestamp not null,
  modified_on timestamp not null,
  apellido    varchar(255),
  nombre      varchar(255),
  primary key (id)
);

create table libros (
  id          bigint       not null,
  created_on  timestamp    not null,
  modified_on timestamp    not null,
  isbn        varchar(255) not null,
  titulo      varchar(255) not null,
  id_autor    bigint       not null,
  primary key (id)
);

alter table libros
  add constraint UK_unique_isbn unique (isbn);

alter table libros
  add constraint FK_autor foreign key (id_autor) references autores;

create sequence hibernate_sequence
  start with 10
  increment by 1;
