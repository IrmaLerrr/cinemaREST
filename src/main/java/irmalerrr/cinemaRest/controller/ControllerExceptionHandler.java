package irmalerrr.cinemaRest.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<CustomErrorMessage> handleResponseStatusException(
            ResponseStatusException e, WebRequest request) {

        CustomErrorMessage body = new CustomErrorMessage(
                e.getReason());

        return new ResponseEntity<>(body, e.getStatusCode());
    }

    @Data
    @AllArgsConstructor
    public static class CustomErrorMessage {
        @JsonProperty("error")
        private String message;
    }
}
