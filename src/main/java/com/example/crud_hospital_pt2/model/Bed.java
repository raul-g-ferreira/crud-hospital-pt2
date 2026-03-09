package com.example.crud_hospital_pt2.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BedStatus status;

    private Integer bedNumber;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;


}
