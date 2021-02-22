package com.bayan.order.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
