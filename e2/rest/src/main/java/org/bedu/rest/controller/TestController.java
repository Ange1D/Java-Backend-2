package org.bedu.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test") // Todas las rutas tienen el prefijo "/test"
public class TestController {

    //@GetMapping("/test")
    //@GetMapping("helloworld") // /test/helloworld
    @GetMapping // /test

    @ResponseStatus(HttpStatus.OK)
    public String helloWorld() {
        return "Hello World";
    }

    @PostMapping("helloworld") // /test/helloworld
    @ResponseStatus(HttpStatus.OK)
    public String helloWorldPost() {
        return "Hello World (POST)";
    }

}
