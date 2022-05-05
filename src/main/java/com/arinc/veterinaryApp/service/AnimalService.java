package com.arinc.veterinaryApp.service;

import com.arinc.veterinaryApp.dto.AnimalDto;
import com.arinc.veterinaryApp.util.TPage;
import org.springframework.data.domain.Pageable;

public interface AnimalService {

    AnimalDto save(AnimalDto animal);

    AnimalDto getById(Long id);

    TPage<AnimalDto> getAllPageable(Pageable pageable);

    Boolean delete(AnimalDto animal);

}
