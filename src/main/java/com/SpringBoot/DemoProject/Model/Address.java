package com.SpringBoot.DemoProject.Model;

import com.SpringBoot.DemoProject.Model.Enum.AddressType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

}

