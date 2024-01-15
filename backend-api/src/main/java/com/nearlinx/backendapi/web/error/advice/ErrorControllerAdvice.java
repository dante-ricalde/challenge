package com.nearlinx.backendapi.web.error.advice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@ControllerAdvice
public class ErrorControllerAdvice extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentTypeMismatchException(HttpServletRequest request, MethodArgumentTypeMismatchException ex) {
        log.debug("handling MethodArgumentTypeMismatchException for exception", ex);
        var map = new HashMap<String, String>();
        if (ex.getCause() instanceof NumberFormatException) {
            map.put("title", BAD_REQUEST.getReasonPhrase());
            map.put("status", String.valueOf(BAD_REQUEST.value()));
            map.put("detail", "Parameter " + ex.getPropertyName() + " must be a number.");
            map.put("instance", request.getServletPath());
        }
        return new ResponseEntity<>(map, null, BAD_REQUEST);
    }
}
