package com.hlz.gourdmall.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Ordering;
import com.hlz.gourdmall.mapper.OrderExtMapper;
import com.hlz.gourdmall.mapper.OrderMapper;
import com.hlz.gourdmall.mapper.UserMapper;
import com.hlz.gourdmall.model.*;
import com.hlz.gourdmall.util.Page2Data;
import com.hlz.gourdmall.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

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
    private UserMapper userMapper;
    @Resource
    private OrderMapper orderMapper;
   public Order aboutOrder(List<OrderItem> orderItems,String telephone, String name,String address,Long uid ){
       Order order=new Order();
       order.setOid(UUIDUtils.getId());
       order.setUid(uid);
       order.setAddress(address);
       order.setList(orderItems);
       order.setName(name);
       order.setTelephone(telephone);
       order.setState(1);
       order.setOrdertime(new Date());
       Double total=0.0;
       for (OrderItem item:orderItems){
           total=item.getTotal()+total;
       }
       order.setTotal(total);
       orderMapper.insert(order);
       return order;
   }

    public Map<String, Object> selectAllOrder(int pageSize, int pageNum,Integer uid) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Order> orders =  orderExtMapper.selectAllOrder(uid);
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

    public int saveOrder(Order order) {

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
