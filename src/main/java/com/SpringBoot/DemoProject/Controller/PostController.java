package com.SpringBoot.DemoProject.Controller;

import com.SpringBoot.DemoProject.Model.*;
import com.SpringBoot.DemoProject.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

//Post method in User class
    @Autowired
    private UserService userService;
    @PostMapping("/users")
    public String user(@RequestBody User user){
        return userService.UserPostApi(user);
    }

//Post method in Address class
    @Autowired
    private AddressService addressService;
    @PostMapping("/address")
    public String Address(@RequestBody Address address){
        return addressService.AddressPostApi(address);
    }

//Post method in Cart class
    @Autowired
    private CartService cartService;
    @PostMapping("/cart")
    public String Cart(@RequestBody Cart cart){
        return cartService.CartPostApi(cart);
    }

//Post method in CartIterm class
    @Autowired
    private CartItermService cartItermService;
    @PostMapping("/cartiterm")
    public String CartIterm(@RequestBody CartIterm cartIterm) {
        return cartItermService.CartItermPostApi(cartIterm);
    }

//Post method in Category class
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/category")
    public String Category(@RequestBody Category category){
        return categoryService.CategoryPostApi(category);
    }

//Post method in Order class
    @Autowired
    private OrdersService ordersService;
    @PostMapping("/orders")
    public String Orders(@RequestBody Orders order){
        return ordersService.OrdersPostApi(order);
    }

//Post method in Product class
    @Autowired
    private ProductService productService;
    @PostMapping("/product")
    public String Product(@RequestBody Product product){
        return productService.ProductPostApi(product);
    }

}

