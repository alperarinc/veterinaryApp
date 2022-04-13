package com.arinc.vetenaryApp.service.impl;

import com.arinc.vetenaryApp.dto.AnimalDto;
import com.arinc.vetenaryApp.entity.Animal;
import com.arinc.vetenaryApp.repository.AnimalRepository;
import com.arinc.vetenaryApp.service.AnimalService;
import com.arinc.vetenaryApp.util.TPage;
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
        if (animal.getName() == null) throw new IllegalArgumentException("Animal name cannot be null");
        Animal animaldb = modelMapper.map(animal, Animal.class);
        animaldb = animalRepository.save(animaldb);
        return modelMapper.map(animaldb, AnimalDto.class);
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
    public Boolean delete(AnimalDto animal) {
        return null;
    }
}
