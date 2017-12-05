package com.rpm.demo.mq;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * Created by renpiming on 2017/12/5.
 */
public class MyKafaProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++)
            producer.send(new ProducerRecord("my-topic", Integer.toString(i), Integer.toString(i)), new Callback() {
                        public void onCompletion(RecordMetadata metadata, Exception e) {
                            if (e != null) {
                                e.printStackTrace();
                            } else {
                               // System.out.println("The offset of the record we just sent is: " + metadata.offset());
                            }
                        }
                    }
            );

        producer.close();
    }
}
