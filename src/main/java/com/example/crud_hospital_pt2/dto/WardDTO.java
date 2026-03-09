package com.example.crud_hospital_pt2.dto;

import lombok.Data;

@Data
public class WardDTO {

    private String specialty;

    private Integer roomQuantity;
    private Integer bedsPerRoom;

    public WardDTO(String specialty, Integer roomQuantity, Integer bedsPerRoom) {
        this.specialty = specialty;
        this.roomQuantity = roomQuantity;
        this.bedsPerRoom = bedsPerRoom;
    }
}
