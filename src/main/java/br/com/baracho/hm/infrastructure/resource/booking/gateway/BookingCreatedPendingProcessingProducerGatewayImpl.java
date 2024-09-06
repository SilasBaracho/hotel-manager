package br.com.baracho.hm.infrastructure.resource.booking.gateway;

import br.com.baracho.hm.core.application.gateway.BookingCreatedPendingProcessingProducerGateway;
import br.com.baracho.hm.core.application.service.thymeleaf.ThymeleafService;
import br.com.baracho.hm.core.domain.model.entities.BookingDomain;
import br.com.baracho.hm.core.domain.model.enums.NotificationPurposeEnum;
import br.com.baracho.hm.data.mapper.BookingMapper;
import br.com.baracho.hm.infrastructure.config.kafka.avro.CreateBookingAvro;
import br.com.baracho.hm.infrastructure.integration.notificationManager.NotificationManagerClientImpl;
import br.com.baracho.hm.infrastructure.integration.notificationManager.dto.input.NotificationTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class BookingCreatedPendingProcessingProducerGatewayImpl implements BookingCreatedPendingProcessingProducerGateway<CreateBookingAvro> {
    @Autowired
    private BookingMapper bookingMapper;
    @Autowired
    private KafkaTemplate<String, CreateBookingAvro> kafkaTemplate;
    @Autowired
    private NotificationManagerClientImpl notificationManagerClient;
    @Autowired
    private ThymeleafService thymeleafService;
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

        notificationManagerClient.sendNotification(
            NotificationTypeEnum.EMAIL,
            bookingDomain.getGuestEmail(),
            NotificationPurposeEnum.BOOKING_PROCESSING.getSubject(),
            thymeleafService.generateContent(
                NotificationPurposeEnum.BOOKING_PROCESSING.getAction(),
                Map.of("idBooking", bookingDomain.getId())
            )
        );
    }
}
