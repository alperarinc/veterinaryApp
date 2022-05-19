package com.arinc.veterinaryApp.service;

import com.arinc.veterinaryApp.dto.CustomerDto;
import com.arinc.veterinaryApp.entity.Customer;
import com.arinc.veterinaryApp.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    CustomerDto save(CustomerDto Customer);

    CustomerDto getById(Long id);

    CustomerDto getByCustomerCode(String customerCode);

    List<Customer> getByCustomerCodeContains(String customerCode);

    TPage<CustomerDto> getAllPageable(Pageable pageable);

    Boolean delete(CustomerDto customer);

    CustomerDto update(Long id, CustomerDto customer);

}
