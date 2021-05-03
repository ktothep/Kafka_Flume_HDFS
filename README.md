# Kafka_Flume_HDFS

This Project takes the messages that have been published on the Kafka Topic Stream and stores them in HDFS.
The configuration for Flume aare stored in Flume.conf file which has the Sink,Channel and Source.
I have also created the KAFKA Producer and Consumer but in this case we are only making use of the KAFKA Producer.

Pre-Requisite:
1.Make sure Hadoop is up and Running
2.Make sure Kafka is up and running
3.Change the parameters in Kafka Producers and Flume.conf as per your requirement
4.Flume should be available on your Machine

Note: In your Flume Directory please check the Guava.jar version which is present.If it is Version 11 please replace it with Version 27.Flume with Version 11 
has some bug

Working:

1. Run apache flume with the below command:

flume-ng agent -n flume1 -f flume.conf -conf conf  —Dflume.root.logger=INFO,console

where n = agent anme
      f = path of flume.conf
      c = flume configuration
      

2. Start the Kafka Producer on your system.By Default it will be publishing "Hello" on topic "Stream"

The path for HDFS  is given in flume.conf
