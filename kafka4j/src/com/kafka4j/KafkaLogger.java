package com.kafka4j;

import java.io.IOException;

public class KafkaLogger {
	private static String msgKey = "kafka4j01022017";
	private KafkaConnection kafkaConn;
	private enum Level { DEBUG, INFO, WARN, ERROR, FATAL }  

	
	public KafkaLogger() throws IOException {
		kafkaConn = new KafkaConnection();
	}
	
	public void debug(String msg) {
		sendFormattedMsg(msg, Level.DEBUG);
	}
	
	public void info(String msg) {
		sendFormattedMsg(msg, Level.INFO);
	}
	
	public void warn(String msg) {
		sendFormattedMsg(msg, Level.WARN);
	}
	
	public void error(String msg) {
		sendFormattedMsg(msg, Level.ERROR);
	}
	
	public void fatal(String msg) {
		sendFormattedMsg(msg, Level.FATAL);
	}
	
	private void sendFormattedMsg(String msg, Level level) {
		kafkaConn.send(msgKey + "." + level + "." + msg);
	}
	
	
}
