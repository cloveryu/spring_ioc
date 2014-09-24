use bookshelf;
drop table IF exists `t_book`;
drop table IF exists `t_salary`;

create table t_book (
    ID int AUTO_INCREMENT PRIMARY KEY,
    ISBN varchar(25) not null,
    NAME varchar(50) not null,
    AUTHOR varchar(50) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table t_salary (
    ID int(4) not null,
    NAME varchar(50) not null,
    SALARY int(4) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO t_book (ID, ISBN, NAME, AUTHOR) VALUES(1, '9787111446231', 'Effective JavaScript', 'David Herman');
INSERT INTO t_book (ID, ISBN, NAME, AUTHOR) VALUES(2, '9787115211316', 'Effective Java', 'Joshua Bloch');

INSERT INTO t_salary (ID, NAME, SALARY) VALUES(1, 'clover', 100);