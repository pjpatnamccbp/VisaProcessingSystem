package com.virtusa.visaprocessingsystem.services.impl;

import com.virtusa.visaprocessingsystem.dto.VisaDetailsDto;
import com.virtusa.visaprocessingsystem.entities.VisaDetails;
import com.virtusa.visaprocessingsystem.exceptions.ResourceNotFound;
import com.virtusa.visaprocessingsystem.mapper.VisaDetailsMapper;
import com.virtusa.visaprocessingsystem.repositories.VisaDetailsRepository;
import com.virtusa.visaprocessingsystem.services.VisaDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VisaDetailsServiceImpl implements VisaDetailsService {

    private VisaDetailsRepository visaDetailsRepository;

    @Override
    public VisaDetailsDto saveVisaDetails(VisaDetailsDto visaDetailsDto) {
        VisaDetails visaDetails = VisaDetailsMapper.MAPPER.mapToEntity(visaDetailsDto);
        VisaDetails savedVisaDetails = visaDetailsRepository.save(visaDetails);
        return VisaDetailsMapper.MAPPER.mapToDto(savedVisaDetails);
    }

    @Override
    public VisaDetailsDto getVisaDetailsById(Long visaId) {
        VisaDetails visaDetails = visaDetailsRepository.findById(visaId).get();
        return VisaDetailsMapper.MAPPER.mapToDto(visaDetails);
    }

    @Override
    public VisaDetailsDto updateVisaDetails(Long visaId, VisaDetailsDto visaDetailsDto) {
        VisaDetails visaDetails = visaDetailsRepository.findById(visaId).orElseThrow(
                () -> new ResourceNotFound(String.format("visa details for id %d not found!!",visaId))
        );

        visaDetails.setVisaStatus(visaDetailsDto.getVisaStatus());
        visaDetails.setVisaType(visaDetailsDto.getVisaType());
        visaDetails.setToCountry(visaDetailsDto.getToCountry());
        VisaDetails updatedVisaDetails = visaDetailsRepository.save(visaDetails);

        return VisaDetailsMapper.MAPPER.mapToDto(updatedVisaDetails);
    }

    @Override
    public String deleteVisaById(Long visaId) {
        visaDetailsRepository.findById(visaId).orElseThrow(
                () -> new ResourceNotFound(String.format("visa details for id %d not found!!",visaId))
        );
        visaDetailsRepository.deleteById(visaId);
        return "visa details deleted successfully from db ";
    }

    @Override
    public List<VisaDetailsDto> getAllVisaDetails() {

        return visaDetailsRepository.findAll()
                .stream().map(VisaDetailsMapper.MAPPER :: mapToDto).collect(Collectors.toList());
    }

    @Override
    public VisaDetailsDto approveVisaDetails(Long visaId, String status, VisaDetailsDto visaDetailsDto) {
        VisaDetails visaDetails = visaDetailsRepository.findById(visaId).orElseThrow(
                () -> new ResourceNotFound(String.format("visa details for id %d not found!!",visaId))
        );

        visaDetails.setVisaStatus(status);

        VisaDetails approvedVisaDetails = visaDetailsRepository.save(visaDetails);
        return VisaDetailsMapper.MAPPER.mapToDto(approvedVisaDetails);
    }
    @Override
    public VisaDetailsDto rejectVisaDetails(Long visaId, String status, VisaDetailsDto visaDetailsDto) {
        VisaDetails visaDetails = visaDetailsRepository.findById(visaId).orElseThrow(
                () -> new ResourceNotFound(String.format("visa details for id %d not found!!",visaId))
        );

        visaDetails.setVisaStatus(status);

        VisaDetails rejectedVisaDetails = visaDetailsRepository.save(visaDetails);
        return VisaDetailsMapper.MAPPER.mapToDto(rejectedVisaDetails);
    }
}
