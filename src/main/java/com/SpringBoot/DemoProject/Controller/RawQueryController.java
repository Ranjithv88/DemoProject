package com.SpringBoot.DemoProject.Controller;

import com.SpringBoot.DemoProject.Model.*;
import com.SpringBoot.DemoProject.Service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/get/raw")
@RequiredArgsConstructor
public class RawQueryController {

    private final UserService userService;
    private final AddressService addressService;
    private final CartService cartService;
    private final CartItermService cartItermService;
    private final CategoryService categoryService;
    private final OrdersService ordersService;
    private final ProductService productService;


    // get Condition method in User class
    @GetMapping("/users/{id}")
    public List<User> user(@PathVariable Set<Long> id){
        return userService.UserRawGetApi(id);
    }

    // get Condition method in User class
    @GetMapping("/users/{addressId}")
    public List<Address> address(@PathVariable Set<Long> addressId){
        return addressService.AddressRawGetApi(addressId);
    }

    // get Condition method in CartIterm class
    @GetMapping("/users/{cartItermId}")
    public List<CartIterm> cartIterm(@PathVariable Set<Long> cartItermId){
        return cartItermService.CartItermRawGetApi(cartItermId);
    }

    // get Condition method in Cart class
    @GetMapping("/users/{cartId}")
    public List<Cart> cart(@PathVariable Set<Long> cartId){
        return cartService.CartRawGetApi(cartId);
    }

    // get Condition method in Category class
    @GetMapping("/users/{categoryId}")
    public List<Category> Category(@PathVariable Set<Long> categoryId){
        return categoryService.CategoryRawGetApi(categoryId);
    }

    // get Condition method in Order class
    @GetMapping("/users/{orderId}")
    public List<Orders> Order(@PathVariable Set<Long> orderId){
        return ordersService.OrderRawGetApi(orderId);
    }

    // get Condition method in User class
    @GetMapping("/users/{productId}")
    public List<Product> product(@PathVariable Set<Long> productId){
        return productService.ProductRawGetApi(productId);
    }

}

