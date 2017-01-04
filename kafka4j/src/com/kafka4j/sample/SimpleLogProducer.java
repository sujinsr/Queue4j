package com.kafka4j.sample;

import java.io.IOException;

import com.kafka4j.Kafka4j;
import com.kafka4j.KafkaLogger;

public class SimpleLogProducer {
	public static void main(String[] args) throws IOException {
		System.out.println("Start");
		KafkaLogger log = Kafka4j.getKafkaLogger(SimpleLogProducer.class.getName());
		log.debug("TestMessage");
		System.out.println("end");
	}
}
