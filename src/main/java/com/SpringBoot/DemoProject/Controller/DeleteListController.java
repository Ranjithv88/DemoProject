package com.SpringBoot.DemoProject.Controller;

import com.SpringBoot.DemoProject.Service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seller/delete/list")
@RequiredArgsConstructor
public class DeleteListController {

    private final AddressService addressService;
    private final CartService cartService;
    private final CartItermService cartItermService;
    private final CategoryService categoryService;
    private final OrdersService ordersService;
    private final ProductService productService;


    //Delete List of id method in Address class
    @DeleteMapping("/address")
    public String Address(@RequestBody List<Long> Address){
        return addressService.AddressDeleteListApi(Address);
    }

    //Delete List of id method in CartIterm class
    @DeleteMapping("/cartiterm")
    public String CartIterm(@RequestBody List<Long> CartIterm){
        return cartItermService.CartItermDeleteListApi(CartIterm);
    }

    //Delete List of id method in Cart class
    @DeleteMapping("/cart")
    public String Cart(@RequestBody List<Long> Cart){
        return cartService.CartDeleteListApi(Cart);
    }

    //Delete List of id method in Category class
    @DeleteMapping("/category")
    public String Category(@RequestBody List<Long> Category){
        return categoryService.CategoryDeleteListApi(Category);
    }

    //Delete List of id method in Orders class
    @DeleteMapping("/orders")
    public String Orders(@RequestBody List<Long> Orders){
        return ordersService.OrdersDeleteListApi(Orders);
    }

    //Delete List of id method in Product class
    @DeleteMapping("/product")
    public String Product(@RequestBody List<Long> product){
        return productService.ProductDeleteListApi(product);
    }

}

