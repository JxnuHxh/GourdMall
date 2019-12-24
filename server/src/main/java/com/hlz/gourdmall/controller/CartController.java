package com.hlz.gourdmall.controller;


import com.hlz.gourdmall.dto.Result;
import com.hlz.gourdmall.enums.ResultCode;
import com.hlz.gourdmall.dto.Cart;
import com.hlz.gourdmall.dto.CartItem;
import com.hlz.gourdmall.model.Product;
import com.hlz.gourdmall.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author: Hxh
 * @date: 2019/12/14
 * @description:
 */
@Api(tags = "购物车接口")
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
   @Autowired
   private RedisTemplate redisTemplate;
    
    @ApiOperation("增加商品到购物车")
    @GetMapping("/addToCart")
    public Result addCart(String pid, int num,int uid) {
          System.out.println(pid+" "+num);
        Cart cart = (Cart) redisTemplate.opsForValue().get("cart"+uid);
        if (null == cart) {
            cart = new Cart();
        }
        //如果获取到,使用即可
        //获取到商品id,数量
        Product product = cartService.getProductId(pid);
        //获取到待购买的购物项
        CartItem cartItem = new CartItem();
        cartItem.setNum(num);
        cartItem.setProduct(product);
        cartItem.setSubTotal(num*product.getShopPrice());
        //调用购物车上的方法
        cart.addCartItemToCar(cartItem);
        cart.getTotal();
        redisTemplate.opsForValue().set("cart"+uid,cart);
        return new Result(ResultCode.CART_ADD_SUCCESS, cart);
    }
    @ApiOperation("根据商品id删除购物车的商品")
    @DeleteMapping("deleteCart")
    public Result deleteCart(String pid, Integer uid) {
        System.out.println(pid);
        Cart cart = (Cart) redisTemplate.opsForValue().get("cart"+uid);
        //调用购物车删除购物项方法
        cart.removeCartItem(pid);
        redisTemplate.opsForValue().set("cart"+uid,cart);
        return new Result(ResultCode.CART_DELETE_SUCCESS, cart);
    }
    @ApiOperation("清空购物车")
    @DeleteMapping("clearCart")
    public Result clearCart(Integer uid) {

        Cart cart = (Cart) redisTemplate.opsForValue().get("cart"+uid);
        //调用购物车删除购物项方法
        cart.clearCart();
        redisTemplate.opsForValue().set("cart"+uid,cart);
        return new Result(ResultCode.CART_DELETE_SUCCESS, cart);
    }
    @ApiOperation("查看购物车")
    @GetMapping("allCart")
    public Result selectCart(Integer uid) {
        Cart cart = (Cart) redisTemplate.opsForValue().get("cart"+uid);
        return new Result(ResultCode.CART_SELECT_SUCCESS, cart);
    }
}
