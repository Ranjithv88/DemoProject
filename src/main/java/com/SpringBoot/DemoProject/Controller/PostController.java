package com.SpringBoot.DemoProject.Controller;

import com.SpringBoot.DemoProject.Model.*;
import com.SpringBoot.DemoProject.Service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller/post")
@RequiredArgsConstructor
public class PostController {

    private final AddressService addressService;
    private final CartService cartService;
    private final CartItermService cartItermService;
    private final CategoryService categoryService;
    private final OrdersService ordersService;
    private final ProductService productService;


    //Post method in Address class
    @PostMapping("/address")
    public String address(@Valid @RequestBody Address address){
        return addressService.AddressPostApi(address);
    }

    //Post method in Cart class
    @PostMapping("/cart")
    public String cart(@Valid @RequestBody Cart cart){
        return cartService.CartPostApi(cart);
    }

    //Post method in CartIterm class
    @PostMapping("/cartiterm")
    public String cartIterm(@Valid @RequestBody CartIterm cartIterm) {
        return cartItermService.CartItermPostApi(cartIterm);
    }

    //Post method in Category class
    @PostMapping("/category")
    public String category(@Valid @RequestBody Category category){
        return categoryService.CategoryPostApi(category);
    }

    //Post method in Order class
    @PostMapping("/orders")
    public String orders(@Valid @RequestBody Orders order){
        return ordersService.OrdersPostApi(order);
    }

    //Post method in Product class
    @PostMapping("/product")
    public String product(@Valid @RequestBody Product product){
        return productService.ProductPostApi(product);
    }

}

