package com.example.crud_hospital_pt2.dto.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HospitalOverviewDTO {
    private String hospitalName;
    private Integer totalOccupiedBeds;
    private Integer totalInPreparationBeds;
    private Integer totalUnoccupiedBeds;

    public HospitalOverviewDTO(String hospitalName, Integer totalOccupiedBeds, Integer totalInPreparationBeds, Integer totalUnoccupiedBeds) {
        this.hospitalName = hospitalName;
        this.totalOccupiedBeds = totalOccupiedBeds;
        this.totalInPreparationBeds = totalInPreparationBeds;
        this.totalUnoccupiedBeds = totalUnoccupiedBeds;
    }

    private List<WardOverviewDTO> wardOverviewDTOS;
}
