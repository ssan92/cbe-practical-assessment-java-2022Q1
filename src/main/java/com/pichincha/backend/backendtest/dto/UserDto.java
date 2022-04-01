package com.pichincha.backend.backendtest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Data
public class UserDto {
    private Long id;
    private String username;
    private LocalDate createdDate;
}
