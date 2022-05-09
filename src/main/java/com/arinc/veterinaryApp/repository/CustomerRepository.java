package com.arinc.veterinaryApp.repository;

import com.arinc.veterinaryApp.entity.Customer;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer getByCustomerCode (String customerCode);

    List<Customer> getByCustomerCodeContains(String customerCode);

    Customer getByCustomerCodeAndIdNot(String customerCode, Long id);

    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAll(Sort sort);



}
