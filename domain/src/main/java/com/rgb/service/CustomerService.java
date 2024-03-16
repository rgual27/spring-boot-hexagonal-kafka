package com.rgb.service;

import com.rgb.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer) throws Exception;

    List<Customer> findAll();
}
