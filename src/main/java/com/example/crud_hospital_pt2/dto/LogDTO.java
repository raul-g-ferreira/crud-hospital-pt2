package com.example.crud_hospital_pt2.dto;

import com.example.crud_hospital_pt2.model.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDTO {

    private Long bedId;
    private Long patientId;
    private Event eventType;
}