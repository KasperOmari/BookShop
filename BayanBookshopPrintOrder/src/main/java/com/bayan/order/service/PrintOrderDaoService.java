package com.bayan.order.service;

import com.bayan.order.dto.PrintOrderRequest;
import com.bayan.order.dto.PrintOrderResponse;
import com.bayan.order.dto.mapper.PrintOrderMapper;
import com.bayan.order.entity.PrintOrder;
import com.bayan.order.exception.PrintOrderNotFoundException;
import com.bayan.order.repository.PrintOrderRepository;
import com.bayan.order.repository.PrintOrderStatusRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Primary
@Component
public class PrintOrderDaoService implements PrintOrderService {

    private final PrintOrderRepository printOrderRepository;
    private final PrintOrderStatusRepository printOrderStatusRepository;

    public PrintOrderDaoService(PrintOrderRepository repository,
                                PrintOrderStatusRepository printOrderStatusRepository) {
        this.printOrderRepository = repository;
        this.printOrderStatusRepository = printOrderStatusRepository;
    }

    public List<PrintOrderResponse> getAllPrintOrders() {
        return PrintOrderMapper.INSTANCE.printOrderToPrintOrderResponse(printOrderRepository.findAll());
    }

    public PrintOrderResponse getPrintOrderById(Long printOrderId) {
        return PrintOrderMapper.INSTANCE.printOrderToPrintOrderResponse(printOrderRepository.findById(printOrderId)
                .orElseThrow(() -> new PrintOrderNotFoundException(printOrderId)));
    }

    public List<PrintOrderResponse> getPrintOrderByCustomerId(Long customerId) {
        return PrintOrderMapper.INSTANCE.printOrderToPrintOrderResponse(
                printOrderRepository.findByCustomerId(customerId));
    }

    public PrintOrderResponse addNewPrintOrder(PrintOrderRequest printOrderRequest) {
        return PrintOrderMapper.INSTANCE.printOrderToPrintOrderResponse(
                printOrderRepository.save(PrintOrderMapper.INSTANCE.printOrderRequestToPrintOrder(printOrderRequest)));
    }

    public void updatePrintOrder(PrintOrderRequest printOrderRequest) {
        PrintOrder newPrintOrder = PrintOrderMapper.INSTANCE.printOrderRequestToPrintOrder(printOrderRequest);
        if (printOrderRepository.existsById(printOrderRequest.getPrintOrderId())) {
            printOrderRepository.save(newPrintOrder);
        } else {
            throw new PrintOrderNotFoundException(printOrderRequest.getPrintOrderId());
        }
    }

    public void deletePrintOrder(Long printOrderId) {
        printOrderRepository.deleteById(printOrderId);
    }
}
