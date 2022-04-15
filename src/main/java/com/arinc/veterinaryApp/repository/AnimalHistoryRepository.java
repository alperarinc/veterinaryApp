package com.arinc.veterinaryApp.repository;

import com.arinc.veterinaryApp.entity.AnimalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalHistoryRepository extends JpaRepository<AnimalHistory,Long> {
}
