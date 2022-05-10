package com.arinc.veterinaryApp.service;

import com.arinc.veterinaryApp.dto.AnimalDto;
import com.arinc.veterinaryApp.dto.CustomerDto;
import com.arinc.veterinaryApp.entity.Animal;
import com.arinc.veterinaryApp.util.TPage;
import org.springframework.data.domain.Pageable;

public interface AnimalService {

    AnimalDto save(AnimalDto animal);

    AnimalDto getById(Long id);

    TPage<AnimalDto> getAllPageable(Pageable pageable);

    Boolean delete(Long id);

    AnimalDto update(Long id, AnimalDto animal);

}
