package com.shivaji.springbootsecurityjwt.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_ADMIN(Names.ROLE_ADMIN),
    ROLE_USER(Names.ROLE_USER);

    private String role;

    private Role(String role) {
        this.role = role;
    }

    public String getAuthority() {
        return this.role;
    }

    public class Names {
        public static final String ROLE_ADMIN = "ROLE_ADMIN";
        public static final String ROLE_USER = "ROLE_USER";
    }
}
