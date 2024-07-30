package com.SpringBoot.DemoProject.Controller;

import com.SpringBoot.DemoProject.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delete")
public class DeleteController {

//Delete method in User class
    @Autowired
    private UserService userService;
    @DeleteMapping("/users/{id}")
    public String user(@PathVariable long userId){
        return userService.UserDeleteApi(userId);
    }

//Delete method in Address class
    @Autowired
    private AddressService addressService;
    @DeleteMapping("/address/{id}")
    public String Address(@PathVariable long addressId){
        return addressService.AddressDeleteApi(addressId);
    }

//Delete method in Cart class
    @Autowired
    private CartService cartService;
    @DeleteMapping("/cart/{id}")
    public String Cart(@PathVariable long cartId){
        return cartService.CartDeleteApi(cartId);
    }

//Delete method in CartIterm class
    @Autowired
    private CartItermService cartItermService;
    @DeleteMapping("/cartiterm/{id}")
    public String CartIterm(@PathVariable long cartItermId) {
        return cartItermService.CartItermDeleteApi(cartItermId);
    }

//Delete method in Category class
    @Autowired
    private CategoryService categoryService;
    @DeleteMapping("/category/{id}")
    public String Category(@PathVariable long categoryId){
        return categoryService.CategoryDeleteApi(categoryId);
    }

//Delete method in Order class
    @Autowired
    private OrdersService ordersService;
    @DeleteMapping("/orders/{id}")
    public String Orders(@PathVariable long orderId){
        return ordersService.OrdersDeleteApi(orderId);
    }

//Delete method in Product class
    @Autowired
    private ProductService productService;
    @DeleteMapping("/product/{id}")
    public String Product(@PathVariable long productId){
        return productService.ProductDeleteApi(productId);
    }

}

