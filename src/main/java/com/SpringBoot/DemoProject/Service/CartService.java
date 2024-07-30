package com.SpringBoot.DemoProject.Service;

import com.SpringBoot.DemoProject.Model.Cart;
import com.SpringBoot.DemoProject.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> CartGetApi() {
        return cartRepository.findAll();
    }

    public String CartPostApi(Cart cart) {
        cartRepository.save(cart);
        return " Cart Record Saved ! ";
    }

    public String CartPutApi(Cart cart) {
        cartRepository.save(cart);
        return " Cart Record Update ! ";
    }

    public String CartDeleteApi(long cartId) {
        cartRepository.deleteById(cartId);
        return " Delete Record Successfully !";
    }

    public String CartDeleteListApi(List<Long> cartId) {
        for(Long cart :cartId) {
            cartRepository.deleteById(cart);
        }
        return " List of ID Deleted Successfully !";
    }

}

