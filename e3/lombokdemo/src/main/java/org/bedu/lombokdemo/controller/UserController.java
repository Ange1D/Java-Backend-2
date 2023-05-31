package org.bedu.lombokdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.bedu.lombokdemo.model.User;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("users")
public class UserController {

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
    public void create(@RequestBody User user) {
        //System.out.println(user.toString());
        log.info(user.toString());
    }
}
