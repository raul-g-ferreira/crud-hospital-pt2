package com.example.crud_hospital_pt2.dto;

import com.example.crud_hospital_pt2.model.Specialty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpecialtyAndRoomCodeDTO {
    private Specialty specialty;
    private String roomCode;
}
