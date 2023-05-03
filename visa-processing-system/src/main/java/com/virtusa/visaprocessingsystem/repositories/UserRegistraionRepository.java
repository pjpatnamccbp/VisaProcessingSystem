package com.virtusa.visaprocessingsystem.repositories;

import com.virtusa.visaprocessingsystem.entities.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistraionRepository extends JpaRepository<UserRegistration,Long> {
}
