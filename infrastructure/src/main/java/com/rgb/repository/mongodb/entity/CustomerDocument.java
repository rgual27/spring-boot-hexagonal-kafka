package com.rgb.repository.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = CustomerDocument.COLLECTION)
public class CustomerDocument {

    public static final String COLLECTION = "customer";

    @Id
    private String id;

    private String name;

    private Date berthDay;

}
