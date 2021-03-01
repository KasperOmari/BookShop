package com.bayan.order.controller;

import com.bayan.order.dto.PrintOrderRequest;
import com.bayan.order.dto.PrintOrderResponse;
import com.bayan.order.service.PrintOrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
        List<PrintOrderResponse> printOrderResponse = printOrderService.getAllPrintOrders();

        return new ResponseEntity<>(printOrderResponse, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<PrintOrderResponse> newPrintRequest(@RequestBody PrintOrderRequest printOrderRequest) {
        PrintOrderResponse printOrderResponse = printOrderService.addNewPrintOrder(printOrderRequest);

        return new ResponseEntity<>(printOrderResponse, HttpStatus.CREATED);
    }

    @GetMapping("/printOrderId/{printOrderId}")
    ResponseEntity<PrintOrderResponse> one(@PathVariable Long printOrderId) {
        PrintOrderResponse printOrderResponse = printOrderService.getPrintOrderById(printOrderId);

        return new ResponseEntity<>(printOrderResponse, HttpStatus.OK);
    }

    @GetMapping("/customerId/{customerId}")
    ResponseEntity<List<PrintOrderResponse>> customerPrintRequests(@PathVariable Long customerId) {
        List<PrintOrderResponse> printOrderResponses = printOrderService.getPrintOrderByCustomerId(customerId);

        return new ResponseEntity<>(printOrderResponses, HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<String> replacePrintRequest(@RequestBody PrintOrderRequest printOrderRequest) {
        printOrderService.updatePrintOrder(printOrderRequest);

        return new ResponseEntity<>("Print order updated", HttpStatus.OK);
    }

    @DeleteMapping("/printOrderId/{printOrderId}")
    ResponseEntity<String> deletePrintRequest(@PathVariable Long printOrderId) {
        printOrderService.deletePrintOrder(printOrderId);

        return new ResponseEntity<>("Print order deleted", HttpStatus.OK);
    }
}
// TODO: 2/23/21 add status not available exception and print logs 