package com.example.miwebbase;

import com.example.miwebbase.Entities.User;
import com.example.miwebbase.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MiWebBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiWebBaseApplication.class, args);

    }

    @Autowired
    UserRepository userRepository;


    @PostConstruct
    public void init() {

        User activado = User.builder().username("test").hashedPassword("$2a$10$J.EQEoXXCmUbl1QKbPCxwu5Q4uBlTExA9asr5xh/LfayOxXkBjnMm").build();
        userRepository.save(activado);

        User desactivado = User.builder().username("test2").hashedPassword("$2a$10$J.EQEoXXCmUbl1QKbPCxwu5Q4uBlTExA9asr5xh/LfayOxXkBjnMm").enabled(false).build();
        userRepository.save(desactivado);

    }

}
