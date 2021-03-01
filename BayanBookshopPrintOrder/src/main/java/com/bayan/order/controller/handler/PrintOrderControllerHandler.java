package com.bayan.order.controller.handler;

import com.bayan.order.exception.PrintOrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PrintOrderControllerHandler {

    @ExceptionHandler(value = PrintOrderNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String deniedPermissionException(PrintOrderNotFoundException errorException) {
        return errorException.getMessage();
    }
}
