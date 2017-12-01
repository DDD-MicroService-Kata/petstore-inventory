package com.ThoughtWorks.DDD.account.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/users")
public class UserFacade {

    private final UserRepository userRepository;

    @Autowired
    public UserFacade(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public final String demo(){
        return "";
    }

    @PostMapping
    public final ResponseEntity createUser(@RequestBody final User user){
        User userAfterSaved = userRepository.save(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(String.format("/api/users/%d", userAfterSaved.getId())));
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public final @ResponseBody User findById(@PathVariable("id") final long id) {
        return userRepository.findOne(id);
    }
}

