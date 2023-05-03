package com.virtusa.visaprocessingsystem.services;

import com.virtusa.visaprocessingsystem.dto.VisaDetailsDto;

import java.util.List;

public interface VisaDetailsService {
    VisaDetailsDto saveVisaDetails(VisaDetailsDto visaDetailsDto);

    VisaDetailsDto getVisaDetailsById(Long visaId);

    VisaDetailsDto updateVisaDetails(Long visaId, VisaDetailsDto visaDetailsDto);
    String deleteVisaById(Long visaId);

    List<VisaDetailsDto> getAllVisaDetails();

    VisaDetailsDto approveVisaDetails(Long visaId, String status, VisaDetailsDto visaDetailsDto);
    VisaDetailsDto rejectVisaDetails(Long visaId, String status, VisaDetailsDto visaDetailsDto);
}
