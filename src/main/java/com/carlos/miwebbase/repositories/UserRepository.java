package com.carlos.miwebbase.repositories;

import com.carlos.miwebbase.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsernameAndPasswordHash(String username, String hashedPassword);

}