package com.trainarrival.controller;

import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.trainarrival.producer.TrainArrivalEventProducer;
import com.trainarrival.domain.Arrival;

@RestController
public class TrainArrivalEventsController {
	
	@Autowired
	TrainArrivalEventProducer stationEventProducer;
	
	Logger log = Logger.getLogger(TrainArrivalEventsController.class.getName());
	
	@PostMapping("v1/arrivalevent")
	public ResponseEntity<?> postLibraryEvent(@RequestBody Arrival arrival)
	{
		
		log.info("Before Message Sending");
		//invoke kafka producer
		try {
			SendResult<Integer, String> sendres= stationEventProducer.sendLibraryEvent_Approch2(arrival);
			log.info("SendResult is " + sendres.toString());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("After Message Sending");
		return ResponseEntity.status(HttpStatus.CREATED).body(arrival);
	}
	
	
}
