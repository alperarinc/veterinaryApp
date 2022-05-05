package com.arinc.veterinaryApp.repository;

import com.arinc.veterinaryApp.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal,Long> {

}
