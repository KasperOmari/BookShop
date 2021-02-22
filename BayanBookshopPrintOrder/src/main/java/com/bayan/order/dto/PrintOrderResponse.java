package com.bayan.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PrintOrderResponse {

    private Long printOrderId;
    private String paperType;
    private String paperSize;
    private boolean isColored;
    private boolean isCovered;
    private String coverType;
    private Integer numberCopies;
    private String note;
    private String printOrderStatusValue;
    private Long customerId;
    private LocalDateTime orderDateTime;
}
