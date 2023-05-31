package org.bedu.lombokdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.bedu.lombokdemo.dto.UserDTO;
import org.bedu.lombokdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("users")
public class UserController {

    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public void getAll() {
        //TODO
        /* Patron builder
        User.builder()
                .username("Angel")
                .activated(true)
                .build();
          En lugar de User u = new User("Angel",true);
         */
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@RequestBody UserDTO user) {
        log.warn(user.toString());
        return userService.create(user);
    }
}
