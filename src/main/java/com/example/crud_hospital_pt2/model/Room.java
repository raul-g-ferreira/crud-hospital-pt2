package com.example.crud_hospital_pt2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ward_id", nullable = false)
    @JsonBackReference
    private Ward ward;

    private Boolean isFull;
    private String roomCode;

    @OneToMany(mappedBy = "room", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JsonManagedReference
    private List<Bed> beds;

    public Room(Ward ward, Boolean isFull, String roomCode) {
        this.ward = ward;
        this.isFull = isFull;
        this.roomCode = roomCode;
    }

    public Room() {

    }
}
