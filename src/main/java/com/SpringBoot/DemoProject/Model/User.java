package com.SpringBoot.DemoProject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = " Name is Mandatory ! ")
    @Size(min = 2,max = 30,message = " Name must be between 2 and 30 characters ! ")
    private String name;

    @NotBlank(message = " Email is Mandatory ! ")
    @Email(message = " Not Valid ! ")
    private String email;

    @NotNull(message = " password is Mandatory ! ")
    @Pattern(regexp = "^\\d{10}$", message = " Number is Not valid ! ")
    private String number;

    @NotBlank(message = " password is Mandatory ! ")
    @Size(min = 8,message = " Too weak ! ")
    private String password;

    @NotNull(message = " DateOfBirth is Mandatory ! ")
    @Past(message = " Date of Birth must be a past date ! ")
    private LocalDate dateOfBirth ;

    private LocalDate CreatedOn;
    private Boolean Status;
    private Role role;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Address> address;

    @ManyToMany(mappedBy = "user")
    private Set<Orders> orders;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank(message = " Name is Mandatory ! ") @Size(min = 2, max = 30, message = " Name must be between 2 and 30 characters ! ") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = " Name is Mandatory ! ") @Size(min = 2, max = 30, message = " Name must be between 2 and 30 characters ! ") String name) {
        this.name = name;
    }

    public @NotBlank(message = " Email is Mandatory ! ") @Email(message = " Not Valid ! ") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = " Email is Mandatory ! ") @Email(message = " Not Valid ! ") String email) {
        this.email = email;
    }

    public @NotNull(message = " password is Mandatory ! ") @Pattern(regexp = "^\\d{10}$", message = " Number is Not valid ! ") String getNumber() {
        return number;
    }

    public void setNumber(@NotNull(message = " password is Mandatory ! ") @Pattern(regexp = "^\\d{10}$", message = " Number is Not valid ! ") String number) {
        this.number = number;
    }

    public @NotBlank(message = " password is Mandatory ! ") @Size(min = 8, message = " Too weak ! ") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = " password is Mandatory ! ") @Size(min = 8, message = " Too weak ! ") String password) {
        this.password = password;
    }

    public @NotNull(message = " DateOfBirth is Mandatory ! ") @Past(message = " Date of Birth must be a past date ! ") LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull(message = " DateOfBirth is Mandatory ! ") @Past(message = " Date of Birth must be a past date ! ") LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

}

