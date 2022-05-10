package com.arinc.veterinaryApp.service;


import com.arinc.veterinaryApp.dto.UserDto;
import com.arinc.veterinaryApp.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User save(User user);

    User getById(Long id);

    Page<User> getAllPageable(Pageable pageable);

    User getByUsername(String username);

    Boolean delete (Long id);

    UserDto update(Long id, UserDto user);



}
