package com.arinc.veterinaryApp.service.impl;

import com.arinc.veterinaryApp.entity.User;
import com.arinc.veterinaryApp.repository.UserRepository;
import com.arinc.veterinaryApp.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {

        if (user.getEmail() == null) {
            throw new IllegalArgumentException("Email cannot bu null");
        }
        user = userRepository.save(user);

        return null;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
