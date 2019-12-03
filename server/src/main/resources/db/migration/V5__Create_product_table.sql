# CREATE TABLE `product` (
#    `pid` varchar(32) NOT NULL,
#    `pname` varchar(50) DEFAULT NULL COMMENT "商品名称",
#    `market_price` double DEFAULT NULL COMMENT "市场价",
#    `shop_price` double DEFAULT NULL COMMENT "商城价",
#
#    `pimage` varchar(200) DEFAULT NULL COMMENT "商品图片路径",
#
#    `pdate` date DEFAULT NULL COMMENT "上架时间",
#    `is_hot` int(11) DEFAULT NULL COMMENT "是否热门" ,#0=不热门,1=热门
#    `pdesc` varchar(255) DEFAULT NULL COMMENT "商品描述",
#    `pflag` int(11) DEFAULT 0 COMMENT "商品标记 ",	#0=未下架(默认值),1=已经下架
#    `cid` varchar(32) DEFAULT NULL COMMENT "分类id",
#    PRIMARY KEY (`pid`),
#    KEY `product_fk_0001` (`cid`),
#    CONSTRAINT `product_fk_0001` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
#  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table product
(
    pid varchar(32) not null,
    pname varchar(50) default null null,
    market_price double default null null,
    shop_price double default null null,
    pimg varchar(200) default null null,
    pdate date default null null,
    is_hot int default null null,
    pdesc varchar(255) default null null,
    pflag int default null null,
    cid varchar(32) default null null,
    constraint product_pk
        primary key (pid),
    constraint product_category_cid_fk
        foreign key (cid) references category (cid)
);

