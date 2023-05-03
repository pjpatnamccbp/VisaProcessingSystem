package com.virtusa.visaprocessingsystem.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class UserRegistrationDto {

    private Long userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String country;
    private String address;
    private Long mobile;
    private Long passport;
    private Date dob;
    private Date dateOfIssue;
    private Date validUpTo;

    private String password;
}
