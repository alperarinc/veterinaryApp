package com.arinc.vetenaryApp.repository;

import com.arinc.vetenaryApp.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal,Long> {
}
