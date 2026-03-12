package com.example.crud_hospital_pt2.infra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestExceptionResponse {
    private HttpStatus httpStatus;
    private String message;
}
