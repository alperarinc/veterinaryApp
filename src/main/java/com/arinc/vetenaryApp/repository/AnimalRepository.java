package com.arinc.vetenaryApp.repository;

import com.arinc.vetenaryApp.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal,Long> {

}
