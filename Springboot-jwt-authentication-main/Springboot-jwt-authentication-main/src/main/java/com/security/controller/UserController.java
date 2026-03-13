package com.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/profile")
    @PreAuthorize("hasRole('USER')")
    public String userProfile() {
        return "User Profile";
    }
}