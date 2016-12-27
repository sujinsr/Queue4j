# Why this project ?
  When developing large enterprise application in Java, developer has to give more importance to application logging this helps to analyse the system in production. Most of the Java application uses apache's log4j as logging library, which write logs to disk file.
  
  Intension of this project is to decouple the logs write from application, means instead of writing logs to disk using log4j libraries, write the logs to local/remote queue(kafk, jms, or rabitmq). Then the seperate listner read the logs from queue and write to the disk. 
  
  This gives the more flexibility to run multiple listener with different log4j.properties file. Also can able to write seperate listener which reads logs from queue and create log viewer web application or store the logs to databases.


