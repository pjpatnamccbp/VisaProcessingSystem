package com.virtusa.visaprocessingsystem.services;

import com.virtusa.visaprocessingsystem.dto.UserRegistrationDto;

import java.util.List;

public interface UserRegistraionService {
    UserRegistrationDto saveUser(UserRegistrationDto userRegistrationDto);
    UserRegistrationDto updateUser(Long userId, UserRegistrationDto userRegistrationDto);
    UserRegistrationDto getUserById(Long userId);
    String deleteUserById(Long userId);

    List<UserRegistrationDto> getAllUsers();
}
