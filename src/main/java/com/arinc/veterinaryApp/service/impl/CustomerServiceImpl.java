package com.arinc.veterinaryApp.service.impl;

import com.arinc.veterinaryApp.dto.CustomerDto;
import com.arinc.veterinaryApp.entity.Customer;
import com.arinc.veterinaryApp.repository.CustomerRepository;
import com.arinc.veterinaryApp.service.CustomerService;
import com.arinc.veterinaryApp.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerDto save(CustomerDto customer) {
        if (customer.getCustomerCode() == null) {
            throw new IllegalArgumentException("ProjectCode cannot be null");
        }
        Customer customerDb = modelMapper.map(customer, Customer.class);
        customerDb = customerRepository.save(customerDb);
        customer.setId(customer.getId());
        return customer;
    }

    @Override
    public CustomerDto getById(Long id) {
        Customer customer = customerRepository.getOne(id);
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public CustomerDto getByCustomerCode(String customerCode) {
        return null;
    }


    @Override
    public List<Customer> getByCustomerCodeContains(String customerCode) {
        return null;
    }

    @Override
    public TPage<CustomerDto> getAllPageable(Pageable pageable) {

        Page<Customer> data = customerRepository.findAll(pageable);
        TPage<CustomerDto> response = new TPage<>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), CustomerDto[].class)));
        return response;
    }




     @Override
    public Boolean delete(Long id) {
        return null;
    }


    @Override
    public CustomerDto update(Long id, CustomerDto customer) {
        Customer customerDb = customerRepository.getByCustomerCodeAndIdNot(customer.getCustomerCode(), id);
        if (customerDb == null) throw new IllegalArgumentException("Customer Does Not Exits ID: " + id);

        Customer customerCheck = customerRepository.getByCustomerCodeAndIdNot(customer.getCustomerCode(), id);
        if (customerCheck == null) throw new IllegalArgumentException("Customer Code Already Exits: " + id);

        customerDb.setCustomerCode(customer.getCustomerCode());
        customerCheck.setCustomerName(customer.getCustomerName());

        customerRepository.save(customerDb);
        return modelMapper.map(customerDb, CustomerDto.class);
    }
}
