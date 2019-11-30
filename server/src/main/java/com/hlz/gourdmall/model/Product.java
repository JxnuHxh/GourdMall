package com.hlz.gourdmall.model;

import lombok.Data;

import java.util.Date;

/**
 * @author: Hxh
 * @date: 2019/11/26
 * @description:
 */
@Data
public class Product {
    private String pid;   //商品Id
    private  String pname; //商品名称
    private Double market_price; //市场价
    private Double shop_price; //商城价
    private String pimage;  //商品图片路径
    private Date pdate;    //上架时间
    private Integer is_hot; //是否热门
    private String pdescription; //商品描述
    private Integer pflag;  //商品状态 0已下架 1已上架
    private String cid;  //分类Id
}
