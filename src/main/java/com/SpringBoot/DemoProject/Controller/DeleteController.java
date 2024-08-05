package com.SpringBoot.DemoProject.Controller;

import com.SpringBoot.DemoProject.Service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delete")
@RequiredArgsConstructor
public class DeleteController {

    private final UserService userService;
    private final AddressService addressService;
    private final CartService cartService;
    private final CartItermService cartItermService;
    private final CategoryService categoryService;
    private final OrdersService ordersService;
    private final ProductService productService;

    //Delete method in User class
    @DeleteMapping("/users/{id}")
    public String user(@PathVariable long userId){
        return userService.UserDeleteApi(userId);
    }

    //Delete method in Address class
    @DeleteMapping("/address/{id}")
    public String Address(@PathVariable long addressId){
        return addressService.AddressDeleteApi(addressId);
    }

    //Delete method in Cart class
    @DeleteMapping("/cart/{id}")
    public String Cart(@PathVariable long cartId){
        return cartService.CartDeleteApi(cartId);
    }

    //Delete method in CartIterm class
    @DeleteMapping("/cartiterm/{id}")
    public String CartIterm(@PathVariable long cartItermId) {
        return cartItermService.CartItermDeleteApi(cartItermId);
    }

    //Delete method in Category class
    @DeleteMapping("/category/{id}")
    public String Category(@PathVariable long categoryId){
        return categoryService.CategoryDeleteApi(categoryId);
    }

    //Delete method in Order class
    @DeleteMapping("/orders/{id}")
    public String Orders(@PathVariable long orderId){
        return ordersService.OrdersDeleteApi(orderId);
    }

    //Delete method in Product class
    @DeleteMapping("/product/{id}")
    public String Product(@PathVariable long productId){
        return productService.ProductDeleteApi(productId);
    }

}

