package com.bayan.order.dto.mapper;

import com.bayan.order.dto.*;
import com.bayan.order.entity.*;
import com.bayan.order.repository.*;
import org.mapstruct.*;
import org.mapstruct.factory.*;

import java.util.*;

@Mapper(componentModel = "spring")
public interface PrintOrderMapper {

    PrintOrderMapper INSTANCE = Mappers.getMapper(PrintOrderMapper.class);

    @Mapping(target = "printOrderStatusValue", source = "printOrderStatus.value")
    PrintOrderResponse printOrderToPrintOrderResponse(PrintOrder printOrder);

    @Mapping(target = "printOrderStatus.statusId", source = "statusId")
    PrintOrder printOrderRequestToPrintOrder(PrintOrderRequest printOrderRequest);

    List<PrintOrderResponse> printOrderToPrintOrderResponse(List<PrintOrder> printOrders);
}
