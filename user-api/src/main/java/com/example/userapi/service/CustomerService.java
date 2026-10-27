package com.example.userapi.service;

import com.example.userapi.dto.CustomerRequest;
import org.springframework.stereotype.Service;

import com.example.userapi.entity.Customer;

import com.example.userapi.repository.CustomerRepository;

import com.example.userapi.exception.CustomerException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    public Customer createCustomer(CustomerRequest requestParam) {
        validateCustomer(requestParam.getName(), requestParam.getEmail());

        Customer customer = new Customer();
        customer.setName(requestParam.getName().trim());
        customer.setEmail(requestParam.getEmail().trim());

        return customerRepository.save(customer);
    }

    private void validateCustomer(String name, String email) {
        if (name == null || name.trim().isEmpty()) {
            throw new CustomerException("Customer name must not be null or empty");
        }


        if (email == null || email.trim().isEmpty()) {
            throw new CustomerException("Customer email must not be null or empty");
        }

        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        if (!email.matches(emailPattern)) {
            throw new CustomerException("Invalid email format");
        }
    }
}
