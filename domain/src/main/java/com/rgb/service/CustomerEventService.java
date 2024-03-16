package com.rgb.service;

import com.rgb.entity.Customer;

public interface CustomerEventService {
    void publish(Customer customer);
}
