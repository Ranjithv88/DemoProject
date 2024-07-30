package com.SpringBoot.DemoProject.Service;

import com.SpringBoot.DemoProject.Model.CartIterm;
import com.SpringBoot.DemoProject.Repository.CartItermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItermService {

    @Autowired
    private CartItermRepository cartItermRepository;

    public List<CartIterm> CartItermGetApi() {
        return cartItermRepository.findAll();
    }

    public String CartItermPostApi(CartIterm cartIterm) {
        cartItermRepository.save(cartIterm);
        return " CartIterm Record Saved ! ";
    }

    public String CartItermPutApi(CartIterm cartIterm) {
        cartItermRepository.save(cartIterm);
        return " CartIterm Record Update ! ";
    }

    public String CartItermDeleteApi(long cartItermId) {
        cartItermRepository.deleteById(cartItermId);
        return " Delete Record Successfully !";
    }

    public String CartItermDeleteListApi(List<Long> cartItermId) {
        for(Long cartIterm :cartItermId) {
            cartItermRepository.deleteById(cartIterm);
        }
        return " List of ID Deleted Successfully !";
    }

}

