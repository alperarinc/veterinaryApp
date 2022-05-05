package com.arinc.veterinaryApp.service;

import com.arinc.veterinaryApp.entity.AnimalHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnimalHistoryService {

    AnimalHistory save(AnimalHistory animalHistory);

    AnimalHistory getById(Long id);

    Page<AnimalHistory> getAllPageable(Pageable pageable);

    Boolean delete(AnimalHistory animalHistory);

}
