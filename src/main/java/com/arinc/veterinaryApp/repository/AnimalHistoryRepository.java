package com.arinc.veterinaryApp.repository;

import com.arinc.veterinaryApp.dto.AnimalHistoryDto;
import com.arinc.veterinaryApp.entity.AnimalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalHistoryRepository extends JpaRepository<AnimalHistory,Long> {
    List<AnimalHistoryDto> getByAnimalId(Long id);
}
