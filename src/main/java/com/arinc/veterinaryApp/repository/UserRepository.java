package com.arinc.veterinaryApp.repository;

import com.arinc.veterinaryApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
