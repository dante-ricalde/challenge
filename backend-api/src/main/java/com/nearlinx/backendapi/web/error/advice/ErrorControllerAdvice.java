package com.nearlinx.backendapi.web.error.advice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ErrorControllerAdvice extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(MissingRequestValueException.class)
    public ResponseEntity<?> handleMissingRequestValueException(HttpServletRequest request, MissingRequestValueException ex) {
        return ResponseEntity.badRequest().build();
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<MultiValueMap<String, String>> handleMethodArgumentTypeMismatchException(HttpServletRequest request, MethodArgumentTypeMismatchException ex) {
        var multiValueMap = new LinkedMultiValueMap<String, String>();
        if (ex.getCause() instanceof NumberFormatException) {
            multiValueMap.add("title", BAD_REQUEST.getReasonPhrase());
            multiValueMap.add("status", String.valueOf(BAD_REQUEST.value()));
            multiValueMap.add("detail", "parameter " + ex.getPropertyName() + " must be a number.");
            multiValueMap.add("instance", request.getServletPath());
        }
        return new ResponseEntity<>(multiValueMap, null, BAD_REQUEST);
    }
}
