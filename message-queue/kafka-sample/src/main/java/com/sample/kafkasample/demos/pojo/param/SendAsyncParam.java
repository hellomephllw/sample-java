package com.sample.kafkasample.demos.pojo.param;

import lombok.Data;

/**
 * @description:
 * @author: liliwen
 * @date: 2024-12-05
 */
@Data
public class SendAsyncParam {

    private String topic;
    private Integer partition;
    private String key;
    private String message;

}
