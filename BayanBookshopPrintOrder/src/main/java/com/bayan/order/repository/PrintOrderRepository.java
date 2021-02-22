package com.bayan.order.repository;

import com.bayan.order.entity.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface PrintOrderRepository extends JpaRepository<PrintOrder, Long> {

    List<PrintOrder> findByCustomerId(Long customerId);
}
