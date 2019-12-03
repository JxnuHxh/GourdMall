# CREATE TABLE `orderitem` (
#   `itemid` varchar(32) NOT NULL,
#   `quantity` int(11) DEFAULT NULL comment "购买数量",
#   `total` double DEFAULT NULL comment "小计",
#   `pid` varchar(32) DEFAULT NULL comment "购买商品的ID",
#   `oid` varchar(32) DEFAULT NULL comment "订单项所在订单id",
#   PRIMARY KEY (`itemid`),
#   KEY `order_item_fk_0001` (`pid`),
#   KEY `order_item_fk_0002` (`oid`),
#   CONSTRAINT `order_item_fk_0001` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`),
#   CONSTRAINT `order_item_fk_0002` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`)
# ) ;
create table orderitem
(
    itemid varchar(32) not null,
    quantity int default null null,
    total double default null null,
    pid varchar(32) default null null,
    oid varchar(32) default null null,
    constraint orderitem_pk
        primary key (itemid),
    constraint orderitem_orders_oid_fk
        foreign key (oid) references orders (oid),
    constraint orderitem_product_pid_fk
        foreign key (pid) references product (pid)
);

