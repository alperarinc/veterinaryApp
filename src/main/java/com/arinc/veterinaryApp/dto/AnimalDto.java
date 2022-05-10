package com.arinc.veterinaryApp.dto;

import com.arinc.veterinaryApp.entity.Customer;
import com.arinc.veterinaryApp.entity.GenderStatus;
import com.arinc.veterinaryApp.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Animal Data Of Project")
public class AnimalDto {
    @ApiModelProperty(value = "Animal ID")
    private Long id;
    @NotNull
    @ApiModelProperty(required = true,value = "Type Of Animal")
    private String type;
    @NotNull
    @ApiModelProperty(required = true,value = "Gender Of Animal")
    private GenderStatus gender;
    @NotNull
    @ApiModelProperty(required = true,value = "Name Of Animal")
    private String name;
    @NotNull
    @ApiModelProperty(required = true,value = "Age Of Animal")
    private int age;
    @NotNull
    @ApiModelProperty(required = true,value = "Description Of Animal")
    private String description;
    private UserDto assignee;
    private CustomerDto customer;
}
