package br.com.baracho.hm.infrastructure.config.exceptionHandler.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record StandardError<T>(
    @JsonProperty("status")
    int status,
    @JsonProperty("error")
    String error,
    @JsonProperty("message")
    String message,
    @JsonProperty("path")
    String path,
    @JsonProperty("timeStamp")
    LocalDateTime timeStamp
) {
    @Override
    public String toString(){
        return String.format("(status=%d, message='%s', error=%s, timeStamp=%s, path='%s')", status, message, error, timeStamp, path);
    }

}
