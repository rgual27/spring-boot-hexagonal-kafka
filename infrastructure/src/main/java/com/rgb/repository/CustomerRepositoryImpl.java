package com.rgb.repository;

import com.rgb.entity.Customer;
import com.rgb.repository.mongodb.repository.CustomerMongoRepository;
import com.rgb.repository.mongodb.mapper.CustomerDocumentMapper;
import com.rgb.service.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerMongoRepository customerMongoRepository;

    private final CustomerDocumentMapper customerDocumentMapper;

    @Override
    public Customer save(Customer customer) {
        return Optional.of(this.customerMongoRepository.save(this.customerDocumentMapper.asCustomerDocument(customer)))
                .map(this.customerDocumentMapper::asCustomer)
                .orElseThrow(() -> new RuntimeException("Error creating"));
    }

    @Override
    public List<Customer> findAll() {
        return this.customerMongoRepository.findAll()
                .stream().map(this.customerDocumentMapper::asCustomer).toList();
    }
}
