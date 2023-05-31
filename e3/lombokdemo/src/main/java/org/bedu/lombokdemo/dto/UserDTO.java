package org.bedu.lombokdemo.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String email;
    private String pass;
    private String address;
    private int age;
    private boolean activated; // Y, N
}
