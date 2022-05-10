package com.arinc.veterinaryApp.api;


import com.arinc.veterinaryApp.dto.CustomerDto;
import com.arinc.veterinaryApp.service.impl.CustomerServiceImpl;
import com.arinc.veterinaryApp.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.CustomerCtrl.CTRL)
@Api(value = ApiPaths.CustomerCtrl.CTRL,description = "Customer APIs")
public class CustomerController {

    private final CustomerServiceImpl customerServiceImpl;


    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By ID Operation", response = CustomerDto.class)
    public ResponseEntity<CustomerDto> getById(@PathVariable (value = "id",required = true)Long id) {
        CustomerDto customerDto = customerServiceImpl.getById(id);
        return ResponseEntity.ok(customerDto);

        //insert into customer(id,customer_name,customer_code) values (60,'deneme','test01')

    }

    @PostMapping
    @ApiOperation(value = "Create Operation",response = CustomerDto.class)
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customer) {
            return ResponseEntity.ok(customerServiceImpl.save(customer));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation",response = CustomerDto.class)
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable(value = "id",required = true)Long id, @Valid @RequestBody CustomerDto customer){
        return ResponseEntity.ok(customerServiceImpl.update(id, customer));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation",response = CustomerDto.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(customerServiceImpl.delete(id));
    }

}
