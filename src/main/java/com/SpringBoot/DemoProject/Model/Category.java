package com.SpringBoot.DemoProject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    @NotBlank(message = " Name is Mandatory ! ")
    @Size(min = 2,max = 30,message = " Name must be between 2 and 30 characters ! ")
    private String name;

    private LocalDate CreatedOn;
    private Boolean Status;

    @OneToMany(mappedBy ="category",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Product> products;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public @NotBlank(message = " Name is Mandatory ! ") @Size(min = 2, max = 30, message = " Name must be between 2 and 30 characters ! ") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = " Name is Mandatory ! ") @Size(min = 2, max = 30, message = " Name must be between 2 and 30 characters ! ") String name) {
        this.name = name;
    }

    public LocalDate getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        CreatedOn = createdOn;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}

