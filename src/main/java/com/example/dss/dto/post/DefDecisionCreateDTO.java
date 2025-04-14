package com.example.dss.dto.post;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

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
