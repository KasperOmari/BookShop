package com.bayan.order.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "print_order")
public class PrintOrder {

    @Id
    @SequenceGenerator(name = "seq", initialValue = 100000, allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
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
