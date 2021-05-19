package com.app.kafka.consumer;

import com.app.kafka.service.TickEventService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TickEventConsumer {

    @Autowired
    private TickEventService tickeEventService;
    
    
    @KafkaListener(topics = {"train-arrival-event"})
    public void onMessage(ConsumerRecord<Integer,String> consumerRecord) throws JsonProcessingException {
        System.out.println("ConsumerRecord : = " + consumerRecord );
        //tickeEventService.processTickEvent(consumerRecord);
        System.out.println(consumerRecord.value());
        

    }
}
