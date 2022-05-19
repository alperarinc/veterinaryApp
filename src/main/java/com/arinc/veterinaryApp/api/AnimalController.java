package com.arinc.veterinaryApp.api;


import com.arinc.veterinaryApp.dto.AnimalDetailDto;
import com.arinc.veterinaryApp.dto.AnimalDto;
import com.arinc.veterinaryApp.service.impl.AnimalServiceImpl;
import com.arinc.veterinaryApp.util.ApiPaths;
import com.arinc.veterinaryApp.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(ApiPaths.AnimalCtrl.CTRL)
@Api(value = ApiPaths.AnimalCtrl.CTRL, description = "Animals APIs")
@CrossOrigin
public class AnimalController {

    private final AnimalServiceImpl animalServiceImpl;


    public AnimalController(AnimalServiceImpl animalServiceImpl) {
        this.animalServiceImpl = animalServiceImpl;
    }

    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = AnimalDto.class)
    public ResponseEntity<TPage<AnimalDto>> getAllByPagination(Pageable pageable) {
        TPage<AnimalDto> data = animalServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By ID Operation", response = AnimalDto.class)
    public ResponseEntity<AnimalDto> getById(@PathVariable(value = "id", required = true) Long id) {
        AnimalDto animalDto = animalServiceImpl.getById(id);
        return ResponseEntity.ok(animalDto);
    }

    @GetMapping("/detail/{id}")
    @ApiOperation(value = "Get By ID Operation", response = AnimalDto.class)
    public ResponseEntity<AnimalDetailDto> getByIdWıthDetails(@PathVariable(value = "id", required = true) Long id) {
        AnimalDetailDto detailDto = animalServiceImpl.getByIdWithDetails(id);
        return ResponseEntity.ok(detailDto);
    }


    @PostMapping
    @ApiOperation(value = "Create Operation", response = AnimalDto.class)
    public ResponseEntity<AnimalDto> createAnimal(@Valid @RequestBody AnimalDto animal) {
        return ResponseEntity.ok(animalServiceImpl.save(animal));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = AnimalDto.class)
    public ResponseEntity<AnimalDto> updateAnimal(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody AnimalDto animal) {
        return ResponseEntity.ok(animalServiceImpl.update(id, animal));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = AnimalDto.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(animalServiceImpl.delete(id));
    }


}
