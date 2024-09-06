package br.com.baracho.hm.infrastructure.integration.notificationManager.dto.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationInput {
    private NotificationTypeEnum notificationType;

    private String contactInfo;

    private String subject;

    private String message;
}
