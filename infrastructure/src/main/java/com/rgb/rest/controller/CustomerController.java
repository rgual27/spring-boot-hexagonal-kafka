package com.rgb.rest.controller;

import com.rgb.entity.Customer;
import com.rgb.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer customer) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.customerService.save(customer));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.customerService.findAll());
    }
}
