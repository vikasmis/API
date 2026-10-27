package com.example.userapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userapi.entity.Customer;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}