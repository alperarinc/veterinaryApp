package com.arinc.veterinaryApp.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "User")
public class UserDto {
    @ApiModelProperty(value = "User ID")
    private Long id;
    @ApiModelProperty(required = true,value = "Name Of User")
    private String name;
    @ApiModelProperty(required = true,value = "Surname Of User")
    private String surname;
    @ApiModelProperty(required = true,value = "Username Of User")
    private String username;
    @ApiModelProperty(required = true,value = "Email Of User")
    private String email;



}
