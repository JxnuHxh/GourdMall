package com.hlz.gourdmall.service;

import com.hlz.gourdmall.mapper.ProductMapper;
import com.hlz.gourdmall.model.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Hxh
 * @date: 2019/12/14
 * @description:
 */
@Service
public class CartService {
    @Resource
    private ProductMapper productMapper;

    public Product getProductById(String id) {
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }
}
