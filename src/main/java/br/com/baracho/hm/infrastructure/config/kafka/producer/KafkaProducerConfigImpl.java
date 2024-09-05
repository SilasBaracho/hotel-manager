package br.com.baracho.hm.infrastructure.config.kafka.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

public class KafkaProducerConfigImpl<T> implements KafkaProducerConfig<T> {
    private final KafkaProperties kafkaProperties;
    private final String topic;
    private final String schemaRegistryUrl;

    public KafkaProducerConfigImpl(KafkaProperties kafkaProperties, String topic, String schemaRegistryUrl) {
        this.kafkaProperties = kafkaProperties;
        this.topic = topic;
        this.schemaRegistryUrl = schemaRegistryUrl;
    }

    @Override
    public ProducerFactory<String, T> producerFactory() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, kafkaProperties.getProducer().getKeySerializer());
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, kafkaProperties.getProducer().getValueSerializer());
        configs.put("schema.registry.url", schemaRegistryUrl);
        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Override
    public KafkaTemplate<String, T> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Override
    public NewTopic createTopic() {
        return new NewTopic(topic, 3, (short) 1);
    }
}
