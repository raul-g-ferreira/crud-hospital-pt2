package com.example.crud_hospital_pt2.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "bed_id")
    private Bed bed;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private Event eventType;
}
