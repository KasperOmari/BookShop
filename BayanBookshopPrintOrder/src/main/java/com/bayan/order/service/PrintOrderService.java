package com.bayan.order.service;

import com.bayan.order.dto.PrintOrderRequest;
import com.bayan.order.dto.PrintOrderResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrintOrderService {

    List<PrintOrderResponse> getAllPrintOrders();

    PrintOrderResponse getPrintOrderById(Long printOrderId);

    List<PrintOrderResponse> getPrintOrderByCustomerId(Long customerId);

    PrintOrderResponse addNewPrintOrder(PrintOrderRequest printOrderRequest);

    void updatePrintOrder(PrintOrderRequest printOrderRequest);

    void deletePrintOrder(Long printOrderId);
}
