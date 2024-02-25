package com.rgb.event;

import com.rgb.entity.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerEvent extends Event<Customer>{

}
