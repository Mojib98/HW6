/*create table if not exists branch(
    numid serial,
    name varchar(20),
    manegename varchar(20),
    branchid char(4) primary key
);*/
create table if not exists mangelist
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