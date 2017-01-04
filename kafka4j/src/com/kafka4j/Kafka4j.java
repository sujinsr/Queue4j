package com.kafka4j;

import java.io.IOException;
import java.util.HashMap;

public class Kafka4j {
	private static HashMap<String, KafkaLogger> loggerMap;
	static
	{
		System.out.println("Hash map initialized");
		loggerMap = new HashMap<String, KafkaLogger>();
	}
	
	public static KafkaLogger getKafkaLogger(String className) throws IOException {
		KafkaLogger kafkaLogger = null;
		if (loggerMap.containsKey(className)) {
			kafkaLogger = loggerMap.get(className);
		} else {
			kafkaLogger = new KafkaLogger();
			loggerMap.put(className, kafkaLogger);
		}
		
		return kafkaLogger;
	}

}
