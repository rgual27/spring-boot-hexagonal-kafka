package com.rgb.repository.mongodb.mapper;

import com.rgb.entity.Customer;
import com.rgb.repository.mongodb.entity.CustomerDocument;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CustomerDocumentMapper {

    CustomerDocument asCustomerDocument(Customer customer);

    Customer asCustomer(CustomerDocument customer);
}
