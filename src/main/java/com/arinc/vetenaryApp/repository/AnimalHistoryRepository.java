package com.arinc.vetenaryApp.repository;

import com.arinc.vetenaryApp.entity.AnimalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalHistoryRepository extends JpaRepository<AnimalHistory,Long> {
}
