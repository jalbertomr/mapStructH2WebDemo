package com.bext.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private Long idDto;
    private String firstNameDto;
    private String lastNameDto;
    private Integer ageDto;
}
