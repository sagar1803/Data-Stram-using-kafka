package com.kafkaecosystem.producer;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkaecosystem.domain.FinalResult;
import com.kafkaecosystem.domain.ListFinalResult;



public class FinalEventProducer {

	private String topic = "final-result-events";
	
	
	@Autowired
	KafkaTemplate<Integer, String> kafkaTemplate;
	
	@Autowired
	ObjectMapper objMapper;
	
	public SendResult<Integer, String> sendLibraryEvent_Approch2(ListFinalResult listFinalResult) throws JsonProcessingException, InterruptedException, ExecutionException {
		SendResult<Integer, String> sendResult = null;
		ProducerRecord<Integer, String> producerRecord;
        for (Object finalObject : listFinalResult.getFinalResList()) {
        	FinalResult frdobject = (FinalResult) finalObject;
        	String value = objMapper.writeValueAsString(frdobject);
        	producerRecord = new ProducerRecord<Integer, String>(topic,frdobject.getStation_id(),value);	
        	sendResult = kafkaTemplate.send(producerRecord).get();
        }
        
		return sendResult;
	}
	
}
