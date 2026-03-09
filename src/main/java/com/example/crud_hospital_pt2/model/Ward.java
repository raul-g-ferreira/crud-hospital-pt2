package com.example.crud_hospital_pt2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String specialty;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

    @OneToMany
    private ArrayList<Room> rooms;

    public Ward(String specialty, Hospital hospital) {
        this.specialty = specialty;
        this.hospital = hospital;
    }

    public Ward() {

    }
}
