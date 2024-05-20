drop table if exists student;
create table student
(
    id       int            not null auto_increment,
    sid      varchar(16)    not null,
    sname    varchar(16)    not null,
    email    varchar(32)    not null,
    phone    varchar(16)    not null,
    password varchar(16)    not null,
    primary key (id)
);

drop table if exists breach;
create table breach
(
    id           int            not null auto_increment,
    sid          varchar(16)    not null,
    bid          int            not null,
    primary key (id)
);

drop table if exists seat;
create table seat
(
    id          int not null auto_increment,
    zid         int not null,
    rid         int not null,
    socket      BOOLEAN not null,
    today_book  varchar(25) not null,
    next_book   varchar(25) not null,
    primary key (id)
);

drop table if exists record;
create table record
(
    id          int         not null auto_increment,
    zid         int         not null,
    rid         int         not null,
    sid         varchar(16) not null,
    start_time  int         not null,
    end_time    int         not null,
    booking_date    DATE    not null,
    status      int         not null,
    primary key (id)
);

drop table if exists room;
create table room
(
    id          int         not null auto_increment,
    rid         int         not null,
    rname       varchar(16) not null,
    seat_amount int         not null,
    open_time   int         not null,
    close_time  int         not null,
    overnight   BOOLEAN     not null,
    max_booking_time    int not null,
    open        BOOLEAN     not null,
    primary key (id)
);