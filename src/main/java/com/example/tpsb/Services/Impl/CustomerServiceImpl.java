package com.example.tpsb.Services.Impl;

import com.example.tpsb.Models.Customer;
import com.example.tpsb.Services.CustomerService;
import com.example.tpsb.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> getCustomerByName(String name) {
        return customerRepository.getCustomerByName(name);
    }

    @Override
    public Optional<Customer> getCustomerByEmail(String email) {
        return customerRepository.getCustomerByEmail(email);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void deleteCustomerByName(String name) {
        customerRepository.deleteCustomerByName(name);
    }

    @Override
    public void deleteCustomerByEmail(String email) {
        customerRepository.deleteCustomerByEmail(email);
    }
}
