create table user
(
    uid BIGINT auto_increment,
    sno varchar(20) not null,
    password varchar(256) not null,
    nickname varchar(20) default null null,
    email varchar(30) default null null,
    telephone varchar(20) default null null,
    create_time datetime default now() null,
    modified_time datetime default now() null,
    sex smallint default 0 null,
    state smallint default 0 not null,
    admin smallint default 0 not null,
    constraint user_pk
        primary key (uid)
);

create unique index user_sno_uindex
    on user (sno);

create table check_code
(
	id bigint auto_increment,
	uid bigint null,
	create_time datetime default now() null,
	code varchar(10) not null,
	state smallint default 0 null,
	constraint check_code_pk
		primary key (id),
	constraint check_code_user_uid_fk
		foreign key (uid) references user (uid)
);

