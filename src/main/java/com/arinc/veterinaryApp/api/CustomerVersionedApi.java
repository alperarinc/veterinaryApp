package com.arinc.veterinaryApp.api;


import com.arinc.veterinaryApp.dto.CustomerDto;
import com.arinc.veterinaryApp.repository.CustomerRepository;
import com.arinc.veterinaryApp.service.impl.CustomerServiceImpl;
import com.arinc.veterinaryApp.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPaths.CustomerCtrl.CTRL)
@Api(value = ApiPaths.CustomerCtrl.CTRL,description = "Customer APIs")
public class CustomerVersionedApi {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;


    @GetMapping(value = "/{id}", params = "version=1")
    @ApiOperation(value = "Get By ID Operation v1", response = CustomerDto.class)
    public ResponseEntity<CustomerDto> getByIdv1(@PathVariable(value = "id",required = true)Long id) {

        CustomerDto customerDto = customerServiceImpl.getById(id);
        return ResponseEntity.ok(customerDto);


    }

    @GetMapping(value = "/{id}", params = "version=2")
    @ApiOperation(value = "Get By ID Operation v2", response = CustomerDto.class)
    public ResponseEntity<CustomerDto> getByIdv2(@PathVariable (value = "id",required = true)Long id) {
        CustomerDto customerDto = customerServiceImpl.getById(id);
        return ResponseEntity.ok(customerDto);
    }
}
