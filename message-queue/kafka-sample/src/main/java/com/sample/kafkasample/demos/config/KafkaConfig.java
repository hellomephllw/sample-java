package com.sample.kafkasample.demos.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

/**
 * @description:
 * @author: liliwen
 * @date: 2024-12-09
 */
@Configuration
public class KafkaConfig {

    @Primary
    @ConfigurationProperties(prefix = "spring.kafka")
    @Bean
    public KafkaProperties defaultProps() {
        return new KafkaProperties();
    }

    @ConfigurationProperties(prefix = "spring.kafka.batch-consumer")
    @Bean
    public KafkaProperties batchConsumerProps() {
        return new KafkaProperties();
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> batchConsumerListener(
            @Qualifier("batchConsumerProps") KafkaProperties batchConsumerProps) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(batchConsumerProps.buildConsumerProperties()));
        factory.setBatchListener(true);
        return factory;
    }

}
