package com.arinc.veterinaryApp.service;

import com.arinc.veterinaryApp.dto.AnimalHistoryDto;
import com.arinc.veterinaryApp.entity.AnimalHistory;
import com.arinc.veterinaryApp.util.TPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AnimalHistoryService {

    AnimalHistoryDto save(AnimalHistoryDto animalHistory);

    AnimalHistoryDto getById(Long id);

    TPage<AnimalHistoryDto> getAllPageable(Pageable pageable);

    Boolean delete(AnimalHistoryDto animalHistory);

    List<AnimalHistoryDto> getByAnimalId(Long id);


}
