package com.hlz.gourdmall.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hlz.gourdmall.mapper.ProductExtMapper;
import com.hlz.gourdmall.mapper.ProductMapper;
import com.hlz.gourdmall.model.Product;
import com.hlz.gourdmall.util.Page2Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: Davion
 * @date: 2019/12/3
 * @description:
 */
@Service
public class ProductServer {

    @Resource
    private ProductExtMapper productExtMapper;

    @Autowired
    private Page2Data page2Data;

    public Map<String, Object> listProduct(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        Page<Product> products = productExtMapper.listProduct();
        Map<String, Object> data = page2Data.page2Data(products);
        return data;
    }

}
