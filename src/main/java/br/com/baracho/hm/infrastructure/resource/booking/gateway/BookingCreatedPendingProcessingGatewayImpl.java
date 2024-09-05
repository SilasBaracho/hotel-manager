package br.com.baracho.hm.infrastructure.resource.booking.gateway;

import br.com.baracho.hm.core.application.gateway.BookingCreatedPendingProcessingGateway;
import br.com.baracho.hm.core.domain.model.entities.BookingDomain;
import br.com.baracho.hm.data.mapper.BookingMapper;
import br.com.baracho.hm.infrastructure.config.kafka.avro.CreateBookingAvro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class BookingCreatedPendingProcessingGatewayImpl implements BookingCreatedPendingProcessingGateway<CreateBookingAvro> {
    @Autowired
    private BookingMapper bookingMapper;
    @Autowired
    private KafkaTemplate<String, CreateBookingAvro> kafkaTemplate;
    @Value("${spring.kafka.topics.booking-created-pending-processing}")
    private String topic;

    @Override
    public void execute(BookingDomain bookingDomain) {
        var messageAvro = new CreateBookingAvro(bookingDomain.getId().toString());

        CompletableFuture<SendResult<String, CreateBookingAvro>> future = kafkaTemplate.send(topic, messageAvro);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message=[" + messageAvro + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                log.info("Unable to send message=[" + messageAvro + "] due to : " + ex.getMessage());
            }
        });
    }
}
