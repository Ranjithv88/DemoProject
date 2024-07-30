package com.SpringBoot.DemoProject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressId;

    @NotBlank(message = " Enter the Sno ! ")
    private String sno;

    @NotBlank(message = " Enter the City Name ! ")
    private String city;

    @NotBlank(message = " Enter the State Name ! ")
    private String state;

    @NotNull(message = " Enter the PinCode ! ")
    @Size(min = 6,max = 6,message = " Wrong PinCode ")
    private int pinCode;

    private AddressType addresstype;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public @NotBlank(message = " Enter the Sno ! ") String getSno() {
        return sno;
    }

    public void setSno(@NotBlank(message = " Enter the Sno ! ") String sno) {
        this.sno = sno;
    }

    public @NotBlank(message = " Enter the City Name ! ") String getCity() {
        return city;
    }

    public void setCity(@NotBlank(message = " Enter the City Name ! ") String city) {
        this.city = city;
    }

    public @NotBlank(message = " Enter the State Name ! ") String getState() {
        return state;
    }

    public void setState(@NotBlank(message = " Enter the State Name ! ") String state) {
        this.state = state;
    }

    @NotNull(message = " Enter the PinCode ! ")
    @Size(min = 6, max = 6, message = " Wrong PinCode ")
    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(@NotNull(message = " Enter the PinCode ! ") @Size(min = 6, max = 6, message = " Wrong PinCode ") int pinCode) {
        this.pinCode = pinCode;
    }

    public AddressType getAddresstype() {
        return addresstype;
    }

    public void setAddresstype(AddressType addresstype) {
        this.addresstype = addresstype;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

