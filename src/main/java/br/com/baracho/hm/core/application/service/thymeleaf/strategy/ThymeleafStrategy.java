package br.com.baracho.hm.core.application.service.thymeleaf.strategy;

import java.util.Map;

public interface ThymeleafStrategy {
    String generateContent(Map<String, Object> variables);
    String getTemplateType();
}
