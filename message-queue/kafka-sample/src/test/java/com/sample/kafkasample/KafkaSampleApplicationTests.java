package com.sample.kafkasample;

import com.sample.kafkasample.demos.producer.KafkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KafkaSampleApplicationTests {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Test
    void async() {
        kafkaProducer.sendAsync("curr3", 0, "testKey", "12345");
    }

}
