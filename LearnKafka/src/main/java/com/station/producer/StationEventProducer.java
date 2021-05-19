package com.station.producer;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import com.station.domain.Station;
import com.station.service.ReadCsv;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class StationEventProducer {
	
	
	private String topic = "station-events";
	
	
	@Autowired
	KafkaTemplate<Integer, String> kafkaTemplate;
	
	@Autowired
	ObjectMapper objMapper;
	
	public SendResult<Integer, String> sendLibraryEvent_Approch2() throws JsonProcessingException, InterruptedException, ExecutionException {
		ReadCsv readCSV = new ReadCsv("src/main/resources/stations.csv");
		SendResult<Integer, String> sendResult = null;
		ProducerRecord<Integer, String> producerRecord;
        List<Station> stationList = readCSV.ReadCSVFile(); //It will return the station list
        for (Object stationObject : stationList) {
        	Station stdobject = (Station) stationObject;
        	String value = objMapper.writeValueAsString(stdobject);
        	producerRecord = new ProducerRecord<Integer, String>(topic,stdobject.getStation_id(),value);	
        	sendResult = kafkaTemplate.send(producerRecord).get();
        }
        
		return sendResult;
	}
	
	

}
