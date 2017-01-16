package com.kafka4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaConnection {
	Properties props;
	Producer<String, String> producer;
	String topicName;
	
	public KafkaConnection() throws IOException {
		// load properties
		InputStream  input = new FileInputStream("kafka4j.properties");
		props =  new Properties();
		props.load(input);
		
		topicName = props.getProperty("topic.name");
		
		Properties kafkaProp = new Properties();
		kafkaProp.put("bootstrap.servers", props.get("bootstrap.servers"));
		kafkaProp.put("acks", props.get("acks"));
		kafkaProp.put("retries", props.get("retries"));
		kafkaProp.put("batch.size", props.get("batch.size"));
		kafkaProp.put("linger.ms", props.get("linger.ms"));
		kafkaProp.put("buffer.memory", props.get("buffer.memory"));
		kafkaProp.put("key.serializer", props.get("key.serializer"));
		kafkaProp.put("value.serializer", props.get("value.serializer"));

		// create producer and return to caller
		producer = new KafkaProducer<String, String>(kafkaProp);
	}
	
	public void send(String msg) {
		producer.send(new ProducerRecord<String, String>(topicName, msg, msg));
	}
	
	public void close() {
		producer.close();
	}
}
