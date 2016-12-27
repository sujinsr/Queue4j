package log4jtest;

import java.time.LocalTime;

import org.apache.log4j.Logger;

public class Log4jTest 
{
	static Logger log = Logger.getLogger(Log4jTest.class.getName());
	
    public static void main( String[] args )
    {
    	System.out.println("Log 4j write");
    	LocalTime earlier = LocalTime.now();
    	System.out.println(earlier);
    	
    	for(int i = 0; i < 1000000; i++) {
    		log.info("In this tutorial, I am listing down 3 ways to know the difference between two dates in java. "
    				+ "Fist way is to calculate using Jodatime API which was available even before java 8 release. "
    				+ "Later 2 ways are using new Date Time API features available since java 8.");
    	}
    	
    	LocalTime latest = LocalTime.now();
    	System.out.println(latest);
    }
}
