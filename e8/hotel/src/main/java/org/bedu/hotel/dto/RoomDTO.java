package org.bedu.hotel.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoomDTO {

    private long id;
    private String number;
    private List<GuestDTO> guests;
}
