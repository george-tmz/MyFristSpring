create table user
(
    id   bigint primary key auto_increment,
    name varchar(100)
);

create table match
(
    id      bigint primary key auto_increment,
    user_id bigint,
    score   int
);

insert into user (id, name)
values (1, 'AAA');
insert into user (id, name)
values (2, 'BBB');
insert into user (id, name)
values (3, 'CCC');


insert into match (id, user_id, score)
values (1, 1, 1000);
insert into match (id, user_id, score)
values (2, 1, 2000);
insert into match(id, user_id, score)
values (3, 2, 500);
insert into match(id, user_id, score)
values (4, 3, 3000);