package com.example.crud_hospital_pt2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    @JsonBackReference
    private Hospital hospital;

    @OneToMany(mappedBy = "ward", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JsonManagedReference
    private List<Room> rooms;

    public Ward(Specialty specialty, Hospital hospital) {
        this.specialty = specialty;
        this.hospital = hospital;
    }

}
