package com.kafkaecosystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.streams.StreamsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.support.SendResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafkaecosystem.domain.FinalResult;
import com.kafkaecosystem.domain.ListFinalResult;
import com.kafkaecosystem.producer.FinalEventProducer;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;


@SpringBootApplication
public class KafkaEcosystemApplication {
	


	public static void main(String[] args) {
		SpringApplication.run(KafkaEcosystemApplication.class, args);
		
//		FinalEventProducer fep = new FinalEventProducer();
		
		System.out.println("Hello eco");

		
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "HelloStreams");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Integer().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        
        
        StreamsBuilder builder = new StreamsBuilder();
        KStream<Integer, String> kStream = builder.stream("train-arrival-event");
        
        kStream.foreach((k, v) -> System.out.println("Key = " + k + " Value = " + v));
        
        
//        List<FinalResult> finalres = new ArrayList<>();
        
//        kStream.mapValues(value->{
//        	
//        	String[] data = value.split(",");
//        	FinalResult obj = new FinalResult();
//			obj.setStop_id(Integer.parseInt(data[0]));
//			obj.setDirection_id(data[1]);
//			obj.setStop_name(data[2]);
//			obj.setStation_name(data[3]);
//			obj.setStation_descriptive_name(data[4]);
//			obj.setStation_id(Integer.parseInt(data[5]));
//			obj.setOrder(Integer.parseInt(data[6]));
//			obj.setRed(Boolean.parseBoolean(data[7]));
//			obj.setRed(Boolean.parseBoolean(data[8]));
//			obj.setGreen(Boolean.parseBoolean(data[9]));
//			finalres.add(obj);
//			return finalres;
//        });
//        
//        ListFinalResult listFinalRes = new ListFinalResult();
//        listFinalRes.setFinalResList(finalres);
        
//        try {
//			SendResult<Integer, String> sendResult = fep.sendLibraryEvent_Approch2(listFinalRes);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
        //kStream.peek((k, v) -> System.out.println("Key = " + k + " Value = " + v));
        Topology topology = builder.build();

        KafkaStreams streams = new KafkaStreams(topology, props);

        System.out.println("Starting the stream");
        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        	System.out.println("Stopping Stream");
            streams.close();
        }));
        
	}

}
