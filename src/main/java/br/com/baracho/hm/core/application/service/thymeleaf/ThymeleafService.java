package br.com.baracho.hm.core.application.service.thymeleaf;

import java.util.Map;

public interface ThymeleafService {
    String generateContent(String templateType, Map<String, Object> variables);
}