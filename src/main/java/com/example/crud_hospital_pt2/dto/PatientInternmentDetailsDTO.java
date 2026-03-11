package com.example.crud_hospital_pt2.dto;

import com.example.crud_hospital_pt2.model.Specialty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientInternmentDetailsDTO {
    private String hospitalName;
    private Specialty specialty;
    private String roomCode;
    private String patientName;
    private LocalDateTime internmentDate;

    public PatientInternmentDetailsDTO(String hospitalName, Specialty specialty, String roomCode, String patientName) {
        this.hospitalName = hospitalName;
        this.specialty = specialty;
        this.roomCode = roomCode;
        this.patientName = patientName;
    }
}
