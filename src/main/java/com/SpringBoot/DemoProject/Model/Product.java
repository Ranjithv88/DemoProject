package com.SpringBoot.DemoProject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @NotBlank(message = " Name is Mandatory ! ")
    @Size(min = 2,max = 30,message = " Name must be between 2 and 30 characters ! ")
    private String name;

    @NotNull
    private String description;

    @NotNull(message = " Number is Mandatory ! ")
    @Pattern(regexp = "^\\d{10}$", message = " Number is Not valid ! ") // Double Data Type Format (12.33445) OR Price Format (19.99)
    private double price;

    @NotNull(message = " Stuck is Mandatory ! ")
    private long stack;

    private LocalDate CreatedOn;
    private String image;

    @ManyToMany(mappedBy = "products")
    private Set<CartIterm> cartIterms ;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

}

