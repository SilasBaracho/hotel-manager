package br.com.baracho.hm.infrastructure.integration.notificationManager;

import br.com.baracho.hm.infrastructure.integration.notificationManager.dto.input.NotificationInput;
import br.com.baracho.hm.infrastructure.integration.notificationManager.dto.input.NotificationTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationManagerClientImpl {
    @Autowired
    private NotificationManagerClient notificationManagerClient;

    public void sendNotification(
        NotificationTypeEnum notificationType,
        String contactInfo,
        String subject,
        String message
    ) {
        var notificationInput = NotificationInput.builder()
            .notificationType(notificationType)
            .subject(subject)
            .message(message)
            .contactInfo(contactInfo)
            .build();

        notificationManagerClient.publishEvent(notificationInput);
    }
}
