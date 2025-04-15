package com.example.dss.dto.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersCreateDTO {
    @NotNull(message = "Name cannot be empty")
    @NotBlank(message = "Name cannot be empty")
    @Size(max = 30, message = "Name is too long")
    private String name;

    @NotNull(message = "Password cannot be empty")
    @NotBlank(message = "Password cannot be empty")
    @Size(max = 255, message = "Password is too long")
    private String password;

    @NotNull(message = "Role cannot be empty")
    @NotBlank(message = "Role cannot be empty")
    @Size(max = 255, message = "Role name is too long")
    private String role;
}