package org.bedu.hotel.dto.guest;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class CreateGuestDTO {

    @NotBlank(message = "El nombre debe ser obligatorio")
    private String name;

    @Min(value = 0, message = "La edad debe ser mayor a {value}")
    @Max(value = 120, message = "La edad debe ser menor a {value}")
    private int age;

    @Length(min = 8, max = 12, message = "La longitud del número teléfonico debe estar entre {min} y {max}")
    private String phoneNumber;

    private String address;
}
