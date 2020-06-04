package com.shivaji.springbootsecurityjwt.controller;

import com.shivaji.springbootsecurityjwt.models.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @Secured({Role.Names.ROLE_ADMIN, Role.Names.ROLE_USER})
    @RequestMapping("/user")
    public String helloUser() {
        return "Hello User";
    }


    @Secured(Role.Names.ROLE_ADMIN)
    @RequestMapping("/admin")
    public String helloAdmin() {
        return "Hello Admin";
    }

}
