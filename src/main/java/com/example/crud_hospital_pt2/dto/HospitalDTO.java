package com.example.crud_hospital_pt2.dto;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDTO {

    private String hospitalName;
    private String hospitalPhone;
    private String hospitalCnpj;

    private ArrayList<WardDTO> wardDTOs = new ArrayList<>();


    public HospitalDTO(String hospitalName, String hospitalPhone, String hospitalCnpj) {
        this.hospitalName = hospitalName;
        this.hospitalPhone = hospitalPhone;
        this.hospitalCnpj = hospitalCnpj;
        this.wardDTOs = new ArrayList<>();
    }

}
