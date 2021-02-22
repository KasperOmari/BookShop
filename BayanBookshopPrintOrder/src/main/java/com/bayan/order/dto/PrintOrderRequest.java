package com.bayan.order.dto;

import lombok.*;
import org.springframework.stereotype.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class PrintOrderRequest {

    private Long printOrderId;
    private String paperType;
    private String paperSize;
    private boolean isColored;
    private boolean isCovered;
    private String coverType;
    private Integer numberCopies;
    private String note;
    private Long statusId;
    private Long customerId;
    private LocalDateTime orderDateTime;
}
