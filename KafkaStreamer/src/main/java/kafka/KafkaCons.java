package kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;


import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class KafkaCons {
    public static void main(String args[]) {
        final Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG,
                "KafkaExampleConsumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());

        props.setProperty(ConsumerConfig.GROUP_ID_CONFIG,"Eleventh");
        props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");

        org.apache.kafka.clients.consumer.KafkaConsumer<String,String> consumer=new KafkaConsumer(props);

        consumer.subscribe(Arrays.asList("Stream"));
        while(true)
        {
            ConsumerRecords<String,String> records= consumer.poll(Duration.ofMillis(100));
            for(ConsumerRecord record:records)
            {
                System.out.println("Value "+record.value());


            }
        }
    }
}
