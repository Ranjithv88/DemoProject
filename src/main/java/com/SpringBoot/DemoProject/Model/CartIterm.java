package com.SpringBoot.DemoProject.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class CartIterm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItermId;

    @ManyToMany
    @JoinTable(
            name = "product_cartIterm",
            joinColumns = @JoinColumn(name = "cartItemId"),
            inverseJoinColumns = @JoinColumn(name = "productId")
    )
    @JsonIgnoreProperties("CartItem")
    private Set<Product> products ;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;
    private LocalDate CreatedOn;

    public Long getCartItermId() {
        return cartItermId;
    }

    public void setCartItermId(Long cartItermId) {
        this.cartItermId = cartItermId;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public LocalDate getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        CreatedOn = createdOn;
    }

}

