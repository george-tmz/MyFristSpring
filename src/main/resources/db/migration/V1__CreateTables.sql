CREATE TABLE `user`
(
    id     BIGINT UNSIGNED PRIMARY KEY NOT NULL auto_increment,
    `username` VARCHAR(100) NOT NULL DEFAULT ""
);



insert into user (id, username)
values (1, 'AAA');
insert into user (id, username)
values (2, 'BBB');
insert into user (id, username)
values (3, 'CCC');


