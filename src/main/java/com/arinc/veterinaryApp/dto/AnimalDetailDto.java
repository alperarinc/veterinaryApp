package com.arinc.veterinaryApp.dto;

import com.arinc.veterinaryApp.entity.GenderStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Animal Detail Data Of Customer")
public class AnimalDetailDto {
    @ApiModelProperty(value = "Animal ID")
    private Long id;
    @NotNull
    @ApiModelProperty(required = true,value = "Type")
    private String type;
    @NotNull
    @ApiModelProperty(required = true,value = "Gender")
    private GenderStatus gender;
    @NotNull
    @ApiModelProperty(required = true,value = "Name")
    private String name;
    @NotNull
    @ApiModelProperty(required = true,value = "Surname")
    private String surname;
    @NotNull
    @ApiModelProperty(required = true,value = "Age")
    private int age;
    @NotNull
    @ApiModelProperty(required = true,value = "Description")
    private String description;
    @ApiModelProperty(required = true,value = "Assignee")
    private UserDto assignee;
    @ApiModelProperty(required = true,value = "Customer")
    private CustomerDto customer;
    @ApiModelProperty(required = true,value = "Animal Histories")
    private List<AnimalHistoryDto> animalHistories;


}
