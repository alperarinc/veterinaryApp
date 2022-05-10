package com.arinc.veterinaryApp.service.impl;

import com.arinc.veterinaryApp.dto.AnimalDto;
import com.arinc.veterinaryApp.entity.Animal;
import com.arinc.veterinaryApp.repository.AnimalRepository;
import com.arinc.veterinaryApp.service.AnimalService;
import com.arinc.veterinaryApp.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;
    private final ModelMapper modelMapper;

    public AnimalServiceImpl(AnimalRepository animalRepository, ModelMapper modelMapper) {
        this.animalRepository = animalRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AnimalDto save(AnimalDto animal) {
        if (animal.getName() == null) {throw new IllegalArgumentException("Animal name cannot be null");}

        Animal animalEntity = modelMapper.map(animal, Animal.class);

        animalEntity = animalRepository.save(animalEntity);

        animal.setId(animalEntity.getId());
        return animal;
     }

    @Override
    public AnimalDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<AnimalDto> getAllPageable(Pageable pageable) {
        Page<Animal> data = animalRepository.findAll(pageable);
        TPage page = new TPage<AnimalDto>();
        AnimalDto[] dtos = modelMapper.map(data.getContent(), AnimalDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(Long id) {
        return true;
    }

    @Override
    public AnimalDto update(Long id, AnimalDto animal) {
        return null;
    }
}
