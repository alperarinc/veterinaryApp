package com.arinc.veterinaryApp.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Customer Data Transfer Object")
public class CustomerDto {
    @ApiModelProperty(value = "Customer ID")
    private Long id;
    @NotNull
    @ApiModelProperty(required = true,value = "Name Of Customer")
    private String customerName;
    @NotNull
    @ApiModelProperty(required = true,value = "Code Of Customer")
    private String customerCode;

}
