package com.arinc.vetenaryApp.repository;

import com.arinc.vetenaryApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
