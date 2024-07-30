package com.SpringBoot.DemoProject.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

}

