package com.shivaji.springbootsecurityjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder bcryptEncoder;

    private final String ROLE_PREFIX = "ROLE_";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // hard coding the users. All passwords must be encoded.
        final List<User> users = Arrays.asList(
                new User("shiva", bcryptEncoder.encode("deotale"),
                        Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))),
                new User("shivaji", bcryptEncoder.encode("deotale"),
                        Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")))
        );

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        // If user not found. Throw this exception.
        throw new UsernameNotFoundException("Username: " + username + " not found");

    }
}