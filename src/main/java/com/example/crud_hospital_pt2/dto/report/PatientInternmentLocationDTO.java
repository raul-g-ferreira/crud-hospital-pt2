package com.example.crud_hospital_pt2.dto.report;

import com.example.crud_hospital_pt2.model.enums.Specialty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientInternmentLocationDTO {
    private String hospitalName;
    private Specialty specialty;
    private String roomCode;
    private String patientName;
    private LocalDateTime internmentDate;

    public PatientInternmentLocationDTO(String hospitalName, Specialty specialty, String roomCode, String patientName) {
        this.hospitalName = hospitalName;
        this.specialty = specialty;
        this.roomCode = roomCode;
        this.patientName = patientName;
    }
}
