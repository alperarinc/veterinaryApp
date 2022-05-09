package com.arinc.veterinaryApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    @NotNull
    private String customerName;
    @NotNull
    private String customerCode;

}
