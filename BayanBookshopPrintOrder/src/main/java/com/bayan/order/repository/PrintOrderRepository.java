package com.bayan.order.repository;

import com.bayan.order.entity.PrintOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrintOrderRepository extends JpaRepository<PrintOrder, Long> {

    List<PrintOrder> findByCustomerId(Long customerId);
}
