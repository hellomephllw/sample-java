package com.sample.kafkasample.demos.controller;

import com.sample.kafkasample.demos.pojo.param.SendAsyncParam;
import com.sample.kafkasample.demos.pojo.param.SendSyncParam;
import com.sample.kafkasample.demos.producer.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: liliwen
 * @date: 2024-12-05
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/sendAsync")
    public String sendAsync(@RequestBody SendAsyncParam param) {
        kafkaProducer.sendAsync(param.getTopic(), param.getPartition(), param.getKey(), param.getMessage());
        return "success";
    }

    @PostMapping("/sendSync")
    public String sendSync(@RequestBody SendSyncParam param) {
        kafkaProducer.sendSync(param.getTopic(), param.getPartition(), param.getKey(), param.getMessage());
        return "success";
    }

    @PostMapping("/sendBatch")
    public String sendBatch() {
        kafkaProducer.sendBatch();
        return "success";
    }

}
