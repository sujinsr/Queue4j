package com.kafka4j;

import java.io.IOException;

public class KafkaLogger {
	KafkaConnection kafkaConn;
	
	public KafkaLogger() throws IOException {
		kafkaConn = new KafkaConnection();
	}
	
	public void debug(String msg) {
		sendFormattedMsg(msg);
	}
	
	public void info(String msg) {
		sendFormattedMsg(msg);
	}
	
	public void warn(String msg) {
		sendFormattedMsg(msg);
	}
	
	public void error(String msg) {
		sendFormattedMsg(msg);
	}
	
	public void fatal(String msg) {
		sendFormattedMsg(msg);
	}
	
	private void sendFormattedMsg(String msg) {
		
	}
	
	
}
