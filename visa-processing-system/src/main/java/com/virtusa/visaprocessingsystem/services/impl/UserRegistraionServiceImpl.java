package com.virtusa.visaprocessingsystem.services.impl;

import com.virtusa.visaprocessingsystem.dto.UserRegistrationDto;
import com.virtusa.visaprocessingsystem.entities.UserRegistration;
import com.virtusa.visaprocessingsystem.exceptions.ResourceNotFound;
import com.virtusa.visaprocessingsystem.mapper.AutoUserMapper;
import com.virtusa.visaprocessingsystem.repositories.UserRegistraionRepository;
import com.virtusa.visaprocessingsystem.services.UserRegistraionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserRegistraionServiceImpl implements UserRegistraionService {

    private UserRegistraionRepository userRegistraionRepository;

    @Override
    public UserRegistrationDto saveUser(UserRegistrationDto userRegistrationDto) {
        UserRegistration user = AutoUserMapper.MAPPER.mapToEntity(userRegistrationDto);
        UserRegistration savedUser = userRegistraionRepository.save(user);
        return AutoUserMapper.MAPPER.mapToDto(savedUser);
    }

    @Override
    public UserRegistrationDto updateUser(Long userId,UserRegistrationDto userRegistrationDto) {
        UserRegistration userRegistration = userRegistraionRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFound(String.format("User with id %d Not FOUND",userId))
        );
        userRegistration.setUserName(userRegistrationDto.getUserName());
        userRegistration.setFirstName(userRegistrationDto.getFirstName());
        userRegistration.setUserName(userRegistrationDto.getLastName());
        userRegistration.setDob(userRegistrationDto.getDob());
        userRegistration.setCountry(userRegistrationDto.getCountry());
        userRegistration.setAddress(userRegistrationDto.getAddress());
        userRegistration.setEmail(userRegistrationDto.getEmail());
        userRegistration.setGender(userRegistrationDto.getGender());
        userRegistration.setMobile(userRegistrationDto.getMobile());
        userRegistration.setPassport(userRegistrationDto.getPassport());
        userRegistration.setDateOfIssue(userRegistrationDto.getDateOfIssue());
        userRegistration.setValidUpTo(userRegistrationDto.getValidUpTo());

        UserRegistration updatedUserRegistration = userRegistraionRepository.save(userRegistration);
        return AutoUserMapper.MAPPER.mapToDto(updatedUserRegistration);
    }

    @Override
    public UserRegistrationDto getUserById(Long userId) {
        UserRegistration userRegistration = userRegistraionRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFound(String.format("User with id %d Not FOUND",userId))
        );
        return AutoUserMapper.MAPPER.mapToDto(userRegistration);
    }

    @Override
    public String deleteUserById(Long userId) {
        userRegistraionRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFound(String.format("User with id %d Not FOUND",userId))
        );
        return String.format("User with id %d removed from db!!!!");
    }

    @Override
    public List<UserRegistrationDto> getAllUsers() {
        return userRegistraionRepository.findAll().stream().map(AutoUserMapper.MAPPER::mapToDto)
                .collect(Collectors.toList());
    }

}
