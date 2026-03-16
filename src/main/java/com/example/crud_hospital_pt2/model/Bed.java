package com.example.crud_hospital_pt2.model;


import com.example.crud_hospital_pt2.model.enums.BedStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private BedStatus status;

    private Integer bedNumber;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    @JsonBackReference
    private Room room;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Bed(BedStatus status, Integer bedNumber, Room room) {
        this.status = status;
        this.bedNumber = bedNumber;
        this.room = room;
    }

    public Bed() {

    }
}
