package com.arinc.vetenaryApp.dto;

import com.arinc.vetenaryApp.entity.Customer;
import com.arinc.vetenaryApp.entity.GenderStatus;
import com.arinc.vetenaryApp.entity.User;
import lombok.Data;

@Data
public class AnimalDto {
    private Long id;
    private String type;
    private GenderStatus gender;
    private String name;
    private int age;
    private String description;
    private User assignee;
    private Customer customer;
}
