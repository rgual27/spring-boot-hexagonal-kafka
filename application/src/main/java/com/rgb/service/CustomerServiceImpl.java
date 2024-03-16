package com.rgb.service;

import com.rgb.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerEventService customerEventService;

    @Override
    @Transactional
    public Customer save(Customer customer) throws Exception {
        Customer savedCustomer = customerRepository.save(customer);
        customerEventService.publish(savedCustomer);
        return customer;
    }

    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }
}
