package com.sample.kafkasample.demos.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: liliwen
 * @date: 2024-12-05
 */
@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "curr3", groupId = "group3")
    public void curr3Listener(ConsumerRecord<String, String> record) {
        log.info("curr3Listener record: {}", record);
    }

}
