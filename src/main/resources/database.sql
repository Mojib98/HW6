create table if not exists branch(
    numid serial,
    name varchar(20),
    manegename varchar(20),
    branchid char(4) ,
    primary key (branchid)
);
create table if not exists mangelist
(
    ids        serial,
    name       varchar(20),
    nationalid char(5) unique,
    employeeid char(4) primary key,
    branchids   char(4),
    namebranch varchar(20),
    rank       varchar(10),
    foreign key (branchids) references branch(branchid)
);
create table if not exists employee
(
    ids        serial,
    name       varchar(20),
    nationalid char(5) unique,
    employeeid char(4) primary key,
    branchid   char(4),
    namebranch varchar(20),
    rank       varchar(10),
    constraint fk_branch foreign key (branchid) references branch (branchid)
);
create table if not exists account(
    id serial,
    name varchar(20),
    accountid varchar(4) primary key ,
    branchid varchar(4),
    branchname varchar(20),
    cardid char(16) unique ,
    amount bigint);

create table if not exists creditcard(
    cardid char(16),
    cvv2 char(4),
    password char(4),
    status varchar(10),
        foreign key (cardid) references account(cardid)
                                     );
