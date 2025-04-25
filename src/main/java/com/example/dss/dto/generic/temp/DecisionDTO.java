package com.example.dss.dto.generic.temp;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DecisionDTO {
    private int id;
    private byte[] image;
    private String description;
    private Long userId;
}
