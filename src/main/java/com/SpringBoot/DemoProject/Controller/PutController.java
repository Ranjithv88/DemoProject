package com.SpringBoot.DemoProject.Controller;

import com.SpringBoot.DemoProject.Model.*;
import com.SpringBoot.DemoProject.Service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller/put")
@RequiredArgsConstructor
public class PutController {

    private final AddressService addressService;
    private final CartService cartService;
    private final CartItermService cartItermService;
    private final CategoryService categoryService;
    private final OrdersService ordersService;
    private final ProductService productService;


    //Put method in Address class
    @PutMapping("/address/{id}")
    public String Address(@RequestBody Address address, @PathVariable long id){
        address.setAddressId(id);
        return addressService.AddressPutApi(address);
    }

    //Put method in Cart class
    @PutMapping("/cart/{id}")
    public String Cart(@RequestBody Cart cart, @PathVariable long id){
        cart.setCartId(id);
        return cartService.CartPutApi(cart);
    }

    //Put method in CartIterm class
    @PutMapping("/cartiterm/{id}")
    public String CartIterm(@RequestBody CartIterm cartIterm, @PathVariable long id) {
        cartIterm.setCartItermId(id);
        return cartItermService.CartItermPutApi(cartIterm);
    }

    //Put method in Category class
    @PutMapping("/category/{id}")
    public String Category(@RequestBody Category category, @PathVariable long id){
        category.setCategoryId(id);
        return categoryService.CategoryPutApi(category);
    }

    //Put method in Order class
    @PutMapping("/orders/{id}")
    public String Orders(@RequestBody Orders order, @PathVariable long id){
        order.setOrderId(id);
        return ordersService.OrdersPutApi(order);
    }

    //Put method in Product class
    @PutMapping("/product/{id}")
    public String Product(@RequestBody Product product, @PathVariable long id){
        product.setProductId(id);
        return productService.ProductPutApi(product);
    }

}

