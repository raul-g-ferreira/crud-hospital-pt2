package com.example.crud_hospital_pt2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WardDTO {

    private String specialty;

    private Integer roomQuantity = 0;
    private Integer bedsPerRoom = 0;

    public WardDTO(String specialty) {
        this.specialty = specialty;
    }

}
