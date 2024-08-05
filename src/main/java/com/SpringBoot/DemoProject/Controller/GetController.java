package com.SpringBoot.DemoProject.Controller;

import com.SpringBoot.DemoProject.Model.*;
import com.SpringBoot.DemoProject.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/get")
public class GetController {

    //get method in User class
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public List<User> User(){
        return userService.UserGetApi();
    }

    //get method in Address class
    @Autowired
    private AddressService addressService;
    @GetMapping("/address")
    public List<Address> Address(){
        return addressService.AddressGetApi();
    }

    //get method in Cart class
    @Autowired
    private CartService cartService;
    @GetMapping("/cart")
    public List<Cart> Cart(){
        return cartService.CartGetApi();
    }

    //get method in CartIterm class
    @Autowired
    private CartItermService cartItermService;
    @GetMapping("/cartiterm")
    public List<CartIterm> CartIterm(){
        return cartItermService.CartItermGetApi();
    }

    //get method in Category class
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/category")
    public List<Category> Category(){
        return categoryService.CategoryGetApi();
    }

    //get method in Order class
    @Autowired
    private OrdersService ordersService;
    @GetMapping("/orders")
    public List<Orders> Order(){
        return ordersService.OrdersGetApi();
    }

    //get method in Product class
    @Autowired
    private ProductService productService;
    @GetMapping("/Product")
    public List<Product> Product(){
        return productService.ProductGetApi();
    }

}

