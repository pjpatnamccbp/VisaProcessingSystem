package com.virtusa.visaprocessingsystem.mapper;

import com.virtusa.visaprocessingsystem.dto.UserRegistrationDto;
import com.virtusa.visaprocessingsystem.entities.UserRegistration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
    UserRegistrationDto mapToDto(UserRegistration userRegistration);
    UserRegistration mapToEntity(UserRegistrationDto userRegistrationDto);
}
