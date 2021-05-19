package com.station.controller;

import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.station.producer.StationEventProducer;

@RestController
public class LibraryEventsController {
	
	@Autowired
	StationEventProducer stationEventProducer;
	
	Logger log = Logger.getLogger(LibraryEventsController.class.getName());
	
	@PostMapping("v1/stationevent")
	public ResponseEntity<?> postLibraryEvent()
	{
		
		log.info("Before Message Sending");
		//invoke kafka producer
		try {
			SendResult<Integer, String> sendres= stationEventProducer.sendLibraryEvent_Approch2();
			log.info("SendResult is " + sendres.toString());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("After Message Sending");
		return ResponseEntity.status(HttpStatus.CREATED).body("Csv data posted successfully to kafka");
	}
	
	
}
