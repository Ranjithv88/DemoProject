package com.SpringBoot.DemoProject.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

}

