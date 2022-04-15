package com.arinc.veterinaryApp.service;

import com.arinc.veterinaryApp.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    Customer save(Customer Customer);

    Customer getById(Long id);

    List<Customer> getByCustomerCode(String customerCode);

    List<Customer> getByCustomerCodeContains(String customerCode);

    Page<Customer> getAllPageable(Pageable pageable);

    Boolean delete (Customer customer);

}
