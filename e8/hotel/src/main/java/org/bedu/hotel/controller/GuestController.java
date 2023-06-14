package org.bedu.hotel.controller;

import org.bedu.hotel.dto.GuestDTO;
import org.bedu.hotel.dto.guest.CreateGuestDTO;
import org.bedu.hotel.dto.guest.UpdateGuestDTO;
import org.bedu.hotel.service.IGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("guests")
public class GuestController {

    private IGuestService service;

    @Autowired
    public GuestController(IGuestService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GuestDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<GuestDTO> findById(@PathVariable("id") long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GuestDTO save(@Valid @RequestBody CreateGuestDTO data) {
        return service.save(data);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody UpdateGuestDTO data, @PathVariable("id") long id) {
        service.update(id, data);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) {
        service.delete(id);
    }
}
