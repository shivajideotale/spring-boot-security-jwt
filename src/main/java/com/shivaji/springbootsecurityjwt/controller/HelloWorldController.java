package com.shivaji.springbootsecurityjwt.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping("/user")
    public String helloUser() {
        return "Hello User";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/admin")
    public String helloAdmin() {
        return "Hello Admin";
    }

}
