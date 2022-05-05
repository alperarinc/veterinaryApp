package com.arinc.veterinaryApp.service.impl;

import com.arinc.veterinaryApp.entity.Customer;
import com.arinc.veterinaryApp.repository.CustomerRepository;
import com.arinc.veterinaryApp.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        if(customer.getCustomerCode()==null){
            throw new IllegalArgumentException("ProjectCode cannot be null");
        }
        customer = customerRepository.save(customer);

        return customer;
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public List<Customer> getByCustomerCode(String customerCode) {

        return null;
    }

    @Override
    public List<Customer> getByCustomerCodeContains(String customerCode) {
        return null;
    }

    @Override
    public Page<Customer> getAllPageable(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Customer customer) {
        return null;
    }
}
