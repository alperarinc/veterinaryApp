package com.arinc.vetenaryApp.service.impl;

import com.arinc.vetenaryApp.entity.Animal;
import com.arinc.vetenaryApp.entity.User;
import com.arinc.vetenaryApp.repository.UserRepository;
import com.arinc.vetenaryApp.service.UserService;
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
