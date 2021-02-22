package com.bayan.order.controller;

import com.bayan.order.dto.*;
import com.bayan.order.service.*;
import lombok.extern.log4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Log4j2
@RestController
@RequestMapping("/api/print-order")
class PrintOrderController {

    private final PrintOrderService printOrderService;

    @Autowired
    PrintOrderController(PrintOrderService printOrderService) {
        this.printOrderService = printOrderService;
    }

    @GetMapping("/list")
    ResponseEntity<List<PrintOrderResponse>> all() {
        Optional<List<PrintOrderResponse>> printOrderResponse = Optional.of(printOrderService.getAllPrintOrders());

        if (printOrderResponse.isPresent()) {
            return new ResponseEntity<>(printOrderResponse.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    ResponseEntity<PrintOrderResponse> newPrintRequest(@RequestBody PrintOrderRequest printOrderRequest) {
        Optional<PrintOrderResponse> printOrderResponse = Optional.of(
                printOrderService.addNewPrintOrder(printOrderRequest));

        if (printOrderResponse.isPresent()) {
            return new ResponseEntity<>(printOrderResponse.get(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/printOrderId/{printOrderId}")
    ResponseEntity<PrintOrderResponse> one(@PathVariable Long printOrderId) {
        Optional<PrintOrderResponse> printOrderResponse = Optional.of(
                printOrderService.getPrintOrderById(printOrderId));

        if (printOrderResponse.isPresent()) {
            return new ResponseEntity<>(printOrderResponse.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customerId/{customerId}")
    ResponseEntity<List<PrintOrderResponse>> customerPrintRequests(@PathVariable Long customerId) {
        Optional<List<PrintOrderResponse>> printOrderResponses = Optional.of(
                printOrderService.getPrintOrderByCustomerId(customerId));

        if (printOrderResponses.isPresent()) {
            return new ResponseEntity<>(printOrderResponses.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    ResponseEntity<String> replacePrintRequest(@RequestBody PrintOrderRequest printOrderRequest) {
        try {
            printOrderService.updatePrintOrder(printOrderRequest);

            return new ResponseEntity<>("Print order updated", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/printOrderId/{printOrderId}")
    ResponseEntity<String> deletePrintRequest(@PathVariable Long printOrderId) {
        try {
            printOrderService.deletePrintOrder(printOrderId);

            return new ResponseEntity<>("Print order deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}