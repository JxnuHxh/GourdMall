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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Davion
 * @date: 2019/12/3
 * @description:
 */
@Service
public class ProductService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductExtMapper productExtMapper;

    @Autowired
    private Page2Data page2Data;

    public Map<String, Object> listProduct(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Product> products = productExtMapper.listProduct();
        Map<String, Object> data = page2Data.page2Data(products);
        return data;
    }

    public Map<String, Object> getProductById(String id) {
        Product product = productMapper.selectByPrimaryKey(id);
        if (product != null) {
            Map<String, Object> data = new HashMap<>();
            data.put("data", product);
            return data;
        }
        return null;
    }

    public boolean insert(Product product) {
        product.setPdate(new Date());
        int insert = productMapper.insert(product);
        return insert > 0;
    }

    public boolean deleteProductById(String id) {
        int ans = productMapper.deleteByPrimaryKey(id);
        return ans > 0;
    }

    public boolean update(Product product) {
        int ans = productMapper.updateByPrimaryKey(product);
        return ans > 0;
    }
}
