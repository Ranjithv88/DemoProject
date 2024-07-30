package com.SpringBoot.DemoProject.Service;

import com.SpringBoot.DemoProject.Model.Product;
import com.SpringBoot.DemoProject.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> ProductGetApi() {
        return productRepository.findAll();
    }

    public String ProductPostApi(Product product) {
        product.setCreatedOn(LocalDate.now());
        productRepository.save(product);
        return " Product Data Saved ! ";
    }

    public String ProductPutApi(Product product) {
        productRepository.save(product);
        return " Product Record Update ! ";
    }

    public String ProductDeleteApi(long productId) {
        productRepository.deleteById(productId);
        return " Delete Record Successfully !";
    }

    public String ProductDeleteListApi(List<Long> productId) {
        for(Long product :productId) {
            productRepository.deleteById(product);
        }
        return " List of ID Deleted Successfully !";
    }

}

