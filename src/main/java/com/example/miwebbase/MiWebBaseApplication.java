package com.example.miwebbase;

import com.example.miwebbase.Entities.User;
import com.example.miwebbase.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication public class MiWebBaseApplication {


    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(MiWebBaseApplication.class, args);

    }


    @PostConstruct
    public void init() {
        User activado = new User("test", "$2a$10$J.EQEoXXCmUbl1QKbPCxwu5Q4uBlTExA9asr5xh/LfayOxXkBjnMm");
        userRepository.save(activado);

        User desactivado = new User("test2", "$2a$10$J.EQEoXXCmUbl1QKbPCxwu5Q4uBlTExA9asr5xh/LfayOxXkBjnMm");
        desactivado.setEnabled(false);
        userRepository.save(desactivado);
    }

}
