package com.sample.kafkasample.demos.producer;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @description:
 * @author: liliwen
 * @date: 2024-12-05
 */
@Slf4j
@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @SneakyThrows
    public void sendAsync(String topic, Integer partition, String key, String message) {
        kafkaTemplate.send(topic, partition, key, message)
                .addCallback(
                        result -> log.info("send success, result: {}", result),
                        e -> log.error("send failed", e));
        log.info("after async send");
        Thread.sleep(5_000);
        log.info("send async finish");
    }

    public void sendSync(String topic, Integer partition, String key, String message) {
        try {
            ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, partition, key, message);
            log.info("after sync send");
            SendResult<String, String> result = future.get();
            log.info("result: {}", result);
        } catch (Exception e) {
            log.error("send sync failed", e);
        }
        log.info("send sync finish");
    }

}
