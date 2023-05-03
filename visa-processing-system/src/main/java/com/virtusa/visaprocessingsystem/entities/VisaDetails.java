package com.virtusa.visaprocessingsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class VisaDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visaId;

    @Column(nullable = false)
    private String toCountry;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private Date endDate;
    @Column(nullable = false)
    private String visaType;

    @Column(nullable = false,columnDefinition = "varchar(20) default 'in_progress'")
    private String visaStatus;

    @CreationTimestamp
    private Date appliedDate;
}
