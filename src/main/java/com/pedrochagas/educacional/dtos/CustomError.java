package com.pedrochagas.educacional.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;
}
