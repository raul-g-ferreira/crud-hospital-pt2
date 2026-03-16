package com.example.crud_hospital_pt2.dto.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BedTimelineDTO {
    private Integer bedNumber;
    private String patientName;
    private LocalDateTime admissionDate;
    private LocalDateTime dischargeDate;


}
