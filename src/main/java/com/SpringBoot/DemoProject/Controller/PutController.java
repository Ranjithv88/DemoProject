package com.SpringBoot.DemoProject.Controller;

import com.SpringBoot.DemoProject.Model.*;
import com.SpringBoot.DemoProject.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/put")
public class PutController {

//Put method in User class
    @Autowired
    private UserService userService;
    @PutMapping("/users/{id}")
    public String users(@RequestBody User user, @PathVariable long id){
        user.setId(id);
        return userService.UserPutApi(user);
    }

//Put method in Address class
    @Autowired
    private AddressService addressService;
    @PutMapping("/address/{id}")
    public String Address(@RequestBody Address address, @PathVariable long id){
        address.setAddressId(id);
        return addressService.AddressPutApi(address);
    }

//Put method in Cart class
    @Autowired
    private CartService cartService;
    @PutMapping("/cart/{id}")
    public String Cart(@RequestBody Cart cart, @PathVariable long id){
        cart.setCartId(id);
        return cartService.CartPutApi(cart);
    }

//Put method in CartIterm class
    @Autowired
    private CartItermService cartItermService;
    @PutMapping("/cartiterm/{id}")
    public String CartIterm(@RequestBody CartIterm cartIterm, @PathVariable long id) {
        cartIterm.setCartItermId(id);
        return cartItermService.CartItermPutApi(cartIterm);
    }

//Put method in Category class
    @Autowired
    private CategoryService categoryService;
    @PutMapping("/category/{id}")
    public String Category(@RequestBody Category category, @PathVariable long id){
        category.setCategoryId(id);
        return categoryService.CategoryPutApi(category);
    }

//Put method in Order class
    @Autowired
    private OrdersService ordersService;
    @PutMapping("/orders/{id}")
    public String Orders(@RequestBody Orders order, @PathVariable long id){
        order.setOrderId(id);
        return ordersService.OrdersPutApi(order);
    }

//Put method in Product class
    @Autowired
    private ProductService productService;
    @PutMapping("/product/{id}")
    public String Product(@RequestBody Product product, @PathVariable long id){
        product.setProductId(id);
        return productService.ProductPutApi(product);
    }

}

