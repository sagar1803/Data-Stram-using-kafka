package com.app.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.app.kafka.entity.FinalResult;
import com.app.kafka.entity.TickEvent;
import com.app.kafka.repo.TickEventRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class TickEventService {
	
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    KafkaTemplate<Long,String> kafkaTemplate;

    @Autowired
    private TickEventRepo tickEventRepo;
    
    public void processTickEvent(ConsumerRecord<Integer,String> consumerRecord) throws JsonMappingException, JsonProcessingException {
    	FinalResult finalres = objectMapper.readValue(consumerRecord.value(), FinalResult.class);
    	System.out.println("tickevent - " + consumerRecord.value());
    	//tickEventRepo.save(finalres);
    }

}
