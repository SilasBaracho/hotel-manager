package br.com.baracho.hm.infrastructure.config.kafka.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

public interface KafkaProducerConfig<T> {
    ProducerFactory<String, T> producerFactory();
    KafkaTemplate<String, T> kafkaTemplate();
    NewTopic createTopic();
}