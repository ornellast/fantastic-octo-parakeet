package com.ornellas.ms.productcatalogservice.config;

import com.ornellas.ms.productcatalogservice.kafka.publisher.ProductPublisher;
import org.apache.kafka.clients.admin.NewTopic;
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

    @Bean
    public NewTopic product(){
        return TopicBuilder
            .name(ProductPublisher.PRODUCT_TOPIC)
            .partitions(partitions)
            .replicas(replicas)
            .build();
    }


}
