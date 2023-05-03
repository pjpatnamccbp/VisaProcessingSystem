package com.virtusa.visaprocessingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class VisaDetailsDto {
    private Long visaId;

    private String toCountry;
    private Date startDate;
    private Date endDate;
    private String visaType;


    private String visaStatus;

    private Date appliedDate;
}
