package com.example.dss.dto.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import jakarta.validation.constraints.NotNull;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefDecisionCreateDTO {

    @NotNull(message = "Description cannot be empty")
    @NotBlank(message = "Description cannot be empty")
    @Size(max = 255, message = "Description is too long")
    private String description;

    //private int userId;
}
