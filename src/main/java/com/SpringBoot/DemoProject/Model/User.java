package com.SpringBoot.DemoProject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = " Name is Mandatory ! ")
    @Size(min = 2,max = 30,message = " Name must be between 2 and 30 characters ! ")
    private String name;

    @NotBlank(message = " Email is Mandatory ! ")
    @Email(message = " Not Valid Email ! ")
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of( new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

}

