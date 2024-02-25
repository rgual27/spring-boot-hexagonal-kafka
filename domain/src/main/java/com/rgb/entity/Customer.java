package com.rgb.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Customer {

    private String id;

    private String name;

    private Date berthDay;
}
