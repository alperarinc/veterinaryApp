package com.arinc.veterinaryApp.dto;

import com.arinc.veterinaryApp.entity.GenderStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Animal History Data Of Customer")
public class AnimalHistoryDto {
    @ApiModelProperty(value = "Animal History ID")
    private Long id;
    @ApiModelProperty(required = true,value = "Type Of Animal")
    private String type;
    @ApiModelProperty(required = true,value = "Gender Of Animal")
    private GenderStatus gender;
    @ApiModelProperty(required = true,value = "Name Of Animal")
    private String name;
    @ApiModelProperty(required = true,value = "Age Of Animal")
    private int age;
    @ApiModelProperty(required = true,value = "Description Of Animal")
    private String description;
    @ApiModelProperty(required = true,value = "Assignee Of Animal")
    private UserDto assignee;//atanan kişiyi tutar
    @ApiModelProperty(required = true,value = "Customer Of Animal")
    private CustomerDto customer;

}
