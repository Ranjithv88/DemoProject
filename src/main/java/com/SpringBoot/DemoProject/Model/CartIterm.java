package com.SpringBoot.DemoProject.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

}

