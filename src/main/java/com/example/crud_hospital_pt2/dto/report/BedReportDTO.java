package com.example.crud_hospital_pt2.dto.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedReportDTO {
    private Long bedId;
    private String roomCode;
    private Integer bedNumber;
}
