package com.rgb.service;

import com.rgb.entity.Customer;
import com.rgb.event.CustomerEvent;
import com.rgb.event.Event;
import com.rgb.event.EventType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerEventServiceImpl implements CustomerEventService {

    private final KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.customer.name}")
    private final String customerTopic;

    @Override
    public void publish(Customer customer) {
        log.info("Publishing Customer event ... with id={}, data={}",
                customer.getId(),
                customer);
        CustomerEvent customerEvent = new CustomerEvent();
        customerEvent.setData(customer);
        customerEvent.setId(UUID.randomUUID().toString());
        customerEvent.setEventType(EventType.CREATED);
        customerEvent.setDate(new Date());

        this.producer.send(customerTopic, customerEvent);
    }

    @KafkaListener(
            topics = "${topic.customer.name}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "group1"
    )
    public void consumer(Event<?> event) {
        if (event.getClass().isAssignableFrom(CustomerEvent.class)) {
            CustomerEvent customerEvent = (CustomerEvent) event;
            log.info("Received Customer event ... with id={}, data={}",
                    customerEvent.getId(),
                    customerEvent.getData());
        }
    }
}

