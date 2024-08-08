package com.SpringBoot.DemoProject.Controller;

import com.SpringBoot.DemoProject.Service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller/delete")
@RequiredArgsConstructor
public class DeleteController {

    private final AddressService addressService;
    private final CartService cartService;
    private final CartItermService cartItermService;
    private final CategoryService categoryService;
    private final OrdersService ordersService;
    private final ProductService productService;


    //Delete method in Address class
    @DeleteMapping("/address/{id}")
    public String address(@Valid @PathVariable long addressId){
        return addressService.AddressDeleteApi(addressId);
    }

    //Delete method in Cart class
    @DeleteMapping("/cart/{id}")
    public String cart(@Valid @PathVariable long cartId){
        return cartService.CartDeleteApi(cartId);
    }

    //Delete method in CartIterm class
    @DeleteMapping("/cartiterm/{id}")
    public String cartIterm(@Valid @PathVariable long cartItermId) {
        return cartItermService.CartItermDeleteApi(cartItermId);
    }

    //Delete method in Category class
    @DeleteMapping("/category/{id}")
    public String category(@Valid @PathVariable long categoryId){
        return categoryService.CategoryDeleteApi(categoryId);
    }

    //Delete method in Order class
    @DeleteMapping("/orders/{id}")
    public String orders(@Valid @PathVariable long orderId){
        return ordersService.OrdersDeleteApi(orderId);
    }

    //Delete method in Product class
    @DeleteMapping("/product/{id}")
    public String product(@Valid @PathVariable long productId){
        return productService.ProductDeleteApi(productId);
    }

}

