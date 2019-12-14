create table token
(
	id bigint auto_increment,
	token varchar(256) not null,
	create_time datetime default now() null,
	uid bigint null,
	constraint token_pk
		primary key (id),
	constraint token_user_uid_fk
		foreign key (uid) references user (uid)
);

