package com.SpringBoot.DemoProject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Set;

@Entity
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

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public @NotBlank(message = " Name is Mandatory ! ") @Size(min = 2, max = 30, message = " Name must be between 2 and 30 characters ! ") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = " Name is Mandatory ! ") @Size(min = 2, max = 30, message = " Name must be between 2 and 30 characters ! ") String name) {
        this.name = name;
    }

    public @NotNull String getDescription() {
        return description;
    }

    public void setDescription(@NotNull String description) {
        this.description = description;
    }

    @NotNull(message = " Number is Mandatory ! ")
    @Pattern(regexp = "^\\d{10}$", message = " Number is Not valid ! ")
    public double getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = " Number is Mandatory ! ") @Pattern(regexp = "^\\d{10}$", message = " Number is Not valid ! ") double price) {
        this.price = price;
    }

    @NotNull(message = " Stuck is Mandatory ! ")
    public long getStack() {
        return stack;
    }

    public void setStack(@NotNull(message = " Stuck is Mandatory ! ") long stack) {
        this.stack = stack;
    }

    public LocalDate getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        CreatedOn = createdOn;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<CartIterm> getCartIterms() {
        return cartIterms;
    }

    public void setCartIterms(Set<CartIterm> cartIterms) {
        this.cartIterms = cartIterms;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}

