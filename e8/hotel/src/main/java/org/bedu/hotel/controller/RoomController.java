package org.bedu.hotel.controller;

import org.bedu.hotel.dto.RoomDTO;
import org.bedu.hotel.dto.room.CreateRoomDTO;
import org.bedu.hotel.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("rooms")
public class RoomController {

    private IRoomService service;

    @Autowired
    public RoomController(IRoomService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<RoomDTO> findById(@PathVariable("id") long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoomDTO save(@Valid @RequestBody CreateRoomDTO data) {
        return service.save(data);
    }
}
