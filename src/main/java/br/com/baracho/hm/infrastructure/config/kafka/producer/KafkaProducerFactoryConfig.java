package br.com.baracho.hm.infrastructure.config.kafka.producer;

import br.com.baracho.hm.infrastructure.config.kafka.avro.CreateBookingAvro;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerFactoryConfig {
    @Autowired
    private KafkaProperties kafkaProperties;
    @Value("${spring.kafka.producer.properties.schema.registry.url}")
    private String schemaRegistryUrl;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        return new KafkaAdmin(configs);
    }

    @Bean
    public KafkaProducerConfig<CreateBookingAvro> bookingCreatedKafkaTopicConfig(
        @Value("${spring.kafka.topics.booking-created-pending-processing}") String topic
    ) {
        return new KafkaProducerConfigImpl<>(kafkaProperties, topic, schemaRegistryUrl);
    }

}
