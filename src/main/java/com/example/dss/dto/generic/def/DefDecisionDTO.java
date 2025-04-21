package com.example.dss.dto.generic.def;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefDecisionDTO {
    private int id;
    private String image;
    private String description;

}
