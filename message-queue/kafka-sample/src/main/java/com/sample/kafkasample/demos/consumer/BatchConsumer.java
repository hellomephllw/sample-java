package com.sample.kafkasample.demos.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: liliwen
 * @date: 2024-12-09
 */
@Slf4j
@Component
public class BatchConsumer {

    @KafkaListener(
            containerFactory = "batchConsumerListener",
            topics = "test1",
            groupId = "batch-consumer")
    public void batchConsumer(List<ConsumerRecord<String, String>> records) {
        log.info("batchConsumer records: {}", records);
    }

}
