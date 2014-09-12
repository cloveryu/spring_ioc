use bookshelf;
drop table IF exists `t_book`;

create table t_book (
    ISBN varchar(25) not null,
    NAME varchar(50) not null,
    AUTHOR varchar(50) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO t_book (ISBN, NAME, AUTHOR) VALUES('9787111446231', 'Effective JavaScript', 'David Herman');
INSERT INTO t_book (ISBN, NAME, AUTHOR) VALUES('9787115211316', 'Effective Java', 'Joshua Bloch');