package com.kafka4j.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Kafka4jClient {

	public static void main(String[] args) throws IOException {
        KafkaConsumer<String, String> consumer;
        
        InputStream input = new FileInputStream("kafka4jClient.properties");
        Properties props = new Properties();
        props.load(input);
        
        consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList("test"));
        
        while(true) {
        	ConsumerRecords<String, String> records = consumer.poll(100);
        	for (ConsumerRecord<String, String> record : records) {
        		if (record.topic().equals("test")) {
        			System.out.println(record.value());
        			
        		}
        	}
        }
	}

}
