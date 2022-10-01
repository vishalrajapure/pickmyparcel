package com.company.pickmyparcel.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends AuditModel {
    @Id
    @Size(min = 10, max = 10)
    private String contactNo;

    @NotBlank(message = "User First Name should not blank")
    private String firstName;

    @NotBlank(message = "User Last Name should not blank")

    private String lastName;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    private UserRole roles;

    //currentlyLoggedIn - Y

    //OTP

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;

}
