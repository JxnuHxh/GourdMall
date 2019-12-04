#
# CREATE TABLE `orders` (
#    `oid` varchar(32) NOT NULL,
#    `ordertime` datetime DEFAULT NULL comment "下单时间",
#    `total` double DEFAULT NULL comment "总价",
#    `state` int(11) DEFAULT NULL comment "订单状态",
#    			#1=未付款;2=已付款,未发货;3=已发货,没收货;4=收货,订单结束
#    `address` varchar(30) DEFAULT NULL comment "收获地址",
#    `name` varchar(20) DEFAULT NULL comment "收货人",
#    `telephone` varchar(20) DEFAULT NULL comment "收货人带电话",
#    `uid` bigint,
#    PRIMARY KEY (`oid`),
#    KEY `order_fk_0001` (`uid`),
#    CONSTRAINT `order_fk_0001` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
#  ) ;
create table orders
(
    oid varchar(32) not null,
    ordertime datetime default null null,
    total double default null null,
    state int default null null,
    address varchar(30) default null null,
    name varchar(20) default null null,
    telephone varchar(20) default null null,
    uid bigint null,
    constraint orders_pk
        primary key (oid),
    constraint orders_user_uid_fk
        foreign key (uid) references user (uid)
);