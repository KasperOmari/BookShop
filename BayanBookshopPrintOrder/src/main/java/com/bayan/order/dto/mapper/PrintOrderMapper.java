package com.bayan.order.dto.mapper;

import com.bayan.order.dto.PrintOrderRequest;
import com.bayan.order.dto.PrintOrderResponse;
import com.bayan.order.entity.PrintOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrintOrderMapper {

    PrintOrderMapper INSTANCE = Mappers.getMapper(PrintOrderMapper.class);

    @Mapping(target = "printOrderStatusValue", source = "printOrderStatus.value")
    PrintOrderResponse printOrderToPrintOrderResponse(PrintOrder printOrder);

    @Mapping(target = "printOrderStatus.statusId", source = "statusId")
    PrintOrder printOrderRequestToPrintOrder(PrintOrderRequest printOrderRequest);

    List<PrintOrderResponse> printOrderToPrintOrderResponse(List<PrintOrder> printOrders);
}
