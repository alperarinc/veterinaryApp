package com.arinc.vetenaryApp.service;

import com.arinc.vetenaryApp.dto.AnimalDto;
import com.arinc.vetenaryApp.entity.Animal;
import com.arinc.vetenaryApp.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnimalService {

    AnimalDto save(AnimalDto animal);

    AnimalDto getById(Long id);

    TPage<AnimalDto> getAllPageable(Pageable pageable);

    Boolean delete(AnimalDto animal);

}
