Update book
set author= null;

alter table book;
    alter column author
type int using author::integer;

alter table book
    add constraint author_id_fk
    foreign_key_(author)
references author(id);

alter table book
    rename column author to autor_id;