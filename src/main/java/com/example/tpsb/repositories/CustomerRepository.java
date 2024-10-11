package com.example.tpsb.repositories;

import com.example.tpsb.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> getCustomerByName(String name);
    Optional<Customer> getCustomerByEmail(String email);

    void deleteCustomerByName(String name);
    void deleteCustomerByEmail(String email);
}
