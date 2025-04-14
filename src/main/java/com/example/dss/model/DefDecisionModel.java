package com.example.dss.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "defdecision")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefDecisionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description", nullable = false)
    private String description;

}
