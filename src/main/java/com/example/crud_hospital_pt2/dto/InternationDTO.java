package com.example.crud_hospital_pt2.dto;

import com.example.crud_hospital_pt2.model.Specialty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InternationDTO {
    private String patientName;
    private Specialty specialty;
    private LocalDateTime admissionDate;
    private LocalDateTime dischargeDate;

    public InternationDTO(String patientName, Specialty specialty, LocalDateTime admissionDate) {
        this.patientName = patientName;
        this.specialty = specialty;
        this.admissionDate = admissionDate;
    }
}
