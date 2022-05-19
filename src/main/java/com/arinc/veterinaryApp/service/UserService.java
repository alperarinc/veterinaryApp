package com.arinc.veterinaryApp.service;


import com.arinc.veterinaryApp.dto.UserDto;
import com.arinc.veterinaryApp.entity.User;
import com.arinc.veterinaryApp.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto save(UserDto user);

    UserDto getById(Long id);

    TPage<UserDto> getAllPageable(Pageable pageable);

    UserDto getByUsername(String username);
}
