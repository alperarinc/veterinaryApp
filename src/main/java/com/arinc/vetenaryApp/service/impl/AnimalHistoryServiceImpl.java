package com.arinc.vetenaryApp.service.impl;

import com.arinc.vetenaryApp.entity.AnimalHistory;
import com.arinc.vetenaryApp.repository.AnimalHistoryRepository;
import com.arinc.vetenaryApp.service.AnimalHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AnimalHistoryServiceImpl implements AnimalHistoryService {

    private final AnimalHistoryRepository animalHistoryRepository;


    public AnimalHistoryServiceImpl(AnimalHistoryRepository animalHistoryRepository) {
        this.animalHistoryRepository = animalHistoryRepository;
    }


    @Override
    public AnimalHistory save(AnimalHistory animalHistory) {
        if (animalHistory.getDate() == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        animalHistory = animalHistoryRepository.save(animalHistory);
        return animalHistory;
    }

    @Override
    public AnimalHistory getById(Long id) {
        return animalHistoryRepository.getOne(id);
    }

    @Override
    public Page<AnimalHistory> getAllPageable(Pageable pageable) {
        return animalHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(AnimalHistory animalHistory) {
        animalHistoryRepository.delete(animalHistory);
        return Boolean.TRUE;
    }
}
