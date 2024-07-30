package com.SpringBoot.DemoProject.Controller;

import com.SpringBoot.DemoProject.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/delete/list")
public class DeleteListController {

//Delete List of id method in User class
    @Autowired
    private UserService userService;
    @DeleteMapping("/users")
    public String Users(@RequestBody List<Long> user){
        return userService.UserDeleteListApi(user);
    }

//Delete List of id method in Address class
    @Autowired
    private AddressService addressService;
    @DeleteMapping("/address")
    public String Address(@RequestBody List<Long> Address){
        return addressService.AddressDeleteListApi(Address);
    }

//Delete List of id method in CartIterm class
    @Autowired
    private CartItermService cartItermService;
    @DeleteMapping("/cartiterm")
    public String CartIterm(@RequestBody List<Long> CartIterm){
        return cartItermService.CartItermDeleteListApi(CartIterm);
    }

//Delete List of id method in Cart class
    @Autowired
    private CartService cartService;
    @DeleteMapping("/cart")
    public String Cart(@RequestBody List<Long> Cart){
        return cartService.CartDeleteListApi(Cart);
    }

//Delete List of id method in Category class
    @Autowired
    private CategoryService categoryService;
    @DeleteMapping("/category")
    public String Category(@RequestBody List<Long> Category){
        return categoryService.CategoryDeleteListApi(Category);
    }

//Delete List of id method in Orders class
    @Autowired
    private OrdersService ordersService;
    @DeleteMapping("/orders")
    public String Orders(@RequestBody List<Long> Orders){
        return ordersService.OrdersDeleteListApi(Orders);
    }

//Delete List of id method in Product class
    @Autowired
    private ProductService productService;
    @DeleteMapping("/product")
    public String Product(@RequestBody List<Long> product){
        return productService.ProductDeleteListApi(product);
    }

}

