package com.arinc.veterinaryApp.dto;

import com.arinc.veterinaryApp.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @ApiModelProperty(required = true,value = "Code Of Customer")
    private String customerCode;
    @ApiModelProperty(required = true,value = "Surname Of Customer")
    private String customerSurname;
    @ApiModelProperty(required = true,value = "Phone Of Customer")
    private String telNumber;
    @ApiModelProperty(required = true,value = "Address Of Customer")
    private String address;
    @ApiModelProperty(required = true,value = "Email Of Customer")
    private String email;
    @ApiModelProperty(required = true,value = "Customer Manager Id")
    private Long managerId;
    @ApiModelProperty(required = true,value = "Customer Manager Name")
    private UserDto manager;
}
