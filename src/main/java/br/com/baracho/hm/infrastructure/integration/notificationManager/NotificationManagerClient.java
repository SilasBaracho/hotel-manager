package br.com.baracho.hm.infrastructure.integration.notificationManager;

import br.com.baracho.hm.infrastructure.integration.notificationManager.dto.input.NotificationInput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-manager-client", url = "${feign.integration.notification-manager}")
public interface NotificationManagerClient {
    @PostMapping("/notification-manager")
    void publishEvent(@RequestBody NotificationInput notificationInput);
}
