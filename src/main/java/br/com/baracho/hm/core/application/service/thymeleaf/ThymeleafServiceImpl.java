package br.com.baracho.hm.core.application.service.thymeleaf;

import br.com.baracho.hm.core.application.service.thymeleaf.strategy.ThymeleafStrategy;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class ThymeleafServiceImpl implements ThymeleafService {
    private final List<ThymeleafStrategy> strategies;

    public ThymeleafServiceImpl(
        List<ThymeleafStrategy> strategies
    ) {
        this.strategies = strategies;
    }

    @Override
    public String generateContent(String templateType, Map<String, Object> variables) {
        return strategies.stream()
            .filter(strategy -> strategy.getTemplateType().equalsIgnoreCase(templateType))
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("No strategy found for template type: " + templateType))
            .generateContent(variables);
    }
}
