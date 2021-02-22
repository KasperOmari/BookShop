package com.bayan.order.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "print_order_status")
public class PrintOrderStatus {
    @Id
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private Long statusId;

    @Column(name = "value")
    private String value;

    public PrintOrderStatus() {
    }
}
