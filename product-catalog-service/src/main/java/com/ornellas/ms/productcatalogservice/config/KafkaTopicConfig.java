package com.ornellas.ms.productcatalogservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Value("${spring.application.kafka.config.partitions}")
    public int partitions;

    @Value("${spring.application.kafka.config.replicas}")
    public int replicas;

    @Value("spring.application.name")
    public String applicationName;

    @Bean
    public NewTopic product(){
        return TopicBuilder
            .name(applicationName+".product")
            .partitions(partitions)
            .replicas(replicas)
            .build();
    }


}
