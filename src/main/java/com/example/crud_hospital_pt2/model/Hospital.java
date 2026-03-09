package com.example.crud_hospital_pt2.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String cnpj;


    @OneToMany
    private ArrayList<Ward> wards;

    public Hospital(String name, String phone, String cnpj) {
        this.name = name;
        this.phone = phone;
        this.cnpj = cnpj;
    }

    public Hospital() {

    }
}
