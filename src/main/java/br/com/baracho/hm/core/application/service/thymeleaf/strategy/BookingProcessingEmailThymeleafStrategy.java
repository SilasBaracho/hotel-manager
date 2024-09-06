package br.com.baracho.hm.core.application.service.thymeleaf.strategy;

import br.com.baracho.hm.core.domain.model.enums.NotificationPurposeEnum;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

public class BookingProcessingEmailThymeleafStrategy implements ThymeleafStrategy {
    private final TemplateEngine emailTemplateEngine;

    public BookingProcessingEmailThymeleafStrategy(TemplateEngine emailTemplateEngine) {
        this.emailTemplateEngine = emailTemplateEngine;
    }

    @Override
    public String generateContent(Map<String, Object> variables) {
        Context context = new Context();
        context.setVariables(variables);
        return emailTemplateEngine.process("booking_processing", context);
    }

    @Override
    public String getTemplateType() {
        return NotificationPurposeEnum.BOOKING_PROCESSING.getAction();
    }
}
