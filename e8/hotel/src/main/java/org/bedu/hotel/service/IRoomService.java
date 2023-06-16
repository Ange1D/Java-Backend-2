package org.bedu.hotel.service;

import org.bedu.hotel.dto.RoomDTO;
import org.bedu.hotel.dto.room.CreateRoomDTO;

import java.util.Optional;

public interface IRoomService {

    Optional<RoomDTO> findById(long id);

    RoomDTO save(CreateRoomDTO data);
}
