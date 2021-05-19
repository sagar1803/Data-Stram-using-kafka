package com.trainarrival.producer;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import com.trainarrival.domain.Arrival;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TrainArrivalEventProducer {
	
	
	private String topic = "train-arrival-event";
	
	
	@Autowired
	KafkaTemplate<Integer, String> kafkaTemplate;
	
	@Autowired
	ObjectMapper objMapper;
	
	public SendResult<Integer, String> sendLibraryEvent_Approch2(Arrival arrival) throws JsonProcessingException, InterruptedException, ExecutionException {
		SendResult<Integer, String> sendResult = null;
		ProducerRecord<Integer, String> producerRecord;
        	String value = objMapper.writeValueAsString(arrival);
        	producerRecord = new ProducerRecord<Integer, String>(topic,arrival.getTrain_id(),value);	
        	sendResult = kafkaTemplate.send(producerRecord).get();
        
		return sendResult;
	}
	
	

}
