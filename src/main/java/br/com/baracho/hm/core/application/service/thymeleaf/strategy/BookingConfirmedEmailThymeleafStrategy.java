package br.com.baracho.hm.core.application.service.thymeleaf.strategy;

import br.com.baracho.hm.core.domain.model.enums.NotificationPurposeEnum;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Service
public class BookingConfirmedEmailThymeleafStrategy implements ThymeleafStrategy {
    private final TemplateEngine smsTemplateEngine;

    public BookingConfirmedEmailThymeleafStrategy(TemplateEngine smsTemplateEngine) {
        this.smsTemplateEngine = smsTemplateEngine;
    }

    @Override
    public String generateContent(Map<String, Object> variables) {
        Context context = new Context();
        context.setVariables(variables);
        return smsTemplateEngine.process("booking_confirmed", context);
    }

    @Override
    public String getTemplateType() {
        return NotificationPurposeEnum.BOOKING_CONFIRMED.getAction();
    }
}
