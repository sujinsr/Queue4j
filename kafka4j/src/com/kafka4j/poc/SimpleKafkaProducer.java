package com.kafka4j.poc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.kafka.clients.producer.*;

public class SimpleKafkaProducer {
	public static void main(String[] args) throws Exception{
		 System.out.println("Kafka 4j write");
	      if(args.length == 0){
	          System.out.println("Enter topic name");
	          return;
	       }
	      
	       String topicName = args[0].toString();
	       
	       Properties props = new Properties();

	       props.put("bootstrap.servers", "localhost:9092");
	       props.put("acks", "all");
	       props.put("retries", 0);
	       props.put("batch.size", 16384);
	       props.put("linger.ms", 1);
	       props.put("buffer.memory", 33554432);
	       props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	       props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	       
	       Producer<String, String> producer = new KafkaProducer<String, String>(props);
	    	            
	       //for(int i = 0; i < 10; i++)
	       
	    	DateFormat df = new SimpleDateFormat("HH:mm:ss");
	    	System.out.println(df.format(new Date()));    	
	       for(int i = 0; i < 9000000; i++) {
	    	   String message = "In this tutorial, I am listing down 3 ways to know the difference between two dates in java. "
	       			+ "Fist way is to calculate using Jodatime API which was available even before java 8 release. "
	    			+ "Later 2 ways are using new Date Time API features available since java 8." + i;
	    	   
	    	   producer.send(new ProducerRecord<String, String>(topicName, message, message));
	       }
	       System.out.println(df.format(new Date()));    	

	       producer.close();
	 }
}
