package com.virtusa.visaprocessingsystem.mapper;

import com.virtusa.visaprocessingsystem.dto.VisaDetailsDto;
import com.virtusa.visaprocessingsystem.entities.VisaDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VisaDetailsMapper {

    VisaDetailsMapper MAPPER = Mappers.getMapper(VisaDetailsMapper.class);

    VisaDetailsDto mapToDto(VisaDetails visaDetails);

    VisaDetails mapToEntity(VisaDetailsDto visaDetailsDto);
}
