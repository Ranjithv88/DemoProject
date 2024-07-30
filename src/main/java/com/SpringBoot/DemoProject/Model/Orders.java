package com.SpringBoot.DemoProject.Model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @ManyToMany
    @JoinTable(name = "UserOrder",joinColumns = @JoinColumn(name = "userId"),inverseJoinColumns = @JoinColumn(name = "OrderId"))
    private Set<User> user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId",referencedColumnName = "cartId")
    private Cart cart;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}

