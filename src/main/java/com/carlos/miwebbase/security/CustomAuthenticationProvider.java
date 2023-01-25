package com.carlos.miwebbase.security;

import com.carlos.miwebbase.entities.User;
import com.carlos.miwebbase.repositories.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
@Log4j2
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String enteredUsername = authentication.getName();
        String enteredPassword = authentication.getCredentials().toString();

        Optional<User> optionalUser = userRepository.findByUsernameAndPasswordHash(enteredUsername, DigestUtils.sha256Hex(enteredPassword));

        return optionalUser.map(user -> {
            log.info("User {} authenticated successfully", user.getUsername());
            return new UsernamePasswordAuthenticationToken(
                    user.getUsername(), user.getPasswordHash(), new ArrayList<>());
        }).orElse(null);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}