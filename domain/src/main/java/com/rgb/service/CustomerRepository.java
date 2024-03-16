package com.rgb.service;

import com.rgb.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer save(Customer customer);

    List<Customer> findAll();
}
