package com.bayan.order.exception;

public class PrintOrderNotFoundException extends RuntimeException {
    public PrintOrderNotFoundException(Long id) {
        super("Could not find print request " + id);
    }
}
