package org.bedu.hotel.dto.room;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateRoomDTO {

    @NotBlank
    private String number;
}
