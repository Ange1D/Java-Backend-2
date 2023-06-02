package org.bedu.jpa.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateAuthorDTO {

    @NotBlank
    private String name;

}
