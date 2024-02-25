package com.rgb.service;

import com.rgb.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerEventService customerEventService;

    @Override
    public Customer save(Customer customer) {
        this.customerEventService.publish(customer);
        return customer;
    }
}
