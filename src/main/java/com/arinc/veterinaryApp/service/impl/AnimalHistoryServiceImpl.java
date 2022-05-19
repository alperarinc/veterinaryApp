package com.arinc.veterinaryApp.service.impl;

import com.arinc.veterinaryApp.dto.AnimalDetailDto;
import com.arinc.veterinaryApp.dto.AnimalHistoryDto;
import com.arinc.veterinaryApp.entity.AnimalHistory;
import com.arinc.veterinaryApp.repository.AnimalHistoryRepository;
import com.arinc.veterinaryApp.service.AnimalHistoryService;
import com.arinc.veterinaryApp.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AnimalHistoryServiceImpl implements AnimalHistoryService {

    private final AnimalHistoryRepository animalHistoryRepository;
    private final ModelMapper modelMapper;


    public AnimalHistoryServiceImpl(AnimalHistoryRepository animalHistoryRepository, ModelMapper modelMapper) {
        this.animalHistoryRepository = animalHistoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AnimalHistoryDto save(AnimalHistoryDto animalHistory) {
        AnimalHistory animalHistoryDb = modelMapper.map(animalHistory, AnimalHistory.class);
        animalHistoryDb = animalHistoryRepository.save(animalHistoryDb);
        animalHistory.setId(animalHistoryDb.getId());
        return animalHistory;
    }

    @Override
    public AnimalHistoryDto getById(Long id) {
        AnimalHistory animalHistory = animalHistoryRepository.getOne(id);
        return modelMapper.map(animalHistory, AnimalHistoryDto.class);
    }

    @Override
    public TPage<AnimalHistoryDto> getAllPageable(Pageable pageable) {
        Page<AnimalHistory> data = animalHistoryRepository.findAll(pageable);
        TPage<AnimalHistoryDto> respnose = new TPage<AnimalHistoryDto>();
        respnose.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), AnimalHistoryDto[].class)));
        return respnose;
    }

    @Override
    public Boolean delete(AnimalHistoryDto animalHistory) {
        animalHistoryRepository.deleteById(animalHistory.getId());
        return Boolean.TRUE;
    }

    @Override
    public List<AnimalHistoryDto> getByAnimalId(Long id) {
        return Arrays.asList(modelMapper.map(animalHistoryRepository.getByAnimalId(id), AnimalHistoryDto[].class));
    }
}
