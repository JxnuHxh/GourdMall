package com.hlz.gourdmall.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hlz.gourdmall.mapper.OrderExtMapper;
import com.hlz.gourdmall.mapper.OrderMapper;
import com.hlz.gourdmall.model.Category;
import com.hlz.gourdmall.model.Order;
import com.hlz.gourdmall.util.Page2Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator;

/**
 * @author: Hxh
 * @date: 2019/12/11
 * @description:
 */
@Service
public class OrderService {
    @Resource
    private OrderExtMapper orderExtMapper;

    @Autowired
    private Page2Data page2Data;
    @Resource
    private OrderMapper orderMapper;

    public Map<String, Object> selectAllOrder(int pageSize, int pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Order> orders = orderExtMapper.selectAllOrder();
        Map<String, Object> data = page2Data.page2Data(orders);
        return data;
    }

    public Map<String, Object> getOrderById(String id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        if (order != null) {
            Map<String, Object> data = new HashMap<>();
            data.put("data", order);
            return null;
        }
        return null;
    }

    public int updateOrder(Order order) {
        int result = orderMapper.updateByPrimaryKey(order);
        return result;
    }

    public int addOrder(Order order) {

        int result = orderMapper.insert(order);
        return result;

    }

    public int deleteOrder(String id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        if (order != null) {
            int result = orderMapper.deleteByPrimaryKey(id);
            return result;
        }
        return 0;

    }

}
