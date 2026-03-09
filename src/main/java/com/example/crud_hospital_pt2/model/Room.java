package com.example.crud_hospital_pt2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ward_id", nullable = false)
    private Ward ward;

    private Boolean isFull;
    private String roomCode;

    @OneToMany
    private ArrayList<Bed> beds;

    public Room(Ward ward, Boolean isFull, String roomCode) {
        this.ward = ward;
        this.isFull = isFull;
        this.roomCode = roomCode;
    }

    public Room() {

    }
}
