package com.example.dss.dto.post.temp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import jakarta.validation.constraints.NotNull;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DecisionCreateDTO {
    @NotNull(message = "Image name cannot be empty")
    @NotBlank(message = "Image name cannot be empty")
    @Size(max = 255, message = "Image name is too long")
    private String image;

    @NotNull(message = "Description cannot be empty")
    @NotBlank(message = "Description cannot be empty")
    @Size(max = 255, message = "Description is too long")
    private String description;

    //private int userId;
}

