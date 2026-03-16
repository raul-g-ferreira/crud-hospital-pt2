package com.example.crud_hospital_pt2.dto.report;

import com.example.crud_hospital_pt2.model.enums.BedStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllBedsReportDTO {
    private Long bedId;
    private String roomCode;
    private Integer bedNumber;
    private BedStatus status;
}
