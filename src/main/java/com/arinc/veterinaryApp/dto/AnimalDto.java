package com.arinc.veterinaryApp.dto;

import com.arinc.veterinaryApp.entity.Customer;
import com.arinc.veterinaryApp.entity.GenderStatus;
import com.arinc.veterinaryApp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDto {
    private Long id;
    private String type;
    private GenderStatus gender;
    private String name;
    private int age;
    private String description;
    private UserDto assignee;
    private CustomerDto customer;
}
