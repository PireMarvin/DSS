package com.example.dss.model.temp;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "temporary_decision")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DecisionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    @Column(name = "image", nullable = false)
    private byte[] image;

    @Column(name = "description", nullable = false)
    private String description;

//    @Column(name = "user_id", nullable = false)
//    private int userId;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private UsersModel users;
}
