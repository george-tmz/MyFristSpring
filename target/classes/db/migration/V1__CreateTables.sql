CREATE TABLE `user`
(
    id     BIGINT UNSIGNED PRIMARY KEY NOT NULL auto_increment,
    `name` VARCHAR(100) NOT NULL DEFAULT ""
);



insert into user (id, name)
values (1, 'AAA');
insert into user (id, name)
values (2, 'BBB');
insert into user (id, name)
values (3, 'CCC');


