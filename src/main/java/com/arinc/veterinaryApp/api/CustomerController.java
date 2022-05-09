package com.arinc.veterinaryApp.api;


import com.arinc.veterinaryApp.dto.CustomerDto;
import com.arinc.veterinaryApp.service.impl.CustomerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerServiceImpl customerServiceImpl;


    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable("id") Long id) {
        CustomerDto customerDto = customerServiceImpl.getById(id);
        return ResponseEntity.ok(customerDto);

        //insert into customer(id,customer_name,customer_code) values (60,'deneme','test01')

    }

    @PostMapping()
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customer) {
            return ResponseEntity.ok(customerServiceImpl.save(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable(value = "id",required = true)Long id, @Valid @RequestBody CustomerDto customer){
        return ResponseEntity.ok(customerServiceImpl.update(id, customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true)Long id){
        return ResponseEntity.ok(customerServiceImpl.delete(id));
    }


}
