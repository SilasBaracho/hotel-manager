package br.com.baracho.hm.infrastructure.config.exceptionHandler;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
