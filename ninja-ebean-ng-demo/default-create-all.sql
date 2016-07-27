create table guestbook_entry (
  id                            integer auto_increment not null,
  email                         varchar(255),
  content                       varchar(255),
  last_update                   timestamp not null,
  constraint pk_guestbook_entry primary key (id)
);

