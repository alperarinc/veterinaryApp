package com.arinc.veterinaryApp.api;



import com.arinc.veterinaryApp.dto.AnimalDto;
import com.arinc.veterinaryApp.service.impl.AnimalServiceImpl;
import com.arinc.veterinaryApp.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.AnimalCtrl.CTRL)
@Api(value = ApiPaths.AnimalCtrl.CTRL, description = "Animals APIs")
public class AnimalController {

    private final AnimalServiceImpl animalServiceImpl;


    public AnimalController(AnimalServiceImpl animalServiceImpl) {
        this.animalServiceImpl = animalServiceImpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By ID Operation",response = AnimalDto.class)
    public ResponseEntity<AnimalDto> getById(@PathVariable (value = "id",required = true)Long id) {
        AnimalDto customerDto = animalServiceImpl.getById(id);
        return ResponseEntity.ok(customerDto);

        //insert into customer(id,customer_name,customer_code) values (60,'deneme','test01')

    }

    @PostMapping
    @ApiOperation(value = "Create Operation",response = AnimalDto.class)
    public ResponseEntity<AnimalDto> createAnimal(@Valid @RequestBody AnimalDto animal) {
            return ResponseEntity.ok(animalServiceImpl.save(animal));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation",response = AnimalDto.class)
    public ResponseEntity<AnimalDto> updateAnimal(@PathVariable(value = "id",required = true)Long id, @Valid @RequestBody AnimalDto animal){
        return ResponseEntity.ok(animalServiceImpl.update(id, animal));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation",response = AnimalDto.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(animalServiceImpl.delete(id));
    }

}
