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
public class DefaultConsumer {

    @KafkaListener(topics = "test1", groupId = "group1")
    public void test1Listener(ConsumerRecord<String, String> record) {
        log.info("test1Listener record: {}", record);
    }

}
