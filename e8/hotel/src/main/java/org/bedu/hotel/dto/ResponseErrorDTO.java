package org.bedu.hotel.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseErrorDTO {
    private boolean error;
    private String message;
    private List<String> errors;
}
