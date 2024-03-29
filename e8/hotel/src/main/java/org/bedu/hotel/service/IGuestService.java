package org.bedu.hotel.service;

import org.bedu.hotel.dto.GuestDTO;
import org.bedu.hotel.dto.guest.CreateGuestDTO;
import org.bedu.hotel.dto.guest.UpdateGuestDTO;

import java.util.List;
import java.util.Optional;

public interface IGuestService {

    List<GuestDTO> findAll();

    Optional<GuestDTO> findById(long id);

    GuestDTO save(CreateGuestDTO data);

    void update(long id, UpdateGuestDTO data);

    void delete(long id);
}
