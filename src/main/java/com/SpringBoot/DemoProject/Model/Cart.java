package com.SpringBoot.DemoProject.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId",referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "cartItermId",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CartIterm> cartIterm;
    private LocalDate createdOn;

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartIterm> getCartIterm() {
        return cartIterm;
    }

    public void setCartIterm(List<CartIterm> cartIterm) {
        this.cartIterm = cartIterm;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

}

