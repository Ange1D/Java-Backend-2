package org.bedu.lombokdemo.model;

import lombok.*;

//@Data // Getter, Setter, ToString, Equals, AllArgsConstructor
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode(of = { "username" })
@RequiredArgsConstructor // Constructor con los atributos NonNull o final
@NoArgsConstructor
@AllArgsConstructor
@Builder // implementa el patron de creacion "builder"
public class User {
    @NonNull
    private String username;
    @NonNull
    private String mail;
    private String password;
    private String address;
    private int age;
    private String activated; // Y, N

}
