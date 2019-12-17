package com.hlz.gourdmall.controller;

import com.hlz.gourdmall.dto.Cart;
import com.hlz.gourdmall.dto.CartItem;
import com.hlz.gourdmall.dto.Result;
import com.hlz.gourdmall.enums.ResultCode;
import com.hlz.gourdmall.model.*;
import com.hlz.gourdmall.service.OrderService;
import com.hlz.gourdmall.util.UUIDUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: Hxh
 * @date: 2019/12/9
 * @description:
 */
@Api(tags = "订单接口")
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @ApiOperation("提交订单")
    @GetMapping("/saveOrder")
    public  Result aboutOrder(List<OrderItem> orderItems, String telephone,String name,String address,Long uid){
        Order order=orderService.aboutOrder(orderItems,telephone,name,address,uid);
        return new Result(ResultCode.CATEGORY_FIND_SUCCESS, order);
    }

    @ApiOperation("查询当前用户下所有订单")
    @GetMapping("/listOrder")
    public Result selectAllCategory(@RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
                                                  Integer uid) {

        Map<String, Object> orders = orderService.selectAllOrder(pageSize, pageNum, uid);
        return new Result(ResultCode.CATEGORY_FIND_SUCCESS, orders);
    }
    @ApiOperation("根据订单ID查询订单")
    @GetMapping("/{id}")
    public Result getOrderById(@PathVariable(name = "id") String id) {
        Map<String, Object> data = orderService.getOrderById(id);
        return new Result(ResultCode.PRODUCT_FIND_SUCCESS, data);
    }
    @ApiOperation("更新订单")
    @PutMapping("/updateOrder")
    public  Result updateOrder(Order order){
        Integer data=orderService.updateOrder(order);
        return new Result(ResultCode.PRODUCT_FIND_SUCCESS, data);
    }
    @ApiOperation("订单详情")
    @PutMapping("/aboutOrder")
    public Result addOrder(Order order, HttpServletRequest request){
        //确认用户登录状态
        User user=(User)request.getSession().getAttribute("loginUser");
        if(null==user){
            //请在登录后下单
            return new Result(ResultCode.PRODUCT_FIND_SUCCESS, null);
        }
        //获取购物车
        Cart cart=(Cart)request.getSession().getAttribute("cart");
        //创建订单对象,为订单对象赋值
        order.setOid(UUIDUtils.getId());
        order.setOrdertime(new Date());
        order.setTotal(cart.getTotal());
        order.setState(1);
        order.setUid(user.getUid());
        //遍历购物项的同时,创建订单项,为订单项赋值
        for (CartItem item : cart.getCartItems()) {
            OrderItem orderItem=new OrderItem();
            orderItem.setItemid(UUIDUtils.getCode());
            orderItem.setQuantity(item.getNum());
            orderItem.setTotal(item.getSubTotal());
            orderItem.setPid(item.getProduct().getPid());
            //设置当前的订单项属于哪个订单:程序的角度体检订单项和订单对应关系
            orderItem.setOid(order.getOid());
            order.getList().add(orderItem);
        }
        //调用业务层功能:保存订单
        //将订单数据,用户的数据,订单下所有的订单项都传递到了service层
        orderService.saveOrder(order);
        //清空购物车
        cart.clearCart();
        return new Result(ResultCode.PRODUCT_FIND_SUCCESS, order);
    }
    @ApiOperation("删除订单")
    @DeleteMapping("/deleteOrder")
    public  Result deleteOrder(String id){
        Integer data=orderService.deleteOrder(id);
        return new Result(ResultCode.PRODUCT_FIND_SUCCESS, data);
    }
}
