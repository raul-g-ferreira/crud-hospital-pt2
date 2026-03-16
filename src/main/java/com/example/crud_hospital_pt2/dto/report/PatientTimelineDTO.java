package com.example.crud_hospital_pt2.dto.report;

import com.example.crud_hospital_pt2.model.enums.Specialty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientTimelineDTO {
    private String patientName;
    private Specialty specialty;
    private LocalDateTime admissionDate;
    private LocalDateTime dischargeDate;
}
