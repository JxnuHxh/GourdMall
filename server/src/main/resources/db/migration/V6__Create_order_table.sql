
CREATE TABLE `orders` (
   `oid` varchar(32) NOT NULL,
   `ordertime` datetime DEFAULT NULL comment "下单时间",
   `total` double DEFAULT NULL comment "总价",
   `state` int(11) DEFAULT NULL comment "订单状态",
   			#1=未付款;2=已付款,未发货;3=已发货,没收货;4=收货,订单结束
   `address` varchar(30) DEFAULT NULL comment "收获地址",
   `name` varchar(20) DEFAULT NULL comment "收货人",
   `telephone` varchar(20) DEFAULT NULL comment "收货人带电话",
   `uid` bigint,
   PRIMARY KEY (`oid`),
   KEY `order_fk_0001` (`uid`),
   CONSTRAINT `order_fk_0001` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
 ) ;
