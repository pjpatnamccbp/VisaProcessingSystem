package com.virtusa.visaprocessingsystem.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private Long mobile;
    @Column(nullable = false)
    private Long passport;
    private Date dob;
    private Date dateOfIssue;
    private Date validUpTo;

    @Column(nullable = false)
    private String password;
}
