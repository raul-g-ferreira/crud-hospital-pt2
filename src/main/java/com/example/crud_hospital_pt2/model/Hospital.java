package com.example.crud_hospital_pt2.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String cnpj;


    @OneToMany(mappedBy = "hospital", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JsonManagedReference
    private List<Ward> wards;

    public Hospital(String name, String phone, String cnpj) {
        this.name = name;
        this.phone = phone;
        this.cnpj = cnpj;
    }

    public Hospital() {

    }
}
