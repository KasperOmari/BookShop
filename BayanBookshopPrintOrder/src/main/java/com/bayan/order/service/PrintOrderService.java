package com.bayan.order.service;

import com.bayan.order.dto.*;
import com.bayan.order.entity.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public interface PrintOrderService {

    List<PrintOrderResponse> getAllPrintOrders();

    PrintOrderResponse getPrintOrderById(Long printOrderId);

    List<PrintOrderResponse> getPrintOrderByCustomerId(Long customerId);

    PrintOrderResponse addNewPrintOrder(PrintOrderRequest printOrderRequest);

    void updatePrintOrder(PrintOrderRequest printOrderRequest);

    void deletePrintOrder(Long printOrderId);
}
