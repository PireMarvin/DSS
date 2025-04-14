package com.example.dss.dto.generic;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {
    private int id;
    private String name;
    private String password;
    private String role;
}
