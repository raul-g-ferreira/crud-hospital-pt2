package com.example.crud_hospital_pt2.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public Log(Bed bed, Patient patient, LocalDateTime dateTime, Event eventType) {
        this.bed = bed;
        this.patient = patient;
        this.dateTime = dateTime;
        this.eventType = eventType;
    }
}
