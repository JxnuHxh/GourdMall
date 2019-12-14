package com.hlz.gourdmall.controller;

import com.hlz.gourdmall.dto.Result;
import com.hlz.gourdmall.enums.ResultCode;
import com.hlz.gourdmall.model.Cart;
import com.hlz.gourdmall.model.CartItem;
import com.hlz.gourdmall.model.Product;
import com.hlz.gourdmall.service.CartService;
import com.hlz.gourdmall.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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

    @ApiOperation("获取购物车")
    @GetMapping("/listCart")
    public Result listCart(HttpServletRequest request) {

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (null == cart) {
            //如果获取不到,创建购物车对象,放在session中
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        //如果获取到,使用即可
        //获取到商品id,数量
        String pid = request.getParameter("pid");
        int num = Integer.parseInt(request.getParameter("quantity"));
        Product product = cartService.getProductById(pid);
        //获取到待购买的购物项
        CartItem cartItem = new CartItem();
        cartItem.setNum(num);
        cartItem.setProduct(product);
        //调用购物车上的方法
        cart.addCartItemToCar(cartItem);
        return new Result(ResultCode.CATEGORY_FIND_SUCCESS, cart);
    }
}
