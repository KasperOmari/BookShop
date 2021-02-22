package com.bayan.order.entity;

import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.*;
import java.util.*;

@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "print_order")
public class PrintOrder {

    @Id
    @SequenceGenerator(name="seq", initialValue=100000, allocationSize=100)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @Column(name = "id", updatable = false, nullable = false)
    @EqualsAndHashCode.Include
    private Long printOrderId;

    @Column(name = "paper_type")
    private String paperType;

    @Column(name = "paper_size")
    private String paperSize;

    @Column(name = "is_colored")
    private boolean isColored;

    @Column(name = "is_covered")
    private boolean isCovered;

    @Column(name = "cover_type")
    private String coverType;

    @Column(name = "number_copies")
    private Integer numberCopies;

    @Column(name = "note")
    private String note;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "request_date_time")
    @CreationTimestamp
    private LocalDateTime orderDateTime;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private PrintOrderStatus printOrderStatus;


    public PrintOrder() {
    }
}
