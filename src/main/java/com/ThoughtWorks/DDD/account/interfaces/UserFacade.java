package com.ThoughtWorks.DDD.account.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserFacade {

    @GetMapping
    public String createUser(){
        return "";
    }

}