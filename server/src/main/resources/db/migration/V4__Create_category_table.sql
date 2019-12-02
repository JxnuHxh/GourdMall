create table category (
  cid varchar(32) NOT NULL comment "分类id",
  cname varchar(20) DEFAULT NULL comment "分类名称",
  PRIMARY KEY (cid)
);