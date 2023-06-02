package org.bedu.jpa.controller;

import org.bedu.jpa.dto.AuthorDTO;
import org.bedu.jpa.dto.CreateAuthorDTO;
import org.bedu.jpa.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("authors")
public class AuthorController {

    private IAuthorService service;

    @Autowired
    public AuthorController(IAuthorService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDTO findById() {
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDTO save(@Valid @RequestBody CreateAuthorDTO data) {
        return service.save(data);
    }
}
