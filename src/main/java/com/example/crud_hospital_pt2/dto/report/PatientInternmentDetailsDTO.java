package com.example.crud_hospital_pt2.dto.report;

import com.example.crud_hospital_pt2.model.enums.Specialty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientInternmentDetailsDTO {
    private String patientName;
    private Specialty specialty;
    private LocalDateTime admissionDate;
    private Integer duration;

    public PatientInternmentDetailsDTO(String patientName, Specialty specialty, LocalDateTime admissionDate) {
        this.patientName = patientName;
        this.specialty = specialty;
        this.admissionDate = admissionDate;
    }
}
