package com.arinc.veterinaryApp.service.impl;

import com.arinc.veterinaryApp.dto.CustomerDto;
import com.arinc.veterinaryApp.entity.Customer;
import com.arinc.veterinaryApp.entity.User;
import com.arinc.veterinaryApp.repository.CustomerRepository;
import com.arinc.veterinaryApp.repository.UserRepository;
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
    private final UserRepository userRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;

    }

    @Override
    public CustomerDto save(CustomerDto customer) {

        Customer customerCheck = customerRepository.getByCustomerCode(customer.getCustomerCode());
        if (customerCheck != null) throw new IllegalArgumentException("ProjectCode Already Exist");

        Customer customerDb = modelMapper.map(customer, Customer.class);
        User user = userRepository.getOne(customer.getManagerId());
        customerDb.setManager(user);

        customerDb = customerRepository.save(customerDb);
        customer.setId(customerDb.getId());
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
    public Boolean delete(CustomerDto customer) {
        return null;
    }

    public Boolean delete(Long id) {
        customerRepository.deleteById(id);
        return true;
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


    public List<CustomerDto> getAll() {
        List<Customer> data = customerRepository.findAll();
        return Arrays.asList(modelMapper.map(data, CustomerDto[].class));

    }
}
