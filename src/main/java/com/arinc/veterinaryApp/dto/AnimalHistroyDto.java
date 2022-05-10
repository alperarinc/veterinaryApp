package com.arinc.veterinaryApp.dto;

import com.arinc.veterinaryApp.entity.GenderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalHistroyDto {
    private Long id;
    private String type;
    private GenderStatus gender;
    private String name;
    private int age;
    private String description;
    private UserDto assignee;
    private CustomerDto customer;
}
