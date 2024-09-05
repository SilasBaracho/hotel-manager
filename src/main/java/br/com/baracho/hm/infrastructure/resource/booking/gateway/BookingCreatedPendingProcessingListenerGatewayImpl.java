package br.com.baracho.hm.infrastructure.resource.booking.gateway;

import br.com.baracho.hm.core.application.gateway.BookingCreatedPendingProcessingListenerGateway;
import br.com.baracho.hm.core.application.service.booking.BookingService;
import br.com.baracho.hm.core.domain.model.entities.BookingDomain;
import br.com.baracho.hm.infrastructure.config.kafka.avro.CreateBookingAvro;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BookingCreatedPendingProcessingListenerGatewayImpl {
    @Autowired
    private BookingService bookingService;

    @KafkaListener(
        topics = "${spring.kafka.topics.booking-created-pending-processing}",
        groupId = "${spring.kafka.consumer.group-id}"
    )
    public void execute(ConsumerRecord<String, CreateBookingAvro> data, Acknowledgment acknowledgment) throws MessagingException{
        GenericRecord record = data.value();
        var booking = bookingService.processBooking(UUID.fromString(record.get("idBooking").toString()));
        log.info(String.format("Booking confirmed, idBooking: %s, idGuest: %s", booking.getId(), booking.getIdGuest()));
        acknowledgment.acknowledge();
    }
}
