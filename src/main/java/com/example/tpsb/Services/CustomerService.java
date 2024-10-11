package com.example.tpsb.Services;

import com.example.tpsb.Models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {


    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(Long id);

    Optional<Customer> getCustomerByName(String name);

    Optional<Customer> getCustomerByEmail(String email);

    Customer saveCustomer(Customer customer);

    void deleteCustomerById(Long id);

    void deleteCustomerByName(String name);

    void deleteCustomerByEmail(String email);
}
